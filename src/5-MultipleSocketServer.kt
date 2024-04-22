import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket


fun main(args: Array<String>) {
    // Socket server crea una classe que rep
    val serverSocket = ServerSocket(5555)
    var numConnexions:Int = 0

    while (true) {
        // El codi es para a la següent línia fins que el client inicia connexió
        val clientSocket = serverSocket.accept()
        numConnexions++
        val th_Listener = ServerEcho(clientSocket, numConnexions)
        th_Listener.start()
    }

    // Tanquem els buffers i el socket
    serverSocket.close()

}
