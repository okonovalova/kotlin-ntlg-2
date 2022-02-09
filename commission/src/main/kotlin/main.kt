import kotlin.math.roundToInt

const val countOfKopecksInRuble = 100

enum class CardType {
    MASTERCARD,
    MAESTRO,
    VISA,
    MIR,
    VK_PAY
}

fun main() {
    //сумма переводов за текущий месяц
    val sumTransferCurrentMonth = 76_000.00 * countOfKopecksInRuble
    //сумма перевода
    val amountTransfer = 60_000.00 * countOfKopecksInRuble
    //тип карты. Возможные значения: Mastercard, Maestro, Visa, Мир, VK Pay
    val cardType = CardType.MIR

    val result = calculateCommission(cardType, sumTransferCurrentMonth, amountTransfer)
    println("Комиссия за перевод составит $result копеек")

}

fun calculateCommission(cardType: CardType, amountTransferCurrentMonth: Double, amountTransfer: Double): Int {
    return when (cardType) {
        CardType.MASTERCARD, CardType.MAESTRO -> {
            calculateForMastercardAndMaestro(amountTransferCurrentMonth, amountTransfer)
        }
        CardType.VISA, CardType.MIR -> {
            calculateForVisaAndMir(amountTransfer)
        }
        CardType.VK_PAY -> {
            0
        }
    }
}

fun calculateForMastercardAndMaestro(amountTransferCurrentMonth: Double, amountTransfer: Double): Int {
    //максимальная сумма перевода в месяц для Mastercard, Maestro, в рублях
    val maxSumForMastercardAndMaestro = 75_000.00 * countOfKopecksInRuble

    //процентная ставка 0.6% для переводов Mastercard, Maestro
    val feeForMastercardAndMaestro = 0.006

    //доп. комиссия 20 рублей
    val addSumForMastercardAndMaestro = 20.00 * countOfKopecksInRuble

    return if (amountTransferCurrentMonth <= maxSumForMastercardAndMaestro) {
        0
    } else {
        (amountTransfer * feeForMastercardAndMaestro + addSumForMastercardAndMaestro).roundToInt()
    }
}

fun calculateForVisaAndMir(amountTransfer: Double): Int {
    //минимальная комиссия 35 руб Visa и Мир
    val minCommissionForVisaAndMir = 35 * countOfKopecksInRuble

    //ставка 0.75% для переводов Visa и Мир
    val feeForVisaAndMir = 0.0075

    val commission = (amountTransfer * feeForVisaAndMir).roundToInt()

    return if (commission < minCommissionForVisaAndMir) {
        minCommissionForVisaAndMir
    } else {
        commission
    }
}
