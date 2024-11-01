import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class CsvReader {
    companion object {
        fun readCsv(path: String): List<SortCSV> {
            val csvList = mutableListOf<SortCSV>()

            try {
                BufferedReader(FileReader(path)).use { br ->
                    var line: String? = br.readLine()

                    while (br.readLine().also { line = it } != null) {

                        val values = line!!.split(",")
                        if (values.size >= 5) {
                            try {
                                val csvInfo = SortCSV(
                                    income = values[0].toBigDecimal(),
                                    expense = values[1].toBigDecimal(),
                                    interest = values[2].toBigDecimal(),
                                    debtLoan = values[3].toBigDecimal(),
                                    typeOfLoan = values[4]
                                )

                                csvList.add(csvInfo)

                            } catch (e: NumberFormatException) {
                                System.err.println("Invalid number format in line: $line")
                            }
                        } else {
                            System.err.println("Invalid CSV line, skipping: $line")
                        }
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return csvList
        }
    }
}
