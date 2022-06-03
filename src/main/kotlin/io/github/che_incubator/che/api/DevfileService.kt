package io.github.che_incubator.che.api

import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate

interface DevfileService {
    fun getRawDevfile(): String
    fun getDevfile(): V1alpha2DevWorkspaceSpecTemplate
    fun updateDevfile(devfile: V1alpha2DevWorkspaceSpecTemplate)
}