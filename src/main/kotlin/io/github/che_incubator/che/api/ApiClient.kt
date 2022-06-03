package io.github.che_incubator.che.api

import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate
import io.kubernetes.client.util.ClientBuilder
import io.kubernetes.client.openapi.Configuration as k8sConfiguration

object ApiClient {

    private val k8sApi = ClientBuilder.cluster().build()
    private val devfileController: DevfileController

    init {
        k8sConfiguration.setDefaultApiClient(k8sApi)

        this.devfileController = DevfileController(
            DevfileContentProvider(
                IODevfileContent(Configuration.devWorkspaceFlattenedDevfilePath),
                DevfileContentParser(Configuration.devWorkspaceFlattenedDevfileParsingStrategy)
            ),
            K8sDevfileContentRetainer(k8sApi)
        )
    }

    object DevfileClient {
        fun getRawContent(): ByteArray {
            return devfileController.getRawContent()
        }

        fun getTemplateObject(): V1alpha2DevWorkspaceSpecTemplate {
            return devfileController.getTemplateObject()
        }

        fun retainTemplateObject(templateObject: V1alpha2DevWorkspaceSpecTemplate) {
            devfileController.retainTemplateObject(templateObject)
        }
    }

}