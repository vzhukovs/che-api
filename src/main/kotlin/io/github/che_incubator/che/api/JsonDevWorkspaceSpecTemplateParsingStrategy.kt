package io.github.che_incubator.che.api

import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate

class JsonDevWorkspaceSpecTemplateParsingStrategy : DevWorkspaceSpecTemplateParsingStrategy {

    override fun parseTemplateObject(devfileContent: ByteArray): V1alpha2DevWorkspaceSpecTemplate {
        TODO("Not yet implemented")
    }
}