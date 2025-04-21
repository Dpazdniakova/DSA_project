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