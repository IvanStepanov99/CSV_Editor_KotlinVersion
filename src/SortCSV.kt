import java.math.BigDecimal

data class SortCSV(
    val income: BigDecimal,
    val expense: BigDecimal,
    val interest: BigDecimal,
    val debtLoan: BigDecimal,
    val typeOfLoan: String
) {
    override fun toString(): String{
        return "$income,$expense,$interest,$debtLoan,$typeOfLoan"
    }
}
class CsvIncomeComparator: Comparator<SortCSV>{
    override fun compare(b1: SortCSV, b2: SortCSV): Int {
        return b1.income.compareTo(b2.income) }
}
class CsvExpensesComparator: Comparator<SortCSV>{
    override fun compare(b1: SortCSV, b2: SortCSV): Int {
        return b1.expense.compareTo(b2.expense) }
}

class CsvInterestComparator: Comparator<SortCSV>{
    override fun compare(b1: SortCSV, b2: SortCSV): Int {
        return b1.interest.compareTo(b2.interest)
    }
}
class CsvDebtLoanComparator: Comparator<SortCSV>{
    override fun compare(b1: SortCSV, b2: SortCSV): Int {
        return b1.debtLoan.compareTo(b2.debtLoan)
    }
}