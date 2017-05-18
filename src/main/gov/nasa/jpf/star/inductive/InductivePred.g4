grammar InductivePred;

@header {
package gov.nasa.jpf.star.inductive;

import gov.nasa.jpf.star.formula.*;
import gov.nasa.jpf.star.formula.heap.*;
import gov.nasa.jpf.star.formula.pure.*;
}

// parser
pred returns [InductivePred ip]: PRED ID LB params RB EQEQ formulas
	{
		Variable[] ps = $params.vars;
		Formula[] fs = $formulas.fs;
		
		$ip = new InductivePred($ID.text, ps, fs);
	}
;

params returns [Variable[] vars] :
	param
	{
		$vars = new Variable[1];
		$vars[0] = $param.var;
	}
	| param CM params
	{
		int length = $params.vars.length + 1;
		$vars = new Variable[length];
		
		for (int i = 0; i < length; i++) {
			if (i == 0) $vars[i] = $param.var;
			else $vars[i] = $params.vars[i - 1];
		}
	}
;

param returns [Variable var] : ID 
	{
		$var = new Variable($ID.text, "");
	}
;

formulas returns [Formula[] fs] :
	formula
	{
		$fs = new Formula[1];
		$fs[0] = $formula.f;
	}
	| formula OR formulas
	{
		int length = $formulas.fs.length + 1;
		$fs = new Formula[length];
		
		for (int i = 0; i < length; i++) {
			if (i == 0) $fs[i] = $formula.f;
			else $fs[i] = $formulas.fs[i - 1];
		}
	}
;

formula returns [Formula f] :
	heapTerms
	{
		HeapFormula hFormula = $heapTerms.hFormula;
		PureFormula pFormula = new PureFormula();
		$f = new Formula(hFormula, pFormula);
	}
	| pureTerms
	{
		HeapFormula hFormula = new HeapFormula();
		PureFormula pFormula = $pureTerms.pFormula;
		$f = new Formula(hFormula, pFormula);
	}
	| heapTerms AND pureTerms
	{
		HeapFormula hFormula = $heapTerms.hFormula;
		PureFormula pFormula = $pureTerms.pFormula;
		$f = new Formula(hFormula, pFormula);
	}
;

heapTerms returns [HeapFormula hFormula] :
	heapTerm
	{
		$hFormula = new HeapFormula($heapTerm.term);
	}
	| heapTerm STAR heapTerms
	{
		HeapFormula oldHeapFormula = $heapTerms.hFormula;
		HeapTerm[] oldHeapTerms = oldHeapFormula.getHeapTerms();
		
		int length = oldHeapTerms.length + 1;
		HeapTerm[] newHeapTerms = new HeapTerm[length];
		
		for (int i = 0; i < length; i++) {
			if (i == 0) newHeapTerms[i] = $heapTerm.term;
			else newHeapTerms[i] = oldHeapTerms[i - 1];
		}
		
		$hFormula = new HeapFormula(newHeapTerms);
	}
;

heapTerm returns [HeapTerm term] :
	pointToTerm
	{
		$term = $pointToTerm.term;
	}
	| inductiveTerm
	{
		$term = $inductiveTerm.term;
	}
;

pointToTerm returns [HeapTerm term] : root=ID PT type=ID LB params RB
	{
		int length = $params.vars.length + 1;
		
		Variable[] vars = new Variable[length];
		for (int i = 0; i < length; i++) {
			if (i == 0) vars[i] = new Variable($root.text, "");
			else vars[i] = $params.vars[i - 1];
		}
		
		$term = new PointToTerm($type.text, vars);
	}
;

inductiveTerm returns [HeapTerm term] : ID LB params RB 
	{
		$term = new InductiveTerm($ID.text, $params.vars);
	}
;

pureTerms returns [PureFormula pFormula]:
	pureTerm 
	{
		$pFormula = new PureFormula($pureTerm.term);
	}
	| pureTerm AND pureTerms
	{
		PureFormula oldPureFormula = $pureTerms.pFormula;
		PureTerm[] oldPureTerms = oldPureFormula.getPureTerms();
		
		int length = oldPureTerms.length + 1;
		PureTerm[] newPureTerms = new PureTerm[length];
		
		for (int i = 0; i < length; i++) {
			if (i == 0) newPureTerms[i] = $pureTerm.term;
			else newPureTerms[i] = oldPureTerms[i - 1];
		}
		
		$pFormula = new PureFormula(newPureTerms);
	}
;

pureTerm returns [PureTerm term]: 
	eqNullTerm
	{
		$term = $eqNullTerm.term;
	}
	| neNullTerm
	{
		$term = $neNullTerm.term;
	}
	| eqTerm
	{
		$term = $eqTerm.term;
	}
	| neTerm
	{
		$term = $neTerm.term;
	}
;

eqNullTerm returns [PureTerm term] : ID EQ NULL
	{
		Variable var = new Variable($ID.text, "");
		
		$term = new EqNullTerm(var);
	}
;

neNullTerm returns [PureTerm term] : ID NE NULL
	{
		Variable var = new Variable($ID.text, "");
		
		$term = new NEqNullTerm(var);
	}
;

eqTerm returns [PureTerm term] : var1=ID EQ var2=ID
	{
		Variable var1 = new Variable($var1.text, "");
		Variable var2 = new Variable($var2.text, "");
		
		$term = new EqTerm(var1, var2);
	}
;

neTerm returns [PureTerm term] : var1=ID NE var2=ID
	{
		Variable var1 = new Variable($var1.text, "");
		Variable var2 = new Variable($var2.text, "");
		
		$term = new NEqTerm(var1, var2);
	}
;

// lexer
PRED    : 'pred' ;
NULL    : 'null' ;
EQEQ    : '==' ;
EQ      : '=' ;
NE      : '!=' ;
LB      : '(' ;
RB      : ')' ;
CM      : ',' ;
OR      : '||' ;
AND     : '&' ;
PT      : '->' ;
STAR    : '*' ;
ID      : [a-zA-Z]+ ;
WS      : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

// tests
// pred sll(x) == x = null || x->Node(next) * sll(next)