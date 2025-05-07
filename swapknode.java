package linkedlist;

public class swapknode {
        public Node swapKthNode(Node head, int k) {
            // code here
            if (head == null) return head ;
            
            Node temp = head;
            int n= 0 ;
            while (temp != null){
                n++;
                temp = temp.next;
            }
            if (k >n )return head ;
            if (2*k-1 == n) return head;
            
            Node prevX = null ;
            Node currX = head;
            for (int i = 1;i<k;i++){
                prevX= currX;
                currX = currX.next;
            }
            Node prevY = null;
            Node currY = head;
            for (int i = 1;i<n-k+1; i++){
                prevY = currY;
                currY = currY.next;
            }
            if (prevX != null){
                prevX.next = currY;
            }
            else {
                head = currY;
            }
            if(prevY != null){
                prevY.next = currX;
            }
            else {
                head = currX;
            }
            Node tempNode = currX.next ;
            currX.next= currY.next;
            currY.next = tempNode;
            return head;
        }
    }

