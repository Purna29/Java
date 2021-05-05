public class DoubleLinkedSeq implements Cloneable {

    public int totalNodes;
    public DoubleNode head;
    public DoubleNode tail;
    public DoubleNode cursor;

    public DoubleLinkedSeq() {
        totalNodes = 0;
        head = null;
        tail = null;
        cursor = head;
    }

    public void addAfter(double element) {
        if (isCurrent()) {
            cursor.addNodeAfter(element);
            cursor = cursor.getLink();
        } else {
            if (totalNodes == 0) {
                head = new DoubleNode(element, null);
                tail = head;
            } else {
                tail.addNodeAfter(element);
                tail = tail.getLink();
            }
            cursor = tail;
        }
        totalNodes++;

    }

    public void print() {
        System.out.println("Length=" + totalNodes);
        if (isCurrent() == false) {
            System.out.println("There is No Current Element");
        } else {
            System.out.println("current element =" + cursor.getData());
        }
        System.out.println("" + toString());
        System.out.println("\n");
    }

    public void start() {
        if (tail == null) {
            cursor = null;
        }
        cursor = tail;
    }

    public void advance() {
        if (isCurrent() == true) {
            cursor = cursor.getLink();
        } else {
            throw new IllegalStateException("There is No Current Element");
        }

    }

    public void removeCurrent() {
        if (isCurrent() == false) {
            throw new IllegalStateException("There is No Current Element");
        } else if (totalNodes == 0) {
            throw new IllegalStateException("List Is Empty");
        }

        if (cursor == null) {
            throw new IllegalStateException("There is No current Node.");
        } else {
            if (cursor == tail) {
                DoubleNode previous;
                for (previous = head; previous.getLink() != tail; previous = previous.getLink())
                    ;
                previous.setLink(null);
                tail = previous;
                totalNodes--;
            } else {
                DoubleNode nextNode = cursor.getLink();
                DoubleNode temp = tail;
                for (temp = tail; temp.getLink() != cursor; temp = temp.getLink())
                    ;
                cursor.setLink(nextNode);
                cursor = nextNode;
                temp.setLink(cursor);
                totalNodes--;
            }

        }

    }

    public void addBefore(double d) {
        if (totalNodes == 0) {
            head = new DoubleNode(d, null);
            tail = head;
            cursor = head;
        } else if (!isCurrent() || cursor == tail) {
            tail = new DoubleNode(d, tail);
            cursor = tail;
        } else {
            cursor.setLink(new DoubleNode(cursor.getData(), cursor.getLink()));
            cursor.setData(d);
        }
        totalNodes++;

    }

    public void addAll(DoubleLinkedSeq s) {
        if (s == null) {
            throw new IllegalArgumentException("addAll: addend is null");
        } else {
            DoubleNode temp;
            for (temp = tail; temp.getLink() != null; temp = temp.getLink())
                ;
            temp.setLink(s.tail);
            totalNodes += s.totalNodes;
        }

    }

    public DoubleLinkedSeq clone() {
        DoubleLinkedSeq answer;
        try {
            answer = (DoubleLinkedSeq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable.");
        }
        answer.head = DoubleNode.listCopy(head);
        answer.tail = DoubleNode.listCopy(tail);
        DoubleNode temp;
        for (temp = answer.tail; temp.getData() != cursor.getData(); temp = temp.getLink())
            ;
        answer.cursor = temp;
        return answer;
    }

    public static DoubleLinkedSeq catenation(DoubleLinkedSeq s, DoubleLinkedSeq t) {
        DoubleLinkedSeq answer = new DoubleLinkedSeq();

        if ((s == null) || (t == null)) {
            throw new IllegalArgumentException("concatenation: one argument is null");
        }
        DoubleNode temp;
        for (temp = s.tail; temp.getLink() != null; temp = temp.getLink())
            ;
        temp.setLink(t.tail);
        answer.tail = s.tail;
        answer.head = s.tail;
        answer.totalNodes = s.totalNodes + t.totalNodes;

        return answer;
    }

    public Object getCurrent() {
        if (isCurrent() == true) {
            return cursor.getData();
        } else
            throw new IllegalStateException("There is No Current Element");

    }

    public boolean isCurrent() {
        boolean answer = false;
        if (cursor != null) {
            answer = true;
        }

        return answer;
    }

    public String toString() {
        String str = "Elements: ";
        for (DoubleNode temp = tail; temp != null; temp = temp.getLink()) {
            str = str + ' ' + temp.getData();
        }
        return str;
    }

}
