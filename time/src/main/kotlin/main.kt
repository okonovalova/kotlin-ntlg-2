//количество секунд в минуте
val countOfSecondsInMinute = 60
//количество минут в часе
val countOfMinuteInHour = 60
//количество секунд в часе
val countOfSecondsInHour = countOfSecondsInMinute * 60
//количество секунд в дне
val countOfSecondsInDay = countOfSecondsInHour * 24

fun main() {
    //количество секунд отсутствия
    val countSeconds = 120

    agoToText(countSeconds)
}

fun agoToText(countSeconds: Int) {
    val result: String = when {
        countSeconds <= countOfSecondsInMinute -> {
            "только что"
        }
        countSeconds in (countOfSecondsInMinute + 1)..countOfSecondsInHour -> {
            "${convertSecondsToMinutes(countSeconds)} ${inflectMinutesOrHours(countSeconds, isMinutes = true)} назад"
        }
        countSeconds in (countOfSecondsInHour + 1)..countOfSecondsInDay -> {
            "${convertSecondsToHours(countSeconds)} ${inflectMinutesOrHours(countSeconds, isMinutes = false)} назад"
        }
        countSeconds > countOfSecondsInDay && countSeconds <= 2 * countOfSecondsInDay -> {
            "сегодня"
        }
        countSeconds > 2 * countOfSecondsInDay && countSeconds <= 3 * countOfSecondsInDay -> {
            "вчера"
        }
        else -> {
            "давно"
        }
    }
    println("был(а) в сети $result")

}

fun convertSecondsToMinutes(countSeconds: Int): Int {
    return countSeconds / countOfSecondsInMinute
}

fun convertSecondsToHours(countSeconds: Int): Int {
    return convertSecondsToMinutes(countSeconds) / countOfMinuteInHour
}

//функция для склонения минут и часов
fun inflectMinutesOrHours(countSeconds: Int, isMinutes: Boolean): String {
    var moduloForInflect = 10
    val rangeForGenitive: IntRange = 2..4
    val exceptionRangeForGenitive: IntRange = 12..14
    val exceptionNumberForGenitive = 11
    
    val count = if (isMinutes) convertSecondsToMinutes(countSeconds) else convertSecondsToHours(countSeconds)
    return when {
        count % moduloForInflect == 1 && count != exceptionNumberForGenitive -> {
            if (isMinutes) "минуту" else "час"
        }
        count % moduloForInflect in rangeForGenitive && count !in exceptionRangeForGenitive -> {
            if (isMinutes) "минуты" else "часа"
        }
        else -> {
            if (isMinutes) "минут" else "часов"
        }
    }
}