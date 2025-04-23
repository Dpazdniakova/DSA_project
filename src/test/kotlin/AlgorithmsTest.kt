import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import utils.*


@Nested
class VowelsConsonantsTest {
    @Test
    fun `should count vowels and consonants in a regular word`() {
        val input = "hello"
        val expected = Pair(2, 3)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "The count of vowels and consonants should match")
    }

    @Test
    fun `should handle an empty string`() {
        val input = ""
        val expected = Pair(0, 0)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "An empty string should return (0, 0)")
    }

    @Test
    fun `should count vowels and consonants in a single vowel`() {
        val input = "a"
        val expected = Pair(1, 0)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "A single vowel should return (1, 0)")
    }

    @Test
    fun `should count vowels and consonants in a single consonant`() {
        val input = "z"
        val expected = Pair(0, 1)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "A single consonant should return (0, 1)")
    }

    @Test
    fun `should handle mixed case input`() {
        val input = "HElloWOrld"
        val expected = Pair(3, 7)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "The function should handle mixed case correctly")
    }

    @Test
    fun `should ignore non-alphabetic characters`() {
        val input = "h3llo w@rld!"
        val expected = Pair(1, 7)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "Non-alphabetic characters should be ignored")
    }

    @Test
    fun `should handle input with only vowels`() {
        val input = "aeiouAEIOU"
        val expected = Pair(10, 0)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "All vowels should be counted correctly")
    }

    @Test
    fun `should handle input with only consonants`() {
        val input = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ"
        val expected = Pair(0, 42)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "All consonants should be counted correctly")
    }

    @Test
    fun `should handle input with spaces and special characters`() {
        val input = "The quick brown fox jumps over the lazy dog!"
        val expected = Pair(11, 24)
        val result = countVowelsAndConsonants(input)
        assertEquals(expected, result, "Spaces and special characters should not be counted")
    }
}


@Nested
class FindLargestNumberTest {

    @Test
    fun `should return null for an empty list`() {
        val inputList = emptyList<Int>()
        val result = findLargestNumber(inputList)
        assertNull(result, "Expected null for an empty list")
    }

    @Test
    fun `should return the only element in a single-item list`() {
        val inputList = listOf(42)
        val result = findLargestNumber(inputList)
        assertEquals(42, result, "Expected the only element for a single-item list")
    }

    @Test
    fun `should return the correct largest number for a list of positive integers`() {
        val inputList = listOf(1, 3, 7, 2, 5)
        val result = findLargestNumber(inputList)
        assertEquals(7, result, "Expected the largest number from the list")
    }

    @Test
    fun `should return the correct largest number for a list with negative integers`() {
        val inputList = listOf(-10, -20, -3, -50)
        val result = findLargestNumber(inputList)
        assertEquals(-3, result, "Expected the largest number from the negative integers list")
    }

    @Test
    fun `should return the correct largest number for a list with duplicate largest numbers`() {
        val inputList = listOf(4, 4, 4, 4)
        val result = findLargestNumber(inputList)
        assertEquals(4, result, "Expected the correct largest number even with duplicates")
    }

    @Test
    fun `should return the correct largest number when the list has mixed positive and negative numbers`() {
        val inputList = listOf(-10, 0, 5, -3, 20, -1)
        val result = findLargestNumber(inputList)
        assertEquals(20, result, "Expected the correct largest number from a mixed list")
    }

    @Test
    fun `should return the correct largest number for a list with all zeros`() {
        val inputList = listOf(0, 0, 0, 0)
        val result = findLargestNumber(inputList)
        assertEquals(0, result, "Expected 0 for a list with all zeros")
    }

    @Test
    fun `should return the correct largest number for a very large list`() {
        val inputList = (1..1_000_000).toList()
        val result = findLargestNumber(inputList)
        assertEquals(1_000_000, result, "Expected the largest number from a very large list")
    }

    @Test
    fun `should handle a list with Int_MIN_VALUE and Int_MAX_VALUE correctly`() {
        val inputList = listOf(Int.MIN_VALUE, Int.MAX_VALUE)
        val result = findLargestNumber(inputList)
        assertEquals(Int.MAX_VALUE, result, "Expected Int.MAX_VALUE as the largest number")
    }

}

@Nested
class IsPalindromeTest {

    @Test
    fun `basic palindrome cases`() {
        assertTrue(isPalindrome("level"))
        assertTrue(isPalindrome("madam"))
        assertTrue(isPalindrome("racecar"))
        assertTrue(isPalindrome("abba"))
    }

    @Test
    fun `palindromes with mixed case`() {
        assertTrue(isPalindrome("Level"))
        assertTrue(isPalindrome("MadAm"))
        assertTrue(isPalindrome("RaceCar"))
    }

    @Test
    fun `palindromes with spaces and punctuation`() {
        assertTrue(isPalindrome("A man, a plan, a canal, Panama"))
        assertTrue(isPalindrome("No 'x' in Nixon"))
        assertTrue(isPalindrome("Was it a car or a cat I saw?"))
    }

    @Test
    fun `non-palindrome inputs`() {
        assertFalse(isPalindrome("hello"))
        assertFalse(isPalindrome("Palindrome"))
        assertFalse(isPalindrome("This is not a palindrome"))
    }

    @Test
    fun `edge cases`() {
        assertTrue(isPalindrome(""))
        assertTrue(isPalindrome(" "))
        assertTrue(isPalindrome(",.!"))
        assertTrue(isPalindrome("a"))
        assertTrue(isPalindrome("12321"))
        assertFalse(isPalindrome("12345"))
    }
}

@Nested
class FrequencyCounterTest {

    @Test
    fun `should return null for an empty list`() {
        val input = listOf<String>()
        val result = mostFrequentElement(input)
        assertNull(result)
    }

    @Test
    fun `should return the only element for a single-element list`() {
        val input = listOf("apple")
        val result = mostFrequentElement(input)
        assertEquals("apple", result)
    }

    @Test
    fun `should return the most frequent element when there is a clear winner`() {
        val input = listOf("apple", "banana", "apple", "orange", "banana", "apple")
        val result = mostFrequentElement(input)
        assertEquals("apple", result)
    }

    @Test
    fun `should return the first element in case of a tie`() {
        val input = listOf("apple", "banana", "apple", "banana")
        val result = mostFrequentElement(input)
        assertEquals("apple", result)
    }

    @Test
    fun `should return the first element when all elements are unique`() {
        val input = listOf("a", "b", "c", "d")
        val result = mostFrequentElement(input)
        assertEquals("a", result)
    }

    @Test
    fun `should treat strings with different cases as distinct elements`() {
        val input = listOf("Apple", "apple", "APPLE")
        val result = mostFrequentElement(input)
        assertEquals("Apple", result)
    }

    @Test
    fun `should return the correct element even with empty strings in the list`() {
        val input = listOf("apple", "banana", "", "apple")
        val result = mostFrequentElement(input)
        assertEquals("apple", result)
    }

    @Test
    fun `should return the correct result for a large list`() {
        val input = MutableList(1000) { "item${it % 10}" }
        input.add("item0")
        val result = mostFrequentElement(input)
        assertEquals("item0", result)
    }

    @Test
    fun `should return the first occurring element when multiple elements have the same highest frequency`() {
        val input = listOf("cat", "dog", "cat", "dog", "bird")
        val result = mostFrequentElement(input)
        assertEquals("cat", result)
    }

}

@Nested
class NeedleCounterTest {

    @Test
    fun `should return the correct number of non-overlapping matches for a basic input`() {
        val result = countOccurrences("banana", "na")
        assertEquals(2, result)
    }

    @Test
    fun `should return zero when the needle is an empty string`() {
        val result = countOccurrences("banana", "")
        assertEquals(0, result)
    }

    @Test
    fun `should return zero when the haystack is shorter than the needle`() {
        val result = countOccurrences("ba", "banana")
        assertEquals(0, result)
    }

    @Test
    fun `should return the correct count when the haystack and needle differ in case`() {
        val result = countOccurrences("BANANA", "na")
        assertEquals(2, result)
    }

    @Test
    fun `should return zero when the needle does not exist in the haystack`() {
        val result = countOccurrences("banana", "xy")
        assertEquals(0, result)
    }

    @Test
    fun `should count only non-overlapping matches when occurrences overlap`() {
        val result = countOccurrences("aaaaa", "aa")
        assertEquals(2, result)
    }

    @Test
    fun `should return one when the needle is the same as the haystack`() {
        val result = countOccurrences("abc", "abc")
        assertEquals(1, result)
    }

    @Test
    fun `should return the correct number of non-overlapping matches when the pattern appears multiple times`() {
        val result = countOccurrences("abcabcabc", "abc")
        assertEquals(3, result)
    }

    @Test
    fun `should return zero when the haystack is empty`() {
        val result = countOccurrences("", "a")
        assertEquals(0, result)
    }

    @Test
    fun `should return zero when both haystack and needle are empty`() {
        val result = countOccurrences("", "")
        assertEquals(0, result)
    }

    @Test
    fun `should count occurrences correctly even when haystack and needle contain spaces`() {
        val haystack = "   111   "
        val needle = " 1 "
        val result = countOccurrences(haystack.trim(), needle.trim())
        assertEquals(3, result)
    }

    @Test
    fun `should count occurrences correctly when they're symbols`() {
        val haystack = "!!!!"
        val needle = "! "
        val result = countOccurrences(haystack.trim(), needle.trim())
        assertEquals(4, result)
    }


}


