import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class ServerEcho:Thread, Runnable {
    private var socket:Socket
    private var numConnexio:Int

    constructor (clientsocket: Socket, numConnexio:Int): super() {
        this.socket = clientsocket
        this.numConnexio = numConnexio
    }
    override fun run() {

        // Obtenim el buffer d'entrada, on llegirem el que envia el client
        val input = BufferedReader(InputStreamReader(socket.getInputStream()))

        // Obtenim el buffer de sortida, on escriurem el que volem enviar al client
        val out = PrintWriter(socket.getOutputStream(), true)

        var inputLine: String = input.readLine()
        while (inputLine != null) {
            var missatge:String = "Client: $numConnexio - M'ha dit: $inputLine"
            out.println(missatge)
            println(missatge)
            inputLine = input.readLine()
        }

        // Tanquem els buffers i el socket
        out.close()
        input.close()
        socket.close()
    }
}
