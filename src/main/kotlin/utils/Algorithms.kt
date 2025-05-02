package utils

fun findLargestNumber(inputList: List<Int>): Int? {

        if (inputList.isEmpty()) return null

        var max = inputList[0]

        for (i in 1 until inputList.size) {
            val current = inputList[i]
            if (current > max) {
                max = current
            }
        }

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
        val top = stack.removeLast()
        if (top != cleaned[i]) {
            return false
        }
    }

    return true
}

fun mostFrequentElement(inputList: List<String>): String? {

    if (inputList.isEmpty()) {
        return null
    }
    if (inputList.size == 1) {
        return inputList[0]
    }

    val frequencyMap = mutableMapOf<String, Int>()

    for (item in inputList) {
        if (frequencyMap.containsKey(item)) {
            frequencyMap[item] = frequencyMap[item]!! + 1
        } else {
            frequencyMap[item] = 1
        }
    }
    var maxFrequency = 0
    var mostFrequentItem: String? = null


    // return the first found most frequent item
    for (item in inputList) {
            val freq = frequencyMap[item] ?: 0
            if (freq > maxFrequency) {
                maxFrequency = freq
                mostFrequentItem = item
            }
    }
    return mostFrequentItem
}

fun countOccurrences(haystack: String, needle: String): Int {

    if (needle.isEmpty() || haystack.length < needle.length) {
        return 0
    }

    val lowerHaystack = haystack.lowercase()
    val lowerNeedle = needle.lowercase()

    var count = 0
    var currentIndex = 0

    while (currentIndex <= lowerHaystack.length - lowerNeedle.length) {
        if (lowerHaystack.substring(currentIndex, currentIndex + lowerNeedle.length) == lowerNeedle) {
            count++
            currentIndex += lowerNeedle.length  // Skip forward by full match length for non-overlapping
        } else {
            currentIndex++
        }
    }

    return count
}

