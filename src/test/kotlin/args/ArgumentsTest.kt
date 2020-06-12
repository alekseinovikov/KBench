package args

import helpers.getFilePathFromTestResources
import me.freedom4live.kbench.args.Arguments
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertNull

internal class ArgumentsTest {

    @Test
    fun getData_hasNoPath_null() {
        //arrange
        val myUrl = "myUrl"
        val arguments = Arguments(url = myUrl)

        //act
        val data = arguments.getData()

        //assert
        assertNull(data)
    }

    @Test
    fun getData_wrongPathPath_fileNotFoundException() {
        //arrange
        val myUrl = "myUrl"
        val filePath = "wrong.txt"
        val arguments = Arguments(
            url = myUrl,
            dataFilePath = filePath
        )

        //act
        assertThrows(FileNotFoundException::class.java) { arguments.getData() }
    }

    @Test
    fun getData_goodPathPath_retyrnsFileContent() {
        //arrange
        val myUrl = "myUrl"
        val filePathString = "text.txt"
        val filePathFromTestResources = getFilePathFromTestResources(filePathString)
        val expectedBytes = Files.readAllBytes(Paths.get(filePathFromTestResources))

        val arguments = Arguments(
            url = myUrl,
            dataFilePath = filePathFromTestResources
        )

        //act
        val result = arguments.getData()

        //assert
        assertTrue { expectedBytes.contentEquals(result!!) }
    }

    @Test
    fun getUrl_hasTheSame_returnsTheSame() {
        //arrange
        val myUrl = "myUrl"
        val arguments = Arguments(url = myUrl)

        //assert
        assertEquals(myUrl, arguments.url)
    }

}