import org.junit.Test
import kotlin.test.assertEquals

class MergeSortedLists {
    data class ListNode(
        val `val`: Int,
        var next: ListNode? = null
    )

    private val node1_3 = ListNode(4)
    private val node1_2 = ListNode(2, next = node1_3)
    val list1 = ListNode(1, next = node1_2)

    val node2_3 = ListNode(4)
    val node2_2 = ListNode(3, next = node2_3)
    val list2 = ListNode(1, next = node2_2)

    val expectedNode6 = ListNode(4)
    val expectedNode5 = ListNode(4, expectedNode6)
    val expectedNode4 = ListNode(3, expectedNode5)
    val expectedNode3 = ListNode(2, expectedNode4)
    val expectedNode2 = ListNode(1, expectedNode3)
    val expectedList = ListNode(1, expectedNode2)

    @Test
    fun testCase() {
        assertEquals(
            expectedList,
            mergeTwoList(list1, list2)
        )
    }

    private fun mergeTwoList(
        list1: ListNode?,
        list2: ListNode?
    ): ListNode? {
        var temp1 = list1
        var temp2 = list2

        val newRoot = ListNode(-1)

        var previous: ListNode? = newRoot
        while(temp1 != null && temp2 != null) {
            if(temp1.`val` > temp2.`val`) {
                previous?.next = temp2
                temp2 = temp2.next
            } else {
                previous?.next = temp1
                temp1 = temp1.next
            }
            previous = previous?.next
        }

        previous?.next = temp1 ?: temp2
        return newRoot.next
    }
}