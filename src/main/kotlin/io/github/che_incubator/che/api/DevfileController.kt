package io.github.che_incubator.che.api

import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate

class DevfileController(
    private val devfileContentProvider: DevfileContentProvider,
    private val devfileContentRetainer: DevfileContentRetainer
) {

    fun getRawContent(): ByteArray {
        return devfileContentProvider.getDevfileContent()
    }

    fun getTemplateObject(): V1alpha2DevWorkspaceSpecTemplate {
        return devfileContentProvider.getDevfileContentParser().parseTemplateObject(getRawContent())
    }

    fun retainTemplateObject(templateObject: V1alpha2DevWorkspaceSpecTemplate) {
        devfileContentRetainer.retainTemplateObject(templateObject)
    }

}