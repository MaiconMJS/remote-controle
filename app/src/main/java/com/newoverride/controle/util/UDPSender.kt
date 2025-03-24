import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

object UDPSender {
    private val serverIp = "site-teste.com"
    private val serverPort = 41234
    fun sendCommand(command: String) {
        runBlocking {
            withContext(Dispatchers.IO) {
                val socket = aSocket(ActorSelectorManager(Dispatchers.IO)).udp()
                    .connect(InetSocketAddress(serverIp, serverPort))
                val byteArray = command.toByteArray()

                // Converte ByteArray em ByteReadPacket
                val packet = buildPacket { writeFully(byteArray) }

                socket.send(Datagram(packet, InetSocketAddress(serverIp, serverPort)))
                socket.close()
            }
        }
    }
}