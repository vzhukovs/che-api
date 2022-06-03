package io.github.che_incubator.che.api

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate
import io.kubernetes.client.custom.V1Patch
import io.kubernetes.client.openapi.ApiClient
import io.kubernetes.client.openapi.apis.CustomObjectsApi
import io.kubernetes.client.util.PatchUtils

class K8sWorkspaceLifecycleController(private val k8sApi: ApiClient) : WorkspaceLifecycleController {

    override fun stopWorkspace() {
        val customObjectsApi = CustomObjectsApi(k8sApi)
        val group = "workspace.devfile.io"
        val version = "v1alpha2"

        val patch = JsonArray()
        patch.add(JsonObject().apply {
            addProperty("op", "replace")
            addProperty("path", "/spec/started")
            addProperty("value", false)
        })

        PatchUtils.patch(V1alpha2DevWorkspaceSpecTemplate::class.java, {
            customObjectsApi.patchNamespacedCustomObjectCall(
                group,
                version,
                Configuration.workspaceNamespace,
                "devworkspaces",
                Configuration.workspaceName,
                V1Patch(patch.toString()),
                null,
                null,
                null,
                null
            )
        }, V1Patch.PATCH_FORMAT_JSON_PATCH, k8sApi)
    }
}