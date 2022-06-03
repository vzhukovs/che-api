package io.github.che_incubator.che.api

class DevfileContentProvider(private val devfileContent: DevfileContent, private val devfileContentParser: DevfileContentParser) {

    fun getDevfileContent(): ByteArray {
        return devfileContent.getContent()
    }

    fun getDevfileContentParser(): DevfileContentParser {
        return devfileContentParser
    }
}