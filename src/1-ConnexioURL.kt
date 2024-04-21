import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

fun main() {
    val url_g: URL = URL("https://www.google.com/")
    val google_In: BufferedReader = BufferedReader(InputStreamReader(url_g.openStream()))

    var inputLine: String? = google_In.readLine()
    while (inputLine != null) {
        System.out.println(inputLine)
        inputLine = google_In.readLine()
    }

    google_In.close()
}

