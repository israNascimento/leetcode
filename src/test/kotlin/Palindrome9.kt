import org.junit.Test
import kotlin.test.assertEquals

/***
 * https://leetcode.com/problems/palindrome-number/
 *
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome while 123 is not.
 *
 * OBS: Resolve without convert to string
 */

class PalindromeNumber9 {
    @Test
    fun testCase() {
        assertEquals(true, isPalindrome(121))
        assertEquals(false, isPalindrome(432))
        assertEquals(false, isPalindrome(-232))
    }

    private fun isPalindrome(x: Int): Boolean {
        if(x < 0) {
            return false
        }
        var auxX = x
        val palindromeList = mutableListOf<Int>()
        while(auxX != 0) {
            palindromeList.add(auxX % 10)
            auxX /= 10
        }
        val original = palindromeList as List<*>
        val reversedList = palindromeList.asReversed()
        return original == reversedList
    }
}