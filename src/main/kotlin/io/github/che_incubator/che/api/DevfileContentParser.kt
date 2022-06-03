package io.github.che_incubator.che.api

import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate

class DevfileContentParser(private val parsingStrategy: DevWorkspaceSpecTemplateParsingStrategy) {
    fun parseTemplateObject(devfileContent: ByteArray): V1alpha2DevWorkspaceSpecTemplate {
        return parsingStrategy.parseTemplateObject(devfileContent)
    }
}