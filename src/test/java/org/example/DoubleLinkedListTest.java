package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {
    DoubleLinkedList<Object> newList;

    @Nested
    @DisplayName("When new element created")
    class WhenNew {

        @BeforeEach
        public void createNewList() {
            newList = new DoubleLinkedList<>();
        }

        @Test
        @DisplayName("is empty")
        public void isEmpty_gettingSize_returnsTrueIfIsEmpty() {
            int expectedSize = 0;
            int currentSize = newList.size();

            assertEquals(expectedSize, currentSize);
        }

        @Test
        @DisplayName("Delete first when is empty")
        public void deleteFirst_whenEmpty_ReturnsException() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                newList.deleteFirst();
            });
        }

        @Test
        @DisplayName("Delete last when is empty")
        public void deleteLast_whenEmpty_ReturnsException() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                newList.deleteLast();
            });
        }

        @Nested
        @DisplayName("after append an element")
        class AfterAppend {
            String element = "Node1";
            LinkedNode<String> node;

            @BeforeEach
            public void appendElement_whenIsEmpty() {
                node = new LinkedNode<>(element, null, null);

                newList.append(node);
            }

            @Test
            @DisplayName("Check size")
            public void isNotEmpty_afterAppendNewElement_returnNewSize() {
                int notExpectedValue = 0;
                int currentSize = newList.size();

                assertNotEquals(notExpectedValue, currentSize);
            }

            @Test
            @DisplayName("check last")
            public void getLast_afterPrependElement_returnNewLastElement() {
                Object last = newList.last();

                assertEquals(last.toString(), node.toString());
            }

            @Nested
            @DisplayName("after delete last element")
            class afterDeleteLast {

                @BeforeEach
                public void deleteLastElement_whenIsEmpty() {
                    newList.deleteLast();
                }

                @Test
                @DisplayName("is Empty")
                public void isEmpty_afterDeleteLast_returnNewSize() {
                    int expectedSize = 0;
                    int currentSize = newList.size();

                    assertEquals(expectedSize, currentSize);
                }
            }
        }

        @Nested
        @DisplayName("after prepend an element")
        class afterPrepend{
            String element = "Node1";
            LinkedNode<String> node;

            @BeforeEach
            public void prependElement_whenIsEmpty() {
                node = new LinkedNode<>(element, null, null);

                newList.prepend(node);
            }

            @Test
            @DisplayName("Check size")
            public void isNotEmpty_afterPrependNewElement_returnNewSize() {
                int notExpectedValue = 0;
                int currentSize = newList.size();

                assertNotEquals(notExpectedValue, currentSize);
            }

            @Test
            @DisplayName("check first")
            public void getFirst_afterAppendAnElement_returnNewFirstElement() {
                Object first = newList.first();

                assertEquals(first.toString(), node.toString());
            }

            @Nested
            @DisplayName("after delete first element")
            class afterDeleteFirst {

                @BeforeEach
                public void deleteFirstElement_whenIsNotEmpty() {
                    newList.deleteFirst();
                }

                @Test
                @DisplayName("is Empty")
                public void isEmpty_afterDeleteFirst_returnNewSize() {
                    int expectedSize = 0;
                    int currentSize = newList.size();

                    assertEquals(expectedSize, currentSize);
                }
            }
        }
    }
}
