import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket


fun main(args: Array<String>) {
    // Socket server crea una classe que rep
    val serverSocket = ServerSocket(5555)

    // El codi es para a la següent línia fins que el client inicia connexió
    val clientSocket = serverSocket.accept()

    // Obtenim el buffer d'entrada, on llegirem el que envia el client
    val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

    // Obtenim el buffer de sortida, on escriurem el que volem enviar al client
    val out =  PrintWriter(clientSocket.getOutputStream(), true)

    // L'out es fa servir igual que el System.out, que escriu per consola
    // Escrivim el missatge de benvinguda tant al socket del client com a la consola.
    out.println("Hola, sóc el servidor.")
    println("Hola, sóc el servidor")

    var inputLine: String = input.readLine()
    while (inputLine != null) {
        println(inputLine)
        out.println("M'han dit $inputLine")
        inputLine = input.readLine()
    }

    // Tanquem els buffers i el socket
    out.close()
    input.close()
    clientSocket.close()
    serverSocket.close()

}
