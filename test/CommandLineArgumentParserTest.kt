import me.freedom4live.kbench.args.RequestType
import me.freedom4live.kbench.args.parser.CommandLineArgumentParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class CommandLineArgumentParserTest {

    private val testUrl = "testUrl"
    private val method = "POST"
    private val clients = 42
    private val requests = 43
    private val dataFilePath = "testPath"


    @Test
    fun parse_hasAtLeastUWithValue_defaultValues() {
        //arrange
        val args = arrayOf(
            "-u", testUrl,
            "-m", method,
            "-c", clients.toString(),
            "-r", requests.toString(),
            "-k",
            "-d", dataFilePath
        )

        //act
        val result = CommandLineArgumentParser.parse(args)

        //assert
        assertEquals(result.url, testUrl)
        assertEquals(result.clientsCount, clients)
        assertTrue(result.keepAlive)
        assertEquals(result.requestType, RequestType.valueOf(method))
        assertEquals(result.dataFilePath, dataFilePath)
    }

}