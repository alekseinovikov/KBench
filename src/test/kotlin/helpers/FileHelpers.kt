package helpers

import me.freedom4live.kbench.data.FileDataLoader
import java.io.File

fun getFilePathFromTestResources(fileName: String): String {
    return FileDataLoader::class.java.classLoader.getResource(fileName)!!.toURI().let { File(it).absolutePath }
}