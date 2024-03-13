class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        
       ListNode dummy=new ListNode(0);
       HashMap<Integer,ListNode> map=new HashMap<>(); // prefixSum->Node

       dummy.next=head;
       map.put(0,dummy);

      int prefixSum=0;
         while(head !=null)
         {
            prefixSum+=head.val;

            if(map.containsKey(prefixSum))
            {
                ListNode start=map.get(prefixSum);
                ListNode temp=start;
                int sum=prefixSum;
                while(temp !=head)
                {
                    temp=temp.next;
                    sum+=temp.val;
                    if(temp!=head)
                     map.remove(sum);
                }

                start.next=head.next;
            }
            else{
                map.put(prefixSum,head);
            }
            head=head.next;
         }
        return dummy.next;
    }
}
