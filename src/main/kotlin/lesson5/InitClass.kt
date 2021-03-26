package lesson5


class InitClass(private val tables: List<Table>) {

    fun createAllTables() = tables.forEach { createTable(it) }
    fun deleteAllTables() = tables.forEach { deleteTable(it) }
    fun insertValuesInTables() = tables.forEach { insertValuesInTable(it) }

    private fun insertValuesInTable(table: Table) {
        ClientClass().use { db ->
            var str = "INSERT INTO ${table.tableName}(${toColumnString(table.args)}) VALUES "
            for (i in table.valuesList.indices) {
                str += "( ${table.valuesList[i].getValueString()})"
                str += if (i != table.valuesList.size - 1) {
                    (", ")
                } else {
                    (";")
                }
            }
            val preparedStatement = db.conn.prepareStatement(str)
            preparedStatement.execute()
            println("Заполнена таблица ${table.tableName}")
        }
    }

    private fun createTable(table: Table) {
        ClientClass().use { db ->
            runCatching {
                val str = "CREATE TABLE IF NOT EXISTS ${table.tableName}(${makeInitColumns(table.argsMap)})"
                val preparedStatement = db.conn.prepareStatement(str)
                preparedStatement.execute()
                println("Создана таблица ${table.tableName}")
            }
        }
    }

    private fun deleteTable(table: Table) {
        ClientClass().use { db ->
            runCatching {
                val str = "DROP TABLE IF EXISTS ${table.tableName}"
                val preparedStatement = db.conn.prepareStatement(str)
                preparedStatement.execute()
                println("Удалена таблица ${table.tableName}")
            }
        }
    }

    //делает из мыпы строку значения и тип данных в sql
    private fun makeInitColumns(map: Map<String, SQLTypes>): String {
        var count = 0
        var str = ""
        map.forEach {
            str += "${it.key} ${it.value}"
            if (count != map.size - 1) {
                str += ", "
            }
            count++
        }
        return str
    }
}