import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/***
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * https://leetcode.com/problems/valid-parentheses/
 */
class ValidParentheses20 {
    @Test
    fun testScenario() {
        assertEquals(true, isValid("()"))
        assertEquals(false, isValid("("))
        assertEquals(true, isValid("()[]{}"))
        assertEquals(false, isValid("[)"))
        assertEquals(true, isValid("([])"))
        assertEquals(true, isValid("([{}{}][()])"))
    }

    private fun isValid(s: String): Boolean {
        val openChars = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}'
        )

        val nextExpectedCloseStack = Stack<Char>()
        s.forEach {
            if(this.isOpen(it)) {
                nextExpectedCloseStack.push(openChars[it]!!)
            } else {
                if(nextExpectedCloseStack.isEmpty()) {
                    return@isValid false
                }
                val nextExpectedClose = nextExpectedCloseStack.pop()
                if(nextExpectedClose != it) {
                    return@isValid false
                }
            }
        }

        return nextExpectedCloseStack.isEmpty()
    }
    private fun isOpen(char: Char) = "([{".contains(char)
}