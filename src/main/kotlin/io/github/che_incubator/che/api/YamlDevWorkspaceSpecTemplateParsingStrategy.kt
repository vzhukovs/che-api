package io.github.che_incubator.che.api

import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate
import org.yaml.snakeyaml.LoaderOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

class YamlDevWorkspaceSpecTemplateParsingStrategy : DevWorkspaceSpecTemplateParsingStrategy {

    override fun parseTemplateObject(devfileContent: ByteArray): V1alpha2DevWorkspaceSpecTemplate {
        val loadingConfig = LoaderOptions()
        loadingConfig.isEnumCaseSensitive = false

        return Yaml(
            Constructor(
                V1alpha2DevWorkspaceSpecTemplate::class.java,
                loadingConfig
            )
        ).load(String(devfileContent))
    }
}