package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class NodeLinkedTest {

    LinkedNode<String> linkedNode1;
    LinkedNode<String> linkedNode2;
    LinkedNode<String> linkedNode3;

    @BeforeEach
    void initTest(){
        linkedNode1 = new LinkedNode<String>("item1",null,null);
        linkedNode3 = new LinkedNode<String>("item3",null,null);
        linkedNode2 = new LinkedNode<String>("item2",linkedNode1,linkedNode3);
        linkedNode1.setNext(linkedNode2);
        linkedNode3.setPrevious(linkedNode2);

    }

    @Test
    public void getItemTest(){
        assertEquals("item1",linkedNode1.getItem());
    }
    @Test
    public void getPreviousTest(){
        assertEquals(linkedNode2,linkedNode3.getPrevious());
    }
    @Test
    public void is_first_node_return_true_test(){
        assertTrue(linkedNode1.isFirstNode());
    }
    @Test
    public void is_first_node_return_false_test(){
        assertFalse(linkedNode2.isFirstNode());
    }
    @Test
    public void is_last_node_return_true_test(){
        assertTrue(linkedNode3.isLastNode());
    }
    @Test
    public void is_last_node_return_false_test(){
        assertFalse(linkedNode2.isLastNode());
    }

    @Test
    public void is_not_terminal_node_return_true_test(){
        assertTrue(linkedNode2.isNotATerminalNode());
    }
    @Test
    public void is_not_terminal_node_return_false_with_first_node_test(){
        assertFalse(linkedNode1.isNotATerminalNode());
    }
    @Test
    public void is_not_terminal_node_return_false_with_last_node_test(){
        assertFalse(linkedNode3.isNotATerminalNode());
    }

    @Test
    public void set_previous_test(){
        LinkedNode<String> newLinkedNode = new LinkedNode<String>("itemTest",null,linkedNode1);
        linkedNode1.setPrevious(newLinkedNode);
        assertEquals(newLinkedNode,linkedNode1.getPrevious());

    }
    @Test
    public void set_next_test(){
        LinkedNode<String> newLinkedNode = new LinkedNode<String>("itemTest",linkedNode3,null);
        linkedNode3.setNext(newLinkedNode);
        assertEquals(newLinkedNode,linkedNode3.getNext());

    }

    @Test
    public void set_item_test(){
        linkedNode3.setItem("newItem");
        assertEquals("newItem",linkedNode3.getItem());

    }


}
