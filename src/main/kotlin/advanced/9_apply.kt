package advanced

fun main() {
    val client = DatabaseClient().apply {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"

    }

    val connected = client.connect()

    client.connect().run { println(this) }
}