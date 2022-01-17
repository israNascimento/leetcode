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
class BinarySearch704 {
    @Test
    fun testScenario() {
        assertEquals(4, search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
        assertEquals(-1, search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    }

    private fun search(nums: IntArray, target: Int): Int {
        var currentMax = nums.count() - 1
        var currentMin = 0
        var searchIndex: Int
        while(currentMin <= currentMax) {
            searchIndex = currentMin + (currentMax - currentMin)/2

            if(target == nums[searchIndex]) {
                return searchIndex
            }
            if(target > nums[searchIndex]) {
                currentMin = searchIndex + 1
            }
            if(target < nums[searchIndex]) {
                currentMax = searchIndex -1
            }
        }
        return -1
    }


}