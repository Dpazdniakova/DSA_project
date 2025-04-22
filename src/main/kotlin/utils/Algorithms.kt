package utils

fun findLargestNumber(inputList: List<Int>): Int? {
        // Edge case: If the list is empty, return null
        if (inputList.isEmpty()) return null

        // Initialize max with the first element of the list
        var max = inputList[0]

        // Iterate through the list starting from the second element
        for (i in 1 until inputList.size) {
            val current = inputList[i]
            if (current > max) {
                max = current
            }
        }

        // Return the largest number found
        return max

}
fun countVowelsAndConsonants(input: String): Pair<Int, Int> {
    var vowels = 0
    var consonants = 0
    val vowelsList = "aeiou"

    for (char in input.lowercase())
        when {
            char.isLetter() && char in vowelsList  -> vowels++
            char.isLetter() && char !in vowelsList -> consonants++ }

    return Pair(vowels, consonants)
}

fun isPalindrome(input: String): Boolean {

    var cleaned = ""
    for (char in input) {
        if (char.isLetterOrDigit()) {
            cleaned += char.lowercaseChar()
        }
    }
    val length = cleaned.length
    if (length <= 1) return true

    val stack = ArrayDeque<Char>()
    val midpoint = length / 2


    for (i in 0 until midpoint) {
        stack.addLast(cleaned[i])
    }

    val startIndex = if (length % 2 == 0) midpoint else midpoint + 1

    for (i in startIndex until length) {
        val top = stack.removeLast() // acts as pop
        if (top != cleaned[i]) {
            return false
        }
    }

    return true
}
