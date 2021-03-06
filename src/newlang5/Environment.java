package newlang5;

import java.util.Hashtable;

public class Environment {
	LexicalAnalyzer input;
	Hashtable<String, Function> library;
	Hashtable<String, Variable> var_table;

	public Environment(LexicalAnalyzer my_input) {
		input = my_input;
		library = new Hashtable<String, Function>();
		library.put("PRINT", new PrintFunction());
		var_table = new Hashtable<String, Variable>();
	}

	public LexicalAnalyzer getInput() {
		return input;
	}

	public Function getFunction(String fname) {
		return (Function) library.get(fname);
	}

	public Variable getVariable(String vname) {
		Variable v;
		v = (Variable) var_table.get(vname);
		if (v == null) {
			v = new Variable(vname);
			var_table.put(vname, v);
		}
		return v;
	}

}
