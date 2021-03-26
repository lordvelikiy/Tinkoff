package lesson5

import java.sql.ResultSet

class ServiceClass {

    fun getBy(table: Table, columnName: String, parameter: Int, marks: String): List<String> {
        ClientClass().use { db ->
            val str = "SELECT * FROM ${table.tableName} WHERE $columnName $marks $parameter"
            val preparedStatement = db.conn.prepareStatement(str)
            preparedStatement.executeQuery().use { rs ->
                return getStringsFromResponse(rs, findTheRightMap(table))
            }
        }
    }

    fun selectionFromTables(table: Table, table2: Table): List<String> {
        ClientClass().use { db ->
            val str =
                "SELECT ${toColumnString(personAndApartmentArgs)} FROM " +
                        "${table.tableName} INNER JOIN ${table2.tableName} ON ${table.tableName}." +
                        "${table.args[3]} = ${table2.tableName}.${table2.args[0]} "
            val preparedStatement = db.conn.prepareStatement(str)
            preparedStatement.executeQuery().use { rs ->
                return getStringsFromResponse(rs, findTheRightMap(table, table2))
            }
        }
    }

    fun selectionWithGrouping(table: Table, table2: Table, table3: Table): List<String> {
        ClientClass().use { db ->
            val str2 =
                "SELECT ${toColumnString(personAndComputerLanguageArgs)} FROM ${table3.tableName} join " +
                        "${table.tableName} ON ${table3.tableName}.${table3.args[0]} = " +
                        "${table.tableName}.${table.args[0]} join ${table2.tableName} ON " +
                        "${table3.tableName}.${table3.args[1]} = ${table2.tableName}.${table2.args[0]} " +
                        "GROUP BY ${table2.args[1]}"
            val preparedStatement = db.conn.prepareStatement(str2)
            preparedStatement.executeQuery().use { rs ->
                return getStringsFromResponse(rs, findTheRightMap(table, table2, table3))

            }
        }
    }

    fun selectAndSort(table: Table): List<String> {
        ClientClass().use { db ->
            val str = "SELECT * FROM ${table.tableName} ORDER BY ${table.args[2]} DESC"
            val preparedStatement = db.conn.prepareStatement(str)
            preparedStatement.executeQuery().use { rs ->
                return getStringsFromResponse(rs, findTheRightMap(table))
            }
        }
    }

    private fun getStringsFromResponse(rs: ResultSet, map: Map<String, SQLTypes>): List<String> {
        val ans = mutableListOf<String>()
        val sb = StringBuilder()
        while (rs.next()) {
            sb.clear()
            for (i in map) {
                when (i.value) {
                    SQLTypes.TEXT -> sb.append(rs.getString(i.key))
                    SQLTypes.REAL -> sb.append(rs.getDouble(i.key))
                    SQLTypes.INT -> sb.append(rs.getInt(i.key))
                }
                sb.append(" ")
            }
            ans += sb.toString()
        }
        return ans
    }
}
