fun main() {
    val seconds = 60
    println(agoToText(seconds))
    val seconds1 = 63
    println(agoToText(seconds1))
    val seconds2 = 120
    println(agoToText(seconds2))
    val seconds5 = 300
    println(agoToText(seconds5))
    val seconds21 = 1_260
    println(agoToText(seconds21))
    val seconds51 = 3_060
    println(agoToText(seconds51))
    val seconds28 = 1_680
    println(agoToText(seconds28))
    val seconds1h = 3_660
    println(agoToText(seconds1h))
    val seconds4h = 14_400
    println(agoToText(seconds4h))
    val seconds6h = 21_600
    println(agoToText(seconds6h))
    val seconds22h = 79_200
    println(agoToText(seconds22h))
    val secondsVchera = 93_600
    println(agoToText(secondsVchera))
    val secondsPozavchera = 188_800
    println(agoToText(secondsPozavchera))
    val secondsDavno = 266_400
    println(agoToText(secondsDavno))
}

private fun agoToText(seconds: Int): String {
    return when(seconds) {
        in 0..60 -> "был(а) только что" // до 1 минуты
        in 61..3_600 -> textMinutesAgo(seconds) // от 1 минуты до 1 часа
        in 3_601..86_400 -> textHoursAgo(seconds) //  от 1 часа до 1 суток
        in 86_401..172_800 -> "был(а) вчера" // от 1 суток до 2 суток
        in 172_801..259200 ->"был(а) позавчера" // от 2 суток до 3 суток
        else -> "был(а) давно" // от 3 суток
    }
}

fun textHoursAgo(seconds: Int): String {
    return when(val hours = seconds/(60*60)){
        1, 21 -> "был(а) в сети $hours час назад"
        2, 3, 4, 22, 23, 24 -> "был(а) в сети $hours часа назад"
        else -> "был(а) в сети $hours часов назад"
    }
}

fun textMinutesAgo(seconds: Int): String {
    return when (val minutes = seconds/60) {
        1, 21, 31, 41, 51 -> "был(а) $minutes минуту назад"
        2, 3, 4 -> "был(а) $minutes минуты назад"
        else -> if (minutes > 20) {
            val ostatok = minutes%10
            when(ostatok) {
                2, 3, 4 -> "был(а) $minutes минуты назад"
                else -> "был(а) $minutes минут назад"
            }
        } else "был(а) $minutes минут назад"

    }
}
