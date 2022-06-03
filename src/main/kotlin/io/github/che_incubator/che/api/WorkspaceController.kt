package io.github.che_incubator.che.api

class WorkspaceController(private val workspaceLifecycleController: WorkspaceLifecycleController) {

    fun getNamespace(): String {
        return Configuration.workspaceNamespace
    }

    fun getWorkspaceId(): String {
        return Configuration.workspaceId
    }

    fun stopWorkspace() {
        workspaceLifecycleController.stopWorkspace()
    }
}