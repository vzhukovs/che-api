package io.github.che_incubator.che.api

import java.nio.file.Path
import java.nio.file.Paths

open class Configuration {
    companion object {
        val devWorkspaceFlattenedDevfilePath: Path
        get() {
            val envVar = System.getenv("DEVWORKSPACE_FLATTENED_DEVFILE")

            if (envVar.isNullOrEmpty()) {
                throw IllegalStateException("Environment variable DEVWORKSPACE_FLATTENED_DEVFILE is not set")
            }

            return Paths.get(envVar)
        }

        val workspaceNamespace: String
        get() {
            val envVar = System.getenv("DEVWORKSPACE_NAMESPACE")

            if (envVar.isNullOrEmpty()) {
                throw IllegalStateException("Environment variable DEVWORKSPACE_NAMESPACE is not set")
            }

            return envVar
        }

        val workspaceName: String
        get() {
            val envVar = System.getenv("DEVWORKSPACE_NAME")

            if (envVar.isNullOrEmpty()) {
                throw IllegalStateException("Environment variable DEVWORKSPACE_NAME is not set")
            }

            return envVar
        }

        val workspaceId: String
        get() {
            val envVar = System.getenv("DEVWORKSPACE_ID")

            if (envVar.isNullOrEmpty()) {
                throw IllegalStateException("Environment variable DEVWORKSPACE_ID is not set")
            }

            return envVar
        }

        val devWorkspaceFlattenedDevfileParsingStrategy: DevWorkspaceSpecTemplateParsingStrategy
        get() {
            return when(devWorkspaceFlattenedDevfilePath.toFile().extension) {
                "yaml", "yml" -> YamlDevWorkspaceSpecTemplateParsingStrategy()
                "json" -> JsonDevWorkspaceSpecTemplateParsingStrategy()
                else -> throw IllegalArgumentException("unknown extension")
            }
        }

    }
}