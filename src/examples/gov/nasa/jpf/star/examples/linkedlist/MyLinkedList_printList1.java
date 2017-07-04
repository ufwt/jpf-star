package gov.nasa.jpf.star.examples.linkedlist;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;

public class MyLinkedList_printList1 extends TestJPF {

	@Test
	public void test1() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		MyLinkedList theList = new MyLinkedList();
		MyListNode header = new MyListNode();
		MyListNode next = null;
		obj._header = null;
		obj._maxsize = 0;
		int size = 0;
		Object element = null;
		theList._header = header;
		theList._maxsize = size;
		header._element = element;
		header._next = next;
		obj.printList(theList);
	}

	@Test
	public void test2() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		MyLinkedList theList = new MyLinkedList();
		MyListNode header = new MyListNode();
		MyListNode next = new MyListNode();
		MyListNode next_2 = null;
		obj._header = null;
		obj._maxsize = 0;
		int size = 0;
		Object element = null;
		Object element_1 = null;
		theList._header = header;
		theList._maxsize = size;
		header._element = element;
		header._next = next;
		next._element = element_1;
		next._next = next_2;
		obj.printList(theList);
	}

	@Test
	public void test3() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		MyLinkedList theList = new MyLinkedList();
		MyListNode header = new MyListNode();
		MyListNode next = new MyListNode();
		MyListNode next_2 = new MyListNode();
		MyListNode next_4 = null;
		obj._header = null;
		obj._maxsize = 0;
		int size = 0;
		Object element = null;
		Object element_1 = null;
		Object element_3 = null;
		theList._header = header;
		theList._maxsize = size;
		header._element = element;
		header._next = next;
		next._element = element_1;
		next._next = next_2;
		next_2._element = element_3;
		next_2._next = next_4;
		obj.printList(theList);
	}

	@Test
	public void test4() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		MyLinkedList theList = new MyLinkedList();
		MyListNode header = new MyListNode();
		MyListNode next = new MyListNode();
		MyListNode next_2 = new MyListNode();
		MyListNode next_4 = new MyListNode();
		MyListNode next_6 = null;
		obj._header = null;
		obj._maxsize = 0;
		int size = 0;
		Object element = null;
		Object element_1 = null;
		Object element_3 = null;
		Object element_5 = null;
		theList._header = header;
		theList._maxsize = size;
		header._element = element;
		header._next = next;
		next._element = element_1;
		next._next = next_2;
		next_2._element = element_3;
		next_2._next = next_4;
		next_4._element = element_5;
		next_4._next = next_6;
		obj.printList(theList);
	}

	@Test
	public void test5() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		MyLinkedList theList = new MyLinkedList();
		MyListNode header = new MyListNode();
		MyListNode next = new MyListNode();
		MyListNode next_2 = new MyListNode();
		MyListNode next_4 = new MyListNode();
		MyListNode next_6 = new MyListNode();
		MyListNode next_8 = null;
		obj._header = null;
		obj._maxsize = 0;
		int size = 0;
		Object element = null;
		Object element_1 = null;
		Object element_3 = null;
		Object element_5 = null;
		Object element_7 = null;
		theList._header = header;
		theList._maxsize = size;
		header._element = element;
		header._next = next;
		next._element = element_1;
		next._next = next_2;
		next_2._element = element_3;
		next_2._next = next_4;
		next_4._element = element_5;
		next_4._next = next_6;
		next_6._element = element_7;
		next_6._next = next_8;
		obj.printList(theList);
	}

	@Test
	public void test6() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		MyLinkedList theList = new MyLinkedList();
		MyListNode header = new MyListNode();
		MyListNode next = new MyListNode();
		MyListNode next_2 = new MyListNode();
		MyListNode next_4 = new MyListNode();
		MyListNode next_6 = new MyListNode();
		MyListNode next_8 = new MyListNode();
		MyListNode next_10 = null;
		obj._header = null;
		obj._maxsize = 0;
		int size = 0;
		Object element = null;
		Object element_1 = null;
		Object element_3 = null;
		Object element_5 = null;
		Object element_7 = null;
		Object element_9 = null;
		theList._header = header;
		theList._maxsize = size;
		header._element = element;
		header._next = next;
		next._element = element_1;
		next._next = next_2;
		next_2._element = element_3;
		next_2._next = next_4;
		next_4._element = element_5;
		next_4._next = next_6;
		next_6._element = element_7;
		next_6._next = next_8;
		next_8._element = element_9;
		next_8._next = next_10;
		obj.printList(theList);
	}

	@Test
	public void test7() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		MyLinkedList theList = new MyLinkedList();
		MyListNode header = new MyListNode();
		MyListNode next = new MyListNode();
		MyListNode next_2 = new MyListNode();
		MyListNode next_4 = new MyListNode();
		MyListNode next_6 = new MyListNode();
		MyListNode next_8 = new MyListNode();
		MyListNode next_10 = new MyListNode();
		MyListNode next_12 = null;
		obj._header = null;
		obj._maxsize = 0;
		int size = 0;
		Object element = null;
		Object element_1 = null;
		Object element_3 = null;
		Object element_5 = null;
		Object element_7 = null;
		Object element_9 = null;
		Object element_11 = null;
		theList._header = header;
		theList._maxsize = size;
		header._element = element;
		header._next = next;
		next._element = element_1;
		next._next = next_2;
		next_2._element = element_3;
		next_2._next = next_4;
		next_4._element = element_5;
		next_4._next = next_6;
		next_6._element = element_7;
		next_6._next = next_8;
		next_8._element = element_9;
		next_8._next = next_10;
		next_10._element = element_11;
		next_10._next = next_12;
		obj.printList(theList);
	}

	@Test
	public void test8() throws Exception {
		MyLinkedList obj = new MyLinkedList();
		MyLinkedList theList = new MyLinkedList();
		MyListNode header = new MyListNode();
		MyListNode next = new MyListNode();
		MyListNode next_2 = new MyListNode();
		MyListNode next_4 = new MyListNode();
		MyListNode next_6 = new MyListNode();
		MyListNode next_8 = new MyListNode();
		MyListNode next_10 = new MyListNode();
		MyListNode next_12 = new MyListNode();
		MyListNode next_14 = null;
		obj._header = null;
		obj._maxsize = 0;
		int size = 0;
		Object element = null;
		Object element_1 = null;
		Object element_3 = null;
		Object element_5 = null;
		Object element_7 = null;
		Object element_9 = null;
		Object element_11 = null;
		Object element_13 = null;
		theList._header = header;
		theList._maxsize = size;
		header._element = element;
		header._next = next;
		next._element = element_1;
		next._next = next_2;
		next_2._element = element_3;
		next_2._next = next_4;
		next_4._element = element_5;
		next_4._next = next_6;
		next_6._element = element_7;
		next_6._next = next_8;
		next_8._element = element_9;
		next_8._next = next_10;
		next_10._element = element_11;
		next_10._next = next_12;
		next_12._element = element_13;
		next_12._next = next_14;
		obj.printList(theList);
	}

}
