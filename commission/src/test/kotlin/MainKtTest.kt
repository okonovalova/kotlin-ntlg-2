import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommissionForMastercard() {
        val sumTransferCurrentMonth = 60_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val cardType = CardType.MASTERCARD
        val expectedResult = 0
        val result = calculateCommission(cardType, sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }


    @Test
    fun calculateCommissionForMaestro() {
        val sumTransferCurrentMonth = 60_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val cardType = CardType.MAESTRO
        val expectedResult = 0
        val result = calculateCommission(cardType, sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }

    @Test
    fun calculateCommissionForVisa() {
        val sumTransferCurrentMonth = 60_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val cardType = CardType.VISA
        val expectedResult = 45_000
        val result = calculateCommission(cardType, sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }

    @Test
    fun calculateCommissionForMir() {
        val sumTransferCurrentMonth = 60_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val cardType = CardType.MIR
        val expectedResult = 45_000
        val result = calculateCommission(cardType, sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }

    @Test
    fun calculateCommissionForVkPay() {
        val sumTransferCurrentMonth = 60_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val cardType = CardType.VK_PAY
        val expectedResult = 0
        val result = calculateCommission(cardType, sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }


    @Test
    fun calculateForMastercardAndMaestroForMastercardIfSumCurrentMonthMoreLimit() {
        val sumTransferCurrentMonth = 76_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val expectedResult = 38_000
        val result = calculateForMastercardAndMaestro(sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }
    @Test
    fun calculateForMastercardAndMaestroForMastercardIfSumCurrentMonthLessLimit() {
        val sumTransferCurrentMonth = 60_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val expectedResult = 0
        val result = calculateForMastercardAndMaestro(sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }

    @Test
    fun calculateForMastercardAndMaestroForMaestroIfSumCurrentMonthMoreLimit() {
        val sumTransferCurrentMonth = 76_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val expectedResult = 38_000
        val result = calculateForMastercardAndMaestro(sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }
    @Test
    fun calculateForMastercardAndMaestroForMaestroIfSumCurrentMonthLessLimit() {
        val sumTransferCurrentMonth = 60_000.00 * countOfKopecksInRuble
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val expectedResult = 0
        val result = calculateForMastercardAndMaestro(sumTransferCurrentMonth,amountTransfer)

        assertEquals(expectedResult,result)
    }

    @Test
    fun calculateForVisaAndMirForVisaIfCommissionMoreMin() {
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val expectedResult = 45_000
        val result = calculateForVisaAndMir(amountTransfer)

        assertEquals(expectedResult,result)
    }
    @Test
    fun calculateForVisaAndMirForVisaIfCommissionLessMin() {
        val amountTransfer = 1_000.00 * countOfKopecksInRuble
        val expectedResult = 3_500
        val result = calculateForVisaAndMir(amountTransfer)

        assertEquals(expectedResult,result)
    }

    @Test
    fun calculateForVisaAndMirForMirIfCommissionMoreMin() {
        val amountTransfer = 60_000.00 * countOfKopecksInRuble
        val expectedResult = 45_000
        val result = calculateForVisaAndMir(amountTransfer)

        assertEquals(expectedResult,result)
    }
    @Test
    fun calculateForVisaAndMirForMirIfCommissionLessMin() {
        val amountTransfer = 1_000.00 * countOfKopecksInRuble
        val expectedResult = 3_500
        val result = calculateForVisaAndMir(amountTransfer)

        assertEquals(expectedResult,result)
    }
}