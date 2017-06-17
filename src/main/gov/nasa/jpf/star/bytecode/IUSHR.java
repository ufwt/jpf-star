package gov.nasa.jpf.star.bytecode;

import gov.nasa.jpf.star.formula.expression.IntegerBinaryExpression;
import gov.nasa.jpf.star.formula.expression.IntegerExpression;
import gov.nasa.jpf.star.formula.expression.IntegerLiteral;
import gov.nasa.jpf.symbc.numeric.Operator;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;

public class IUSHR extends gov.nasa.jpf.jvm.bytecode.IUSHR {
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		StackFrame sf = ti.getModifiableTopFrame();
		IntegerExpression sym_v1 = (IntegerExpression) sf.getOperandAttr(1);
		IntegerExpression sym_v2 = (IntegerExpression) sf.getOperandAttr(0);
		
		if(sym_v1 == null && sym_v2 == null) {
			return super.execute(ti); // we'll still do the concrete execution
		} else {
			int v2 = sf.pop();
			int v1 = sf.pop();
			sf.push(0, false); // for symbolic expressions, the concrete value does not matter
		
			IntegerExpression result = null;
			
			if(sym_v1 != null) {
				if (sym_v2 != null) {
					result = new IntegerBinaryExpression(Operator.SHIFTUR, sym_v1, sym_v2);
				} else {
					result = new IntegerBinaryExpression(Operator.SHIFTUR, sym_v1, new IntegerLiteral(v2));
				}
			} else {
				result = new IntegerBinaryExpression(Operator.SHIFTUR, new IntegerLiteral(v1), sym_v2);
			}
			
			sf.setOperandAttr(result);
		
			return getNext(ti);
		}
	}

}
