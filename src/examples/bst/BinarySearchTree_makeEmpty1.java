package bst;

import org.junit.Test;

import basic.Utilities;
import gov.nasa.jpf.util.test.TestJPF;

public class BinarySearchTree_makeEmpty1 extends TestJPF {

	@Test
	public void test_makeEmpty1() throws Exception {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = null;
		System.out.println(Utilities.repOK(obj));
		obj.makeEmpty();
	}

}
