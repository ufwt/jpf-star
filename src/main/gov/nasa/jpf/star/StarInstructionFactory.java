package gov.nasa.jpf.star;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.star.bytecode.ALOAD;
import gov.nasa.jpf.star.bytecode.ASTORE;
import gov.nasa.jpf.star.bytecode.GETFIELD;
import gov.nasa.jpf.star.bytecode.IFNONNULL;
import gov.nasa.jpf.star.bytecode.IFNULL;
import gov.nasa.jpf.star.bytecode.IF_ACMPEQ;
import gov.nasa.jpf.star.bytecode.IF_ACMPNE;
import gov.nasa.jpf.star.bytecode.INVOKEVIRTUAL;
import gov.nasa.jpf.vm.Instruction;

// to perform symbolic execution, StarInstructionFactory should extend SymbolicInstructionFactory
// because some instructions from SymbolicInstructionFactory perform initial set up for
// symbolic execution
public class StarInstructionFactory extends gov.nasa.jpf.symbc.SymbolicInstructionFactory {

	public StarInstructionFactory(Config conf) {
		super(conf);
	}

	@Override
	public Instruction aload(int localVarIndex) {
		return new ALOAD(localVarIndex);
	}
	
	@Override
	public Instruction astore(int localVarIndex) {
		return new ASTORE(localVarIndex);
	}

	@Override
	public Instruction ifnonnull(int targetPc) {
		return new IFNONNULL(targetPc);
	}

	@Override
	public Instruction ifnull(int targetPc) {
		return new IFNULL(targetPc);
	}

	@Override
	public Instruction if_acmpeq(int targetPc) {
		return new IF_ACMPEQ(targetPc);
	}

	@Override
	public Instruction if_acmpne(int targetPc) {
		return new IF_ACMPNE(targetPc);
	}

	@Override
	public Instruction invokevirtual(String clsName, String methodName, String methodSignature) {
		return new INVOKEVIRTUAL(clsName, methodName, methodSignature);
	}

	@Override
	public Instruction getfield(String fieldName, String clsName, String fieldDescriptor) {
		return new GETFIELD(fieldName, clsName, fieldDescriptor);
	}

}
