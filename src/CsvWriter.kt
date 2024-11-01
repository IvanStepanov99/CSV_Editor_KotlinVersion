import java.io.IOException
import java.math.BigDecimal
import java.util.Scanner

class CsvWriter{
fun writeToCsv(path:String, keyboard: Scanner){
    try {
        do{
            println("Please enter income: ")
            val income = BigDecimal(keyboard.nextLine())

            println("Please enter expense: ")
            val expense = BigDecimal(keyboard.nextLine())

            println("Please enter debt/loan: ")
            val debtLoan = BigDecimal(keyboard.nextLine())

            println("Please enter interest: ")
            val interest = BigDecimal(keyboard.nextLine())

            println("Please enter type of loan: ")
            val typeOfLoan = keyboard.nextLine()

            println("Would you like to continue? yes/no")
            val toContinue = keyboard.nextLine()

        }while (toContinue.equals("YES",true))

        println("Data succsessfully added to the $path")
    }catch (e: IOException){
        e.printStackTrace()
    }
}
}