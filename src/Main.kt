import java.io.IOException
import java.util.Scanner
import kotlin.math.sqrt

fun main() {
    val filePath = "/Users/ivanstepanov/Desktop/git/CSV_Editor_KotlinVersion/src/Data.csv"
    val keyboard = Scanner(System.`in`)
    var exit = false
    val calculation = CalculationCsv()
    val writer = CsvWriter()

    while (!exit) {
        try {
            println("\nMenu:")
            println("1. Total of Income")
            println("2. Total of Expenses")
            println("3. Net Income")
            println("4. Total of Debt/Loan")
            println("5. Average Interest Rate")
            println("6. Sort the CSV file")
            println("7. Add data to the CSV file")
            println("8. Quit")
            print("Please select an option: ")

            if (!keyboard.hasNextInt()) {
                println("Invalid input. Please enter a number.")
                keyboard.nextLine()
                continue
            }
            val option = keyboard.nextInt()
            keyboard.nextLine()

            when (option) {
                1 -> println("Total Income: $" + calculation.sumOfIncome(filePath))
                2 -> println("Total Expenses: $" + calculation.sumOfExpense(filePath))
                3 -> println("Net Income: $" + calculation.netIncome(filePath))
                4 -> println("Total of Debt/Loan: $" + calculation.sumOfDebt(filePath))
                5 -> println("Average Interest Rate: $" + calculation.averageInterestRate(filePath))
                6 -> sortCsvMenu(filePath, keyboard)
                7 -> writer.writeToCsv(filePath, keyboard)
                8 -> exit = true
                else -> println("Invalid option. Please try again!")
            }

        } catch (e: IOException) {
            println("An error occurred: ${e.message}")
            keyboard.nextLine()
        }
    }
    keyboard.close()
}

@Throws(IOException::class)

fun sortCsvMenu(path: String, scanner: Scanner) {

    var csvList: List<SortCSV> = CsvReader.readCsv(path)
    var exit = false
    while (!exit) {
        println("\nSorting Menu:")
        println("A - Sort by Income")
        println("B - Sort by Expenses")
        println("C - Sort by Interest")
        println("D - Sort by Debt/Loan")
        println("Q - Quit")

        print("Select an option: ")

        val sortOption = scanner.nextLine().uppercase()
        when (sortOption) {
            "A" -> csvList = csvList.sortedWith(CsvIncomeComparator())
            "B" -> csvList = csvList.sortedWith(CsvExpensesComparator())
            "C" -> csvList = csvList.sortedWith(CsvInterestComparator())
            "D" -> csvList = csvList.sortedWith(CsvDebtLoanComparator())
            "Q" -> exit = true
            else -> println("Invalid option. Please try again.")
        }
        println("Sorted Data: ")
        for (s in csvList) {
            println(s)
    }
    }
}
