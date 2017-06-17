package gov.nasa.jpf.star.bytecode;

import gov.nasa.jpf.star.formula.Variable;
import gov.nasa.jpf.star.formula.expression.Expression;
import gov.nasa.jpf.star.formula.expression.VariableExpression;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;

public class LLOAD extends gov.nasa.jpf.jvm.bytecode.LLOAD {

	public LLOAD(int localVarIndex) {
		super(localVarIndex);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		StackFrame sf = ti.getModifiableTopFrame();
		Object sym_v = sf.getLongLocalAttr(index);
		
		if(sym_v != null) {
			Expression exp = new VariableExpression(new Variable(sym_v.toString(), ""));
			sf.setLongLocalAttr(index, exp);
		}
		
		return super.execute(ti);
	}

}
