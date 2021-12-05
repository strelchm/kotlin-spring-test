fun main(args: Array<String>) {
    print(args.toString())
    inputValuesTest()
    printPartHeadline("NUMBERS")
    numberTest()
    printPartHeadline("STRING")
    stringTest()
    printPartHeadline("ARRAY")
    arrayTest()
    printPartHeadline("ARRAYLIST")
    arrayListTest()

//    val foo = Foo("asd")
//    println(foo.foo)

    funcArgsTest()
}

private fun funcArgsTest() {
    printLine("Hello, Kotlin", "!!!") // prints "Hello, Kotlin!!!"
    printLine("Kotlin") // prints "Kotlin" with an ending
    printLine() // prints an empty line like println()
}

private fun inputValuesTest() {
    val numbers = MutableList(5) { readLine()!!.toInt() } // on each line single numbers from 1 to 5
    println(numbers)
}

fun printLine(line: String = "", end: String = "\n") = print("$line$end")

fun arrayListTest() {
    val numbers = mutableListOf(10.8, 14.3, 13.5, 12.1, 9.7)
    println(numbers) // [10.8, 14.3, 13.5, 12.1, 9.7]

    val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
    println(southernCross.joinToString(" -> ", "[", "]"))

    // EQUALITY
    val firstList = mutableListOf("result", "is", "true")
    val secondList = mutableListOf("result", "is", "true")
    val thirdList = mutableListOf("result")

    // Note that true is returned only if the elements of the two lists match completely and are arranged in the same order.
    println(firstList == secondList)  //  true
    println(firstList == thirdList)   //  false
    println(secondList != thirdList)  //  true

    // CRUD
    val stars = mutableListOf("Ginan", "Mu Crucis")
    val names = mutableListOf("Jack", "John", "Katie")
    val food = mutableListOf("Bread", "Cheese", "Meat")
    val fruits = mutableListOf("Apple", "Banana", "Grape", "Mango")

    southernCross.removeAt(0)
    southernCross.remove("Mimosa")

    stars.add("New star")
    stars.add(0, "First star")

    names.clear()

    food.addAll(fruits)

    println(names) // []
    println(southernCross.joinToString()) // Gacrux, Imai
    println(stars.joinToString()) // First star, Ginan, Mu Crucis, New star
    println(food.joinToString()) // Bread, Cheese, Meat, Apple, Banana, Grape, Mango

    // ADDING
    val vowels = mutableListOf('a', 'o', 'i', 'e', 'u')
    val intList1 = mutableListOf(1, 2, 3, 4, 5)
    val intList2 = mutableListOf(5, 4, 3, 2, 1)

    vowels += 'y'
    intList1 += intList2

    println(vowels)   // [a, o, i, e, u, y]
    println(intList1) // [1, 2, 3, 4, 5, 5, 4, 3, 2, 1]

    // USEFUL FUNCTIONS
    val intNumbers = mutableListOf(1, 2, 3, 4, 5)

    val vowels1 = mutableListOf('e', 'a', 'y', 'i', 'u', 'o')

//    println(intNumbers.minOrNull()) // 1
//    println(intNumbers.maxOrNull()) // 5
    println(intNumbers.sum())      // 15

    println(vowels1.sorted()) // [a, e, i, o, u, y]
    println(vowels1.sortedDescending()) // [y, u, o, i, e, a]

//    // MUTABLE LIST
//    val numbersMutable = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
//    numbersMutable[0] = 9999
//    println(numbersMutable) // [1, 2, 3, 4, 5]
}

val LINE_DELIMETER_LENGTH = 100;
val LINE_SPACES_COUNT = 3;
val LINE_DELIMETER_SIGN = "*";

private fun printPartHeadline(title: String) {
    val m = (LINE_DELIMETER_LENGTH - title.length - (LINE_SPACES_COUNT * 2)) / 2
    println(LINE_DELIMETER_SIGN.repeat(LINE_DELIMETER_LENGTH))

    print(LINE_DELIMETER_SIGN.repeat(m))
    print(" ".repeat(LINE_SPACES_COUNT))
    print(title)
    print(" ".repeat(LINE_SPACES_COUNT))
    print(LINE_DELIMETER_SIGN.repeat(LINE_DELIMETER_LENGTH - title.length - m - 2 * LINE_SPACES_COUNT))
    println()

    println(LINE_DELIMETER_SIGN.repeat(LINE_DELIMETER_LENGTH))
}

private fun arrayTest() {
    val regex = "\\s+".toRegex()
    val str = "1 2\t\t3  4\t5  6"
    val nums = str.split(regex).map { it.toInt() }.toTypedArray()
    println(nums.joinToString()) // 1, 2, 3, 4, 5, 6

    // ARRAY SIZE
    var numbers = intArrayOf(1, 2, 3, 4, 5)
    println(numbers.size) // 5

    // ELEMENT ACCESSING BY INDEX
    numbers = IntArray(3) // numbers: 0, 0, 0

    numbers[0] = 1 // numbers: 1, 0, 0
    numbers[1] = 2 // numbers: 1, 2, 0
    numbers[2] = numbers[0] + numbers[1] // numbers: 1, 2, 3

    println(numbers[0]) // 1, the first element
    println(numbers[2]) // 3, the last element

    // COMPARING ARRAYS
    val numbers1 = intArrayOf(1, 2, 3, 4)
    val numbers2 = intArrayOf(1, 2, 3, 4)
    val numbers3 = intArrayOf(1, 2, 3)

    println(numbers1.contentEquals(numbers2)) // true
    println(numbers1.contentEquals(numbers3)) // false

    // COMPARING ARRAYS
    // warning: the operators == and != do not compare the contents of arrays, they compare only the variables that point to the same object:
    val simpleArray = intArrayOf(1, 2, 3, 4)
    val similarArray = intArrayOf(1, 2, 3, 4)

    println(simpleArray == simpleArray)  // true, simpleArray points to the same object
    println(simpleArray == similarArray) // false, similarArray points to another object

    //JENERIC ARRAY DEFINING
    val stringArray = arrayOf<String>("array", "of", "strings")
    var newEmptyArray = emptyArray<String>()
    newEmptyArray += "Acrux"
    newEmptyArray += "Gacrux"
    newEmptyArray += "Imai"
    println(stringArray.joinToString())   //  Acrux, Gacrux, Imai, Mimosa
    println(newEmptyArray.joinToString())   //  Acrux, Gacrux, Imai, Mimosa

    //FOREACH
    val daysOfWeek = arrayOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")

    for (day in daysOfWeek) {
        println(day)
    }
    for (index in 1..5) {
        println("$index: ${daysOfWeek[index]}")
    }

    for (index in daysOfWeek.lastIndex downTo 0 step 2) {
        println("$index: ${daysOfWeek[index]}")
    }
}

private fun numberTest() {
    val v: Long = 1;
    val vInt: Int = 1;
    print("v = " + v)
    print("vInt = " + vInt)

    val vFloat: Float = 1.0f;
    val vDouble: Double = 1.0;
    print("vFloat = " + vFloat)
    println("vDouble = " + vDouble)
}

private fun stringTest() {
    val value = "55"
    val currency = "dollars"
    val price = "$value $currency" // "55 dollars"
    println(price)

    val language = "Kotlin"
    println("$language has ${language.length} letters in the name")

    // CHARS
    val greeting = "Hello"
    val firstChar = greeting[0]  // 'H'
    val secondChar = greeting[1] // 'e'
    val fiveChar = greeting.last()
    print(firstChar + " " + secondChar + " " + fiveChar)


    // EQUALITY
    val first = "first"
    val second = "second"
    var str = "first"
    println(first == str)    // true
    println(first == second) // false
    println(first != second) // true

    // SUBSTRING 1
    println(greeting.substring(0, 3)) // "Hel"
    println(greeting.substring(1, 3)) // "el"
    println(greeting.substring(2))    // "llo"
    println(greeting.substring(4, 5)) // "o"

    // SUBSTRING 2
    println(greeting.substringAfter('l'))  // "lo"
    println(greeting.substringBefore('o')) // "Hell"
    println(greeting.substringBefore('z')) // "Hello"

    // SUBSTRING 3
    println(greeting.substringAfterLast('l'))  // "o"
    println(greeting.substringBeforeLast('l')) // "Hel"

    // REPLACE 1
    var example = "Good morning..."
    println(example.replace("morning", "bye")) // "Good bye..."
    println(example.replace('.', '!'))         // "Good morning!!!"

    // REPLACE: DEMONSTRATE OF IMMUTABILITY
    example.replace("morning", "bye")
    println(example)

    // REPLACE 2
    example = "one one two three"
    println(example.replaceFirst("one", "two")) // "two one two three"

    // SPLITTING TO LIST / MUTABLE LIST
    val sentence = "a long text"
    val wordsList: List<String> = sentence.split(" ") // ["a", "long", "text"]
    val mutableWordList = sentence.split(" ").toMutableList() // MutableList ["a", "long", "text"]

    // ITERATING THROUGHT THE STRING
    val rainbow = "ROYGCBV"
    for (index in rainbow.indices) {
        println("${index + 1}: ${rainbow[index]}")
    }
}
