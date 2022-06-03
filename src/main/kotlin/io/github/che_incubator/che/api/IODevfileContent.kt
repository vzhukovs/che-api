package io.github.che_incubator.che.api

import java.nio.file.Path

class IODevfileContent(private val path: Path) : DevfileContent {

    override fun getContent(): ByteArray {
        val devfile = path.toFile()

        return devfile.readBytes()
    }
}