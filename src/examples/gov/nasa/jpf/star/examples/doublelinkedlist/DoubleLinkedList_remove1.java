package gov.nasa.jpf.star.examples.doublelinkedlist;

import gov.nasa.jpf.star.examples.doublelinkedlist.DoubleLinkedList.Entry;
import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;

public class DoubleLinkedList_remove1 extends TestJPF {

	@Test
	public void test1() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new Entry();
		Object o = null;
		Entry this_header_112 = obj.header;
		obj.size = 0;
		obj.modCount = 0;
		Object ele_1 = null;
		obj.header.element = ele_1;
		obj.header.next = obj.header;
		obj.header.previous = this_header_112;
		obj.remove(o);
	}

	@Test
	public void test2() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new Entry();
		Entry next_2 = new Entry();
		Object o = null;
		Entry prev_3 = next_2;
		Object ele_4 = null;
		Entry this_header_112 = obj.header;
		obj.size = 1;
		obj.modCount = 0;
		Object ele_1 = null;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		next_2.element = ele_4;
		next_2.next = obj.header;
		next_2.previous = this_header_112;
		obj.remove(o);
	}

	@Test
	public void test3() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new Entry();
		Entry next_2 = new Entry();
		Object o = null;
		Entry prev_3 = next_2;
		Object ele_4 = new Object();
		Entry this_header_112 = obj.header;
		obj.size = 1;
		obj.modCount = 0;
		Object ele_1 = null;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		next_2.element = ele_4;
		next_2.next = obj.header;
		next_2.previous = this_header_112;
		obj.remove(o);
	}

	@Test
	public void test4() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new Entry();
		Object o = new Object();
		Entry this_header_112 = obj.header;
		obj.size = 0;
		obj.modCount = 0;
		Object ele_1 = null;
		obj.header.element = ele_1;
		obj.header.next = obj.header;
		obj.header.previous = this_header_112;
		obj.remove(o);
	}

	@Test
	public void test5() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new Entry();
		Entry next_2 = new Entry();
		Object o = new Object();
		Entry prev_3 = next_2;
		Object ele_4 = o;
		Entry this_header_112 = obj.header;
		obj.size = 1;
		obj.modCount = 0;
		Object ele_1 = null;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		next_2.element = ele_4;
		next_2.next = obj.header;
		next_2.previous = this_header_112;
		obj.remove(o);
	}

	@Test
	public void test6() throws Exception {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.header = new Entry();
		Entry next_2 = new Entry();
		Object o = new Object();
		Entry prev_3 = next_2;
		Entry this_header_112 = obj.header;
		obj.size = 1;
		obj.modCount = 0;
		Object ele_1 = null;
		Object ele_4 = null;
		obj.header.element = ele_1;
		obj.header.next = next_2;
		obj.header.previous = prev_3;
		next_2.element = ele_4;
		next_2.next = obj.header;
		next_2.previous = this_header_112;
		obj.remove(o);
	}

}
