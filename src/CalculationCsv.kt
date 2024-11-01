import java.io.BufferedReader
import java.io.FileReader
import java.math.BigDecimal
import java.io.IOException
import java.math.RoundingMode

class CalculationCsv {
    fun sumOfIncome(path: String): BigDecimal {
        var totalIncome = BigDecimal.ZERO

        try {
            BufferedReader(FileReader(path)).use { br ->
                var line: String?
                while (br.readLine().also { line = it } != null) {
                    val values = line!!.split(",")

                    if (values.size < 5) {
                        System.err.println("Invalid CSV line, skipping: $line")
                        continue
                    }

                    try {
                        val income = values[0].toBigDecimal()
                        totalIncome = totalIncome.add(income)
                    } catch (e: NumberFormatException) {
                        System.err.println("Invalid income value in line: $line")
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return totalIncome
    }

    fun sumOfExpense(path: String): BigDecimal{
        var totalExpense = BigDecimal.ZERO

        try{
            BufferedReader(FileReader(path)).use { br->
                var line: String?
                while (br.readLine().also { line = it } != null){
                    val values = line!!.split(",")

                    if(values.size<5){
                        System.err.println("Invalid CSV line, skipping: $line")
                        continue
                    }
                    try{
                        val income = values[1].toBigDecimal()
                        totalExpense = totalExpense.add(income)
                    } catch (e: NumberFormatException){
                        System.err.println("Invalid expense value in line $line")
                    }
                }
            }
        }catch (e: IOException){
            e.printStackTrace()
        }
        return totalExpense
    }
    fun netIncome(path: String): BigDecimal{
        val netIncome = sumOfIncome(path).subtract(sumOfExpense(path))

        if(netIncome.compareTo(BigDecimal.ZERO)<0){
            System.err.println("The income is negative: $netIncome")
        }
        return netIncome
    }
    fun sumOfDebt(path: String): BigDecimal{
        var totalDebt = BigDecimal.ZERO

        try{
            BufferedReader(FileReader(path)).use{br->
                var line: String?
                while(br.readLine().also{line = it}!= null){
                    val values = line!!.split(",")

                    if(values.size<5){
                        System.err.println("Invalid CSV line, skipping: $line")
                        continue
                    }
                    try{
                        val income = values[2].toBigDecimal()
                        totalDebt = totalDebt.add(income)
                    } catch (e: NumberFormatException){
                        System.err.println("Invalid debt/loan value in line $line")
                    }
                }
            }
        }catch (e: IOException){
            e.printStackTrace()
        }
        return totalDebt
    }
    fun averageInterestRate(path: String):BigDecimal{
        var totalWeighted = BigDecimal.ZERO

        try{
            BufferedReader(FileReader(path)).use { br ->
                var line: String?
                while (br.readLine().also { line = it } != null) {
                    val values = line!!.split(",")
                    if (values.size < 5) {
                        System.err.println("Invalid CSV line, skipping: $line");
                        continue;
                    }

                    try {
                        val interestRate = values[3].toBigDecimal()
                        val debtLoan = values[2].toBigDecimal()

                         totalWeighted = totalWeighted.add(debtLoan.multiply(interestRate))
                    } catch (e: NumberFormatException) {
                        System.err.println("Invalid value in line $line")
                    }
                }
                if (sumOfDebt(path).compareTo(BigDecimal.ZERO) == 0) {
                    return BigDecimal.ZERO
                }

                return totalWeighted.divide(sumOfDebt(path), 2, RoundingMode.HALF_UP)
            }
        }catch (e: IOException){
            e.printStackTrace()
        }
        return BigDecimal.ZERO
    }
}
