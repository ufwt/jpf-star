package basic;
import org.junit.Test;

import common.Constant;
import starlib.precondition.Initializer;

public class Sll2Test extends TestSll {
	
	@Override
	protected void initPrecondition() {
		String pre = "pre myMethod == sll(x)";
		Initializer.initPrecondition(pre);
	}
	

	@Test
	public void testMain() {
		if (verifyNoPropertyViolation(
				"+listener=star.StarListener",
//				"+star.max_len_pc=6",
//				"+star.min_int=-100",
//				"+star.max_int=100",
//				"+star.lazy=false",
				"+star.test_path=" + Constant.TEST_PATH + "/basic",
				"+star.test_package=basic",
				"+star.test_imports=common.Utilities",
				"+classpath=build/examples", 
				"+sourcepath=src/examples",
				"+symbolic.method=basic.Sll2.myMethod(sym)",
				"+symbolic.lazy=true")) {
			Sll2.main(null);
		}
	}

}
