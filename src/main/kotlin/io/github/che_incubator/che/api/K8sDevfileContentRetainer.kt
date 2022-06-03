package io.github.che_incubator.che.api

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate
import io.kubernetes.client.openapi.ApiClient
import io.kubernetes.client.openapi.apis.CustomObjectsApi

class K8sDevfileContentRetainer(private val k8sApi: ApiClient) : DevfileContentRetainer {
    override fun retainTemplateObject(templateObject: V1alpha2DevWorkspaceSpecTemplate) {
        val customObjectsApi = CustomObjectsApi(k8sApi)
        val group = "workspace.devfile.io"
        val version = "v1alpha2"

        val patch = JsonObject().apply {
            addProperty("op", "replace")
            addProperty("path", "/spec/template")
            add("value", Gson().toJsonTree(templateObject, V1alpha2DevWorkspaceSpecTemplate::class.java))
        }

        customObjectsApi.patchNamespacedCustomObject(
            group,
            version,
            Configuration.workspaceNamespace,
            "devworkspaces",
            Configuration.workspaceName,
            patch.toString(),
            null,
            null,
            null
        )
    }
}