import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

fun main(args: Array<String>) {
    // Creem un socket que intenta connectar a localhost al port 5555
    val sck = Socket("localhost", 5555)

    // Obtenim el OutputStream. És com el System.out però escriu al client en lloc de a la consola
    val out = PrintWriter(sck.getOutputStream(), true)

    // Obtenim l'InputStream. És com el Scanner però llegeix del socket.
    // En aquest exemple no l'utilitzarem, però seria per a llegir el que ens envia el servidor
    //val input = BufferedReader(InputStreamReader(echoSocket.getInputStream()))

    // Equivalent al Scanner per a llegir de consola
    val stdIn = BufferedReader(InputStreamReader(System.`in`))

    var inputLine: String

    // Tot el text que escrivim a la consola, s'enviarà pel socket
    inputLine = stdIn.readLine()
    while (inputLine != null) {
        out.println(inputLine)
        inputLine = stdIn.readLine()
    }

    out.close()
    sck.close()
}
