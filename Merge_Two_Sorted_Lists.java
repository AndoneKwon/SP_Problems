//빈 head 객체를 만들고 그 헤드에 다음노드를 새로 만들어서 생성해준다.
//그러면서 그 다음 노드를 계속적으로 연결시켜준다.
//단 시작의 빈 head의 val에는 0이 들어가기 때문에 head.next를 리턴해준다.

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null ? l2 : l1;
        
        ListNode head = new ListNode();
        ListNode nextNode;

        if(l1.val>l2.val){
            head.next = new ListNode(l2.val);
            nextNode = head.next;
            l2=l2.next;
        }else{
            head.next = new ListNode(l1.val);
            nextNode = head.next;
            l1=l1.next;
        }
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                nextNode.next = l2;
                l2=l2.next;
            }else{
                nextNode.next = l1;
                l1=l1.next;
            }
            nextNode = nextNode.next;
        }
        
        if(l1 == null || l2 == null) nextNode.next = (l1 == null ? l2 : l1);

        return head.next;
    }
}
