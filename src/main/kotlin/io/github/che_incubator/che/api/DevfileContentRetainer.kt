package io.github.che_incubator.che.api

import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate

interface DevfileContentRetainer {
    fun retainTemplateObject(templateObject: V1alpha2DevWorkspaceSpecTemplate)
}