package me.freedom4live.kbench.data

import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Paths

object FileDataLoader {

    fun load(filePath: String): ByteArray {
        val rawPath = Paths.get(filePath)
        if (Files.exists(rawPath).not()) {
            throw FileNotFoundException()
        }

        return Files.readAllBytes(rawPath)
    }

}