package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {
    DoubleLinkedList<Object> newList;

    @Nested
    @DisplayName("When new list is created")
    class WhenNew {

        @BeforeEach
        public void createNewList() {
            newList = new DoubleLinkedList<>();
        }

        @Test
        @DisplayName("check is empty")
        public void size_whenEmpty_returnExpectedSize() {
            int expectedSize = 0;

            int currentSize = newList.size();

            assertEquals(expectedSize, currentSize);
        }

        @Test
        @DisplayName("delete first when is empty")
        public void deleteFirst_whenEmpty_returnException() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                newList.deleteFirst();
            });
        }

        @Test
        @DisplayName("delete last when is empty")
        public void deleteLast_whenEmpty_returnException() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                newList.deleteLast();
            });
        }

        @Test
        @DisplayName("get first when is empty")
        public void first_whenEmpty_returnsException() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                newList.last();
            });
        }

        @Test
        @DisplayName("get last when is empty")
        public void last_whenEmpty_returnsException() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                newList.first();
            });
        }

        @Test
        @DisplayName("remove when is empty")
        public void remove_whenEmpty_returnsException() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                newList.remove("e");
            });
        }

        @Nested
        @DisplayName("After append one element")
        class AfterAppend {
            String element = "Node1";
            LinkedNode<String> node;

            @BeforeEach
            public void appendElement_whenIsEmpty() {
                node = new LinkedNode<>(element, null, null);

                newList.append(node);
            }

            @Test
            @DisplayName("check size")
            public void size_afterAppendNewElement_returnExpectedSize() {
                int notExpectedValue = 0;
                int currentSize = newList.size();

                assertNotEquals(notExpectedValue, currentSize);
            }

            @Test
            @DisplayName("check last")
            public void last_afterAppendElement_returnLastElement() {
                Object expectedValue = node.toString();
                Object returnedValue = newList.last().toString();

                assertEquals(expectedValue, returnedValue);
            }

            @Test
            @DisplayName("check first")
            public void first_afterAppendElement_returnFirstElement() {
                Object expectedValue = node.toString();
                Object returnedValue = newList.first().toString();

                assertEquals(expectedValue, returnedValue);
            }

            @Nested
            @DisplayName("After append another element")
            class AfterAppendAnotherElement {

                String anotherElement = "Node2";
                LinkedNode<String> anotherNode;

                @BeforeEach
                public void append_whenSizeMoreThanOne() {
                    anotherNode = new LinkedNode<>(anotherElement, null, null);

                    newList.append(anotherNode);
                }

                @Test
                @DisplayName("check size")
                public void size_afterAppendAnotherElement_returnNewSize() {
                    int notExpectedValue = 0;
                    int expectedValue = 2;

                    int returnedValue = newList.size();

                    assertNotEquals(notExpectedValue, returnedValue);
                    assertEquals(expectedValue, returnedValue);
                }

                @Test
                @DisplayName("check first")
                public void first_afterAppendAnotherElement_returnFirstElement() {
                    Object notExpectedValue = anotherNode.toString();
                    Object expectedValue = node.toString();
                    Object returnedValue = newList.first().toString();

                    assertEquals(expectedValue, returnedValue);
                    assertNotEquals(notExpectedValue, returnedValue);
                }

                @Test
                @DisplayName("check last")
                public void last_afterAppendAnotherElement_returnLastElement() {
                    Object notExpectedValue = node.toString();
                    Object expectedValue = anotherNode.toString();
                    Object returnedValue = newList.last().toString();

                    assertEquals(expectedValue, returnedValue);
                    assertNotEquals(notExpectedValue, returnedValue);
                }

                @Nested
                @DisplayName("After delete last element when size greater than one")
                class AfterDeleteLast {

                    @BeforeEach
                    public void deleteLastElement_whenIsNotEmpty() {
                        newList.deleteLast();
                    }

                    @Test
                    @DisplayName("check size")
                    public void size_afterDeleteLast_returnNewSize() {
                        int expectedSize = 1;
                        int currentSize = newList.size();

                        assertEquals(expectedSize, currentSize);
                    }

                    @Test
                    @DisplayName("check first")
                    public void first_afterDeleteLast_returnFirstElement() {
                        Object expectedValue = node.toString();
                        Object returnedValue = newList.first().toString();

                        assertEquals(expectedValue, returnedValue);
                    }

                    @Test
                    @DisplayName("check last")
                    public void last_afterDeleteLast_returnLastElement() {
                        Object expectedValue = node.toString();
                        Object returnedValue = newList.last().toString();

                        assertEquals(expectedValue, returnedValue);
                    }
                }
            }

            @Nested
            @DisplayName("After delete last element")
            class afterDeleteLast {

                @BeforeEach
                public void deleteLastElement_whenIsEmpty() {
                    newList.deleteLast();
                }

                @Test
                @DisplayName("check is empty")
                public void empty_afterDeleteLast_returnNewSize() {
                    int expectedSize = 0;
                    int currentSize = newList.size();

                    assertEquals(expectedSize, currentSize);
                }
            }
        }

        @Nested
        @DisplayName("After prepend one element")
        class AfterPrepend {
            String element = "Node1";
            LinkedNode<String> node;

            @BeforeEach
            public void prependElement_whenIsEmpty() {
                node = new LinkedNode<>(element, null, null);

                newList.prepend(node);
            }

            @Test
            @DisplayName("check size")
            public void size_afterPrependNewElement_returnNewSize() {
                int notExpectedValue = 0;
                int currentSize = newList.size();

                assertNotEquals(notExpectedValue, currentSize);
            }

            @Test
            @DisplayName("check first")
            public void first_afterPrependElement_returnFirstElement() {
                Object expectedValue = node.toString();
                Object returnedValue = newList.first().toString();

                assertEquals(expectedValue, returnedValue);
            }

            @Test
            @DisplayName("check last")
            public void last_afterPrependElement_returnLastElement() {
                Object expectedValue = node.toString();
                Object returnedValue = newList.last().toString();

                assertEquals(expectedValue, returnedValue);
            }

            @Test
            @DisplayName("remove first")
            public void removeFirstElement() {

                int sizeActu = newList.size();
                newList.remove(node);
                int newSize = newList.size();
                assertEquals(sizeActu - 1,newSize);
            }

            @Nested
            @DisplayName("After prepend another element")
            class AfterPrependAnotherElement {

                String anotherElement = "Node2";
                LinkedNode<String> anotherNode;

                @BeforeEach
                public void prepend_whenSizeMoreThanOne() {
                    anotherNode = new LinkedNode<>(anotherElement, null, null);

                    newList.prepend(anotherNode);
                }

                @Test
                @DisplayName("check size")
                public void size_afterPrependAnotherElement_returnNewSize() {
                    int notExpectedValue = 0;
                    int expectedValue = 2;

                    int returnedValue = newList.size();

                    assertNotEquals(notExpectedValue, returnedValue);
                    assertEquals(expectedValue, returnedValue);
                }

                @Test
                @DisplayName("check first")
                public void first_afterPrependAnotherElement_returnFirstElement() {
                    Object notExpectedValue = node.toString();
                    Object expectedValue = anotherNode.toString();
                    Object returnedValue = newList.first().toString();

                    assertEquals(expectedValue, returnedValue);
                    assertNotEquals(notExpectedValue, returnedValue);
                }

                @Test
                @DisplayName("check last")
                public void last_afterPrependAnotherElement_returnLastElement() {
                    Object notExpectedValue = anotherNode.toString();
                    Object expectedValue = node.toString();
                    Object returnedValue = newList.last().toString();

                    assertEquals(expectedValue, returnedValue);
                    assertNotEquals(notExpectedValue, returnedValue);
                }


                @Test
                @DisplayName("get element position 0")
                public void getElementPosition0ReturnFirst() {

                    assertEquals(newList.first(), newList.get(0));

                }
                @Test
                @DisplayName("get element position 1")
                public void getElementPosition1ReturnLast() {

                    assertEquals(newList.last(), newList.get(1));

                }

                @Test
                @DisplayName("get element position not exist")
                public void getElementPositionNotExistThrowsException() {

                    assertThrows(DoubleLinkedQueueException.class, () -> {
                        newList.get(5);
                    });

                }

                @Test
                @DisplayName("contain return true")
                public void containWhenElementIsInside() {

                    assertTrue(newList.contains(anotherNode));

                }

                @Test
                @DisplayName("contain return false")
                public void containWhenElementIsNotInside() {


                    LinkedNode<String> anotherNode2 = new LinkedNode<>("new elem", null, null);
                    assertFalse(newList.contains(anotherNode2));

                }

                @Test
                @DisplayName("contain return false then true")
                public void containWhenElementIsNotInsideThenAddAndReTest() {


                    LinkedNode<String> anotherNode2 = new LinkedNode<>("new elem", null, null);
                    assertFalse(newList.contains(anotherNode2));
                    newList.prepend(anotherNode2);
                    assertTrue(newList.contains(anotherNode2));

                }

                @Test
                @DisplayName("remove last")
                public void removeLastElement() {

                    int sizeActu = newList.size();
                    newList.remove(node);
                    int newSize = newList.size();
                    assertEquals(sizeActu - 1,newSize);
                }

                @Test
                @DisplayName("remove when more than 2 elements")
                public void removeWhenMoreThan2ElementRemoveBeforeLast() {

                    LinkedNode<String> anotherNode3 = new LinkedNode<>("elem3", null, null);
                    LinkedNode<String> anotherNode4 = new LinkedNode<>("elem4", null, null);
                    newList.prepend(anotherNode3);
                    newList.prepend(anotherNode4);

                    int sizeActu = newList.size();
                    System.out.println(sizeActu);
                    newList.remove(anotherNode);
                    int newSize = newList.size();
                    assertEquals(sizeActu - 1,newSize);
                }
                @Test
                @DisplayName("remove when more than 2 elements")
                public void removeWhenMoreThan2ElementRemoveFirst() {

                    LinkedNode<String> anotherNode3 = new LinkedNode<>("elem3", null, null);
                    LinkedNode<String> anotherNode4 = new LinkedNode<>("elem4", null, null);
                    newList.prepend(anotherNode3);
                    newList.prepend(anotherNode4);

                    int sizeActu = newList.size();
                    System.out.println(sizeActu);
                    newList.remove(anotherNode4);
                    int newSize = newList.size();
                    assertEquals(sizeActu - 1,newSize);
                }

                @Test
                @DisplayName("remove when more than 2 elements")
                public void removeAndNotContainTest() {

                    LinkedNode<String> anotherNode3 = new LinkedNode<>("elem3", null, null);


                    int sizeActu = newList.size();
                    System.out.println(sizeActu);
                    newList.remove(anotherNode3);
                    int newSize = newList.size();
                    assertEquals(sizeActu,newSize);
                }

                @Test
                @DisplayName("remove when more than 2 elements")
                public void removeWhenMoreThan2ElementAndNotContainTest() {

                    LinkedNode<String> anotherNode3 = new LinkedNode<>("elem3", null, null);
                    LinkedNode<String> anotherNode4 = new LinkedNode<>("elem4", null, null);
                    newList.prepend(anotherNode3);

                    int sizeActu = newList.size();
                    System.out.println(sizeActu);
                    newList.remove(anotherNode4);
                    int newSize = newList.size();
                    assertEquals(sizeActu,newSize);
                }

                @Test
                @DisplayName("remove when more than 2 elements")
                public void removeWhenMoreThan2ElementTestRemoveSecond() {

                    LinkedNode<String> anotherNode3 = new LinkedNode<>("elem3", null, null);
                    LinkedNode<String> anotherNode4 = new LinkedNode<>("elem4", null, null);
                    newList.prepend(anotherNode3);
                    newList.prepend(anotherNode4);

                    int sizeActu = newList.size();
                    System.out.println(sizeActu);
                    newList.remove(anotherNode3);
                    int newSize = newList.size();
                    assertEquals(sizeActu-1,newSize);
                }



                @Nested
                @DisplayName("After delete first element when size greater than one")
                class AfterDeleteFirst {

                    @BeforeEach
                    public void deleteFirstElement_whenIsNotEmpty() {
                        newList.deleteFirst();
                    }

                    @Test
                    @DisplayName("check size")
                    public void size_afterDeleteFirst_returnNewSize() {
                        int expectedSize = 1;
                        int currentSize = newList.size();

                        assertEquals(expectedSize, currentSize);
                    }

                    @Test
                    @DisplayName("check first")
                    public void first_afterDeleteFirst_returnFirstElement() {
                        Object expectedValue = node.toString();
                        Object returnedValue = newList.first().toString();

                        assertEquals(expectedValue, returnedValue);
                    }

                    @Test
                    @DisplayName("check last")
                    public void last_afterDeleteFirst_returnLastElement() {
                        Object expectedValue = node.toString();
                        Object returnedValue = newList.last().toString();

                        assertEquals(expectedValue, returnedValue);
                    }
                }
            }

            @Nested
            @DisplayName("After delete first element")
            class AfterDeleteFirst {

                @BeforeEach
                public void deleteFirst_whenIsNotEmpty() {
                    newList.deleteFirst();
                }

                @Test
                @DisplayName("check is empty")
                public void size_afterDeleteFirst_returnNewSize() {
                    int expectedSize = 0;
                    int currentSize = newList.size();

                    assertEquals(expectedSize, currentSize);
                }
            }
        }
    }
}
