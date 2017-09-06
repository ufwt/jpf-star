package linkedlist;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import gov.nasa.jpf.util.test.TestJPF;
import star.data.DataNode;
import star.data.DataNodeLexer;
import star.data.DataNodeMap;
import star.data.DataNodeParser;
import star.precondition.Precondition;
import star.precondition.PreconditionLexer;
import star.precondition.PreconditionMap;
import star.precondition.PreconditionParser;
import star.predicate.InductivePred;
import star.predicate.InductivePredLexer;
import star.predicate.InductivePredMap;
import star.predicate.InductivePredParser;

@SuppressWarnings("deprecation")
public class MyLinkedList_printListTest extends TestJPF {
	
	private void initDataNode() {
		String data = "data MyLinkedList{MyListNode _header; int _maxsize}; data MyListNode {Object _element; MyListNode _next}; data Object {}";
		
		ANTLRInputStream in = new ANTLRInputStream(data);
		DataNodeLexer lexer = new DataNodeLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DataNodeParser parser = new DataNodeParser(tokens);
		
        DataNode[] dns = parser.datas().dns;
        DataNodeMap.put(dns);
	}
	
	private void initPredicate() {
		String pred = "pred sll(root) == root = null || root::MyListNode<element,next> * element::Object<> * sll(next)";
		
		ANTLRInputStream in = new ANTLRInputStream(pred);
		InductivePredLexer lexer = new InductivePredLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InductivePredParser parser = new InductivePredParser(tokens);
        
        InductivePred[] ips = parser.preds().ips;
        InductivePredMap.put(ips);
	}
	
	private void initPrecondition() {
		String pre = "pre printList == this__header::MyListNode<element,nextH> * theList::MyLinkedList<header,size> * header::MyListNode<element,next> * sll(next) & nextH=null";
		
		ANTLRInputStream in = new ANTLRInputStream(pre);
		PreconditionLexer lexer = new PreconditionLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PreconditionParser parser = new PreconditionParser(tokens);
        
        Precondition[] ps = parser.pres().ps;
        PreconditionMap.put(ps);
	}
	
	@Before
	public void init() {
		initDataNode();
		initPredicate();
		initPrecondition();
	}
	
	@Test
	public void testMain() {
		long begin = System.currentTimeMillis();
		
		if (verifyNoPropertyViolation(
				"+listener=star.StarListener",
				"+star.max_depth=2",
//				"+star.min_int=-100",
//				"+star.max_int=100",
				"+star.test_path=build/tmp/linkedlist",
				"+star.test_package=star.examples.linkedlist",
				"+star.test_imports=star.examples.Utilities",
				"+classpath=build/examples", 
				"+sourcepath=src/examples",
				"+symbolic.method=linkedlist.MyLinkedList.printList(sym)",
				"+symbolic.fields=instance",
				"+symbolic.lazy=true")) {
			MyLinkedList list = new MyLinkedList();
			MyLinkedList theList = new MyLinkedList();
			try {
				list.printList(theList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}

}