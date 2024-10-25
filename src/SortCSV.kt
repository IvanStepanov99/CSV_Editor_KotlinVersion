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
    override fun compare(o1: SortCSV?, o2: SortCSV?): Int {
        TODO("Not yet implemented")
    }
}