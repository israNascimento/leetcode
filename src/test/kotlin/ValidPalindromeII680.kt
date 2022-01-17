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

class ValidPalindromeII680 {
    @Test
    fun testCase() {
        assertEquals(false, isPalindrome("tebbem"))
        assertEquals(true, isPalindrome("yd"))
        assertEquals(true, isPalindrome("a"))
        assertEquals(true, isPalindrome("bc"))
        assertEquals(true, isPalindrome("aba"))
        assertEquals(true, isPalindrome("abca"))
        assertEquals(false, isPalindrome("abc"))
    }

    private fun isPalindrome(s: String): Boolean {
        if(s.count() <= 2) return true
        return isPalindrome(s, false)
    }

    private fun isPalindrome(s: String, hasRemovedItem: Boolean): Boolean {
        val charCount = s.count()

        if(charCount == 2 && s[0] != s[1]){
            return false
        }
        for(i in 0..charCount/2) {
            val mirroredCharIndex = getMirrorCharIndex(s, i)
            if(s[i] != s[mirroredCharIndex]) {
                if(hasRemovedItem) return false
                return isPalindrome(s.removeRange(IntRange(i, i)), true)
                        || isPalindrome(s.removeRange(IntRange(mirroredCharIndex, mirroredCharIndex)), true)
            }
        }
        return true
    }

    private fun getMirrorCharIndex(s: String, i: Int) = s.count() - 1 - i
}