import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection

fun main() {
    val g_URL: URL = URL("https://www.google.com/")
    val gc: URLConnection = g_URL.openConnection()
    val input: BufferedReader = BufferedReader(InputStreamReader(gc.getInputStream()))

    var inputLine: String? = input.readLine()
    while (inputLine != null) {
        System.out.println(inputLine)
        inputLine = input.readLine()
    }

    input.close()
}