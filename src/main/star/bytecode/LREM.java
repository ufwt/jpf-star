package star.bytecode;

import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.expression.BinaryExpression;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.Operator;

public class LREM extends gov.nasa.jpf.jvm.bytecode.LREM {

	@Override
	public Instruction execute(ThreadInfo ti) {
		StackFrame sf = ti.getModifiableTopFrame();

		Expression sym_v1 = (Expression) sf.getOperandAttr(3);
		Expression sym_v2 = (Expression) sf.getOperandAttr(1);

		if (sym_v1 == null && sym_v2 == null)
			return super.execute(ti);// we'll still do the concrete execution
		else {
			long v2 = sf.popLong();
			long v1 = sf.popLong();
			
			if (v2 == 0) {
				return ti.createAndThrowException("java.lang.ArithmeticException",
				                                        "division by zero");
			}
			
			sf.pushLong(v1 % v2); // support concolic
			
			Expression result = null;
			
			if (sym_v1 != null) {
				if (sym_v2 != null) {
					result = new BinaryExpression(Operator.REM, sym_v1, sym_v2);
				} else {
					result = new BinaryExpression(Operator.REM, sym_v1, new LiteralExpression(v2));
				}
			} else {
				result = new BinaryExpression(Operator.REM, new LiteralExpression(v1), sym_v2);
			}
			
			sf.setLongOperandAttr(result);

			return getNext(ti);
		}
	}

}
