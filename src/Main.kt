fun main() {

    //Задача 1
    println("Пример работы решения задачи 1: " + getSumFrom2To8Index(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))

    //Задача 2
    val numbers = listOf(1, 2, 3, 4)
    println("Пример работы решения задачи 2: " + foldNumbersToString(numbers))

    //Задача 3
    val players = listOf(
        Player("First", 100, 100_000),
        Player("Second", 97, 78_000),
        Player("Third", 14, 5_600)
    )
    println("Пример работы решения задачи 3:")
    println("Сумма очков всех игроков: " + players.sumOf { it.score })
    println("Сумма денег всех игроков: " + players.sumOf { it.money })

    //Задача 4
    val fruits = listOf("Яблоко", "Абрикос", "Банан", "Виноград", "Вишня", "Кокос", "яблоко")
    val groupedFruits = fruits.groupBy(
        keySelector = { it.first().lowercase() },
        valueTransform = {
            if (it.length % 2 == 0) it else null
        }
    )
    val clearedFruits = mutableMapOf<String, List<String>>()
    groupedFruits.forEach {
        clearedFruits[it.key] = it.value.filterNotNull()
    }
    println("Пример работы решения задачи 4:\n$clearedFruits")
}

//Функция для задачи 1
fun getSumFrom2To8Index(list: List<Int>): Int {
    return list.foldIndexed(0) { index, acc, i -> if (index in 2..8) acc + i else acc }
}

//Функция для задачи 2
fun foldNumbersToString(list: List<Int>) = list.fold("") { acc, i -> acc + i }

//Класс для задачи 3
data class Player(val name: String, val score: Int, val money: Int)