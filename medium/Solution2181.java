public class Solution2181 {
  public ListNode mergeNodes(ListNode head) {
    ListNode current = head;
    ListNode finalHead = null;
    int sum = 0;

    while (current != null) {

      if (current.val == 0) {
        if (sum > 0) {
          ListNode newTail = new ListNode(sum);
          sum = 0;

          if (finalHead == null) {
            finalHead = newTail;
          } else {
            ListNode last = finalHead.next;
            
            if (last == null) {
              finalHead.next = newTail;
            } else {
              while (last.next != null) {
                last = last.next;
              }

              last.next = newTail;
            }
          }
        }
      } else {
        sum += current.val;
      }

      current = current.next;
    }

    return finalHead;
  }

  /*
   * Constraints:
   * 
   * The number of nodes in the list is in the range [3, 2 * 105].
   * 0 <= Node.val <= 1000
   * There are no two consecutive nodes with Node.val == 0.
   * The beginning and end of the linked list have Node.val == 0.
   */

  public static void main(String[] args) {
    // [0,3,1,0,4,5,2,0]
    // ListNode head = new ListNode(0);
    // ListNode node1 = new ListNode(3);
    // ListNode node2 = new ListNode(1);
    // ListNode node3 = new ListNode(0);
    // ListNode node4 = new ListNode(4);
    // ListNode node5 = new ListNode(5);
    // ListNode node6 = new ListNode(2);
    // ListNode node7 = new ListNode(0);

    // [0,1,0,3,0,2,2,0]
    ListNode head = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(0);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(0);
    ListNode node5 = new ListNode(2);
    ListNode node6 = new ListNode(2);
    ListNode node7 = new ListNode(0);

    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;

    Solution2181 s = new Solution2181();
    ListNode output = s.mergeNodes(head);
    ListNode tmp = output;

    while (tmp != null) {
      System.out.print(tmp.val + " -> ");
      tmp = tmp.next;
    }
  }
}

// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
