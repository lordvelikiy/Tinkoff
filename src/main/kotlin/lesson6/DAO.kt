package lesson6

interface DAO {
    fun selectByID(id: Int): Boxer
    fun selectAll(): List<Boxer>
}
