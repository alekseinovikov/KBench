package data

import helpers.getFilePathFromTestResources
import me.freedom4live.kbench.data.FileDataLoader
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class FileDataLoaderTest {

    @Test
    fun load_noFile_fileNotFoundException() {
        //arrange
        val notFoundFile = "wrong.txt"

        //assert
        assertThrows(FileNotFoundException::class.java) { FileDataLoader.load(notFoundFile) }
    }

    @Test
    fun load_hasFile_returnsContentBytes() {
        //arrange
        val filePathString = "text.txt"
        val filePathFromTestResources = getFilePathFromTestResources(filePathString)
        val expectedBytes = Files.readAllBytes(Paths.get(filePathFromTestResources))

        //act
        val result = FileDataLoader.load(filePathFromTestResources)

        //assert
        assertTrue { expectedBytes.contentEquals(result) }
    }

}