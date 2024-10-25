import java.io.IOException
import java.util.Scanner
import kotlin.math.sqrt

fun main() {
    val filePath = "Data.csv"
    val keyboard = Scanner(System.`in`)
    var exit = false
    val calculation = CalculationCsv()
    val writer = CsvWriter()

    while (!exit){
        try {
            println("\nMenu:");
            println("1. Total of Income")
            println("2. Total of Expenses")
            println("3. Net Income (Savings)")
            println("4. Total of Debt/Loan")
            println("5. Average Interest Rate")
            println("6. Sort the CSV file")
            println("7. Add data to the CSV file")
            println("8. Quit")
            print("Please select an option: ")

            if(!keyboard.hasNextInt()){
               keyboard.nextLine()
            }
            val option = keyboard.nextInt()
            keyboard.nextLine()

            when(option){
                1 -> println("Total Income: $" + calculation.sumOfImcome(filePath))
                2 -> println("Total Expenses: $" + calculation.sumOfExpense(filePath))
                3 -> println("Net Income: $" + calculation.netIncome(filePath))
                4 -> println("Total of Debt/Loan: $" + calculation.sumOfDebt(filePath))
                5 -> println("Average Interest Rate: $" + calculation.sumOfImcome(filePath))
                6 -> sortCsvMenu(filePath, keyboard)
                7 -> writer.writeToCsv(filePath, keyboard)
                8 -> exit = true
                else -> println("Invalid option. Please try again!")
            }

        }catch (e: IOException){
            keyboard.nextLine()
        }

    }
keyboard.close()
}
@Throws(IOException::class)
fun sortCsvMenu(path:String,scanner: Scanner): Void{
var exit = false
    while(!exit){
        println("\nSorting Menu:")
        println("A - Sort by Income")
        println("B - Sort by Expenses")
        println("C - Sort by Interest")
        println("D - Sort by Debt/Loan")
        println("Q - Quit")
        print("Select an option: ")

        val sortOption = scanner.nextLine().toUpperCase()

        when(sortOption){
            "A" ->
            "B" ->
            "C" ->
            "D" -> csvList.sortedWith(csvIncomeComparator)
            "Q" -> exit = true
            else -> println("Invalid option.Please try again.")
        }
    }
}