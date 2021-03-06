package random.sll;

import common.Utilities;
import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;

public class Input_withAtan1 extends TestJPF {

	@Test
	public void test_withAtan1() throws Exception {
		Input obj = new Input();
		Node root = new Node();
		Node next_20 = null;
		int elem_19 = 0;
		root.elem = elem_19;
		root.next = next_20;
		obj.withAtan(root);
	}

	@Test
	public void test_withAtan2() throws Exception {
		Input obj = new Input();
		random.sll.Node root = null;
		obj.withAtan(root);
	}

}

