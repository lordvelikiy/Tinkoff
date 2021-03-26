package lesson5

import java.sql.DriverManager

class ClientClass : AutoCloseable {

    val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/kotlin/lesson5/DB.db")
    private val stm = conn.createStatement()

    override fun close() {
        conn.close()
        stm.close()
    }
}
