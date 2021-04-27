package montotone.com.github.www;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

public class TestJava {

    @Test
    public void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList();

//        for (int x = 0; x <10; x++) {
//            Random random = new Random();
//            int i = (int) (random.nextDouble()*10);
//            System.out.println(i);
//              testLinkedLists( linkedList,i);
//        }

        testLinkedLists( linkedList,6);
        testLinkedLists( linkedList,5);
        testLinkedLists( linkedList,4);
        testLinkedLists( linkedList,5);
        testLinkedLists( linkedList,7);

    }

    public LinkedList<Integer> testLinkedLists( LinkedList<Integer> linkedList, int x) {

        //点击1
        int sameCount = 0;
        if (linkedList.size() == 2) {
            for (int i = 0; i < linkedList.size(); i++) {

                if (linkedList.get(i) == x) {
                    sameCount++;
                    linkedList.remove(i);
                }
            }
        }
        if (sameCount==0&&linkedList.size() < 3) {
            linkedList.add(x);
        }

        if (sameCount == 0 && linkedList.size() == 3) {
            linkedList.removeFirst();
//            linkedList.addLast(a1);
        }
        for (int a : linkedList) {
            System.out.print("click a1=" + a);
        }
        System.out.println("");
        return linkedList;
    }
}
