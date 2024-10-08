// Generated from c:/Users/jsanc/OneDrive/�rea de Trabalho/compiler_project-master/Lang.g4 by ANTLR 4.13.1

	import br.edu.ufabc.isilanguage.datastructure.IsiSymbol;
	import br.edu.ufabc.isilanguage.datastructure.IsiVariable;
	import.br.edu.ufabc.isilanguage.datastructure.IsiSymbolTable;
	import.edu.ufabc.isilanguage.exception.IsiSemanticException;
	import br.edu.ufabc.isilanguage.compiler.ast.IsiProgram;
	import br.edu.ufabc.isilanguage.compiler.ast.AbstractCommand;
	import br.edu.ufabc.isilanguage.compiler.ast.CommandEnquanto;
	import br.edu.ufabc.isilanguage.compiler.ast.CommandLeitura;
	import br.edu.ufabc.isilanguage.compiler.ast.CommandEscrita;
	import br.edu.ufabc.isilanguage.compiler.ast.CommandAtribuicao;
	import br.edu.ufabc.isilanguage.compiler.ast.CommandDecisao;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, AP=13, FP=14, SC=15, OP=16, ATTR=17, VIR=18, 
		ACH=19, FCH=20, OPREL=21, BOOLEAN=22, OPFUNCAOMAT=23, ID=24, NUMBER=25, 
		TEXTO=26, WS=27, MLCOMMENT=28, SLCOMMENT=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", 
			"FCH", "OPREL", "BOOLEAN", "OPFUNCAOMAT", "ID", "NUMBER", "TEXTO", "WS", 
			"MLCOMMENT", "SLCOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'caractere'", 
			"'logico'", "'read'", "'write'", "'enquanto'", "'faca'", "'se'", "'senao'", 
			"'('", "')'", "';'", null, "'='", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "BOOLEAN", 
			"OPFUNCAOMAT", "ID", "NUMBER", "TEXTO", "WS", "MLCOMMENT", "SLCOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


		private int _tipo;
		private String _varName;
		private String _varValue;
		private ArrayList<Integer> _tipoVar = new ArrayList<Integer>();
		private symbolTable symbolTable = new IsiSymbolTable();
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private String _opfunmat;
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _expreDecision;
		private String _expreRepetition;
		private ArrayList<String> variavelSemUso;
		private ArrayList<AbstractCommand> listTrue;
		private ArrayList<AbstractCommand> listFalse; 
		private ArrayList<AbstractCommand> listaEnq;



		public void verificaID(String id){
			if(!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol " +id+ " not declared");
			}
		}

		public String typeToString(int isiType) {
				switch (isiType) {
					case 0:
						return "NUMBER";
					case 1:
						return "TEXT";
					case 2:
						return "CHAR";
					case 3:
						return "BOOLEAN";
					default:
						return "";
				}
			}

		public void verificaCompatibilidade(ArrayList<Integer> tipos) {
				int tipoEsq = tipos.get(0);
				for (int tipo: tipos) {
					if (tipoEsq != tipo) {
						String errorMsg = String.format("Type mismatch: %s and %s", typeToString(tipoEsq), typeToString(tipo));
						tipos.removeAll(tipos);
						throw new IsiSemanticException(errorMsg);
					}
				}
				tipos.removeAll(tipos);
			}

		public void verificaAttrib(String id) {
			if (symbolTable.exists(id) && symbolTable.get(id) == null)
					throw new IsiSemanticException(String.format("\"%s\" has not been initialized.", id));
		}

		public void checkInitialized(String id) {
			if(!symbolTable.checkInitialized(id))
				throw new IsiSemanticException("Symbol "+id+" not initialized");
		}

		public void setInitialized(String id) {
			symbolTable.setInitializedBy(id);
		}

		public void exibeComandos(){
			for(AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}

		public StringBuilder exibeVariavelSemUso(){
			StringBuilder varWarning = program.getVarSemUso();
			ArrayList<String> var = program.getVarSemUso();
			varWarning.append("Variables declared but not used: ");
			if(var.isEmpty()) return null;

			int size = var.size();
			if(size == 1){
				varWarning.append(var.get(0));
			}
			else{
				for(int i = 0; i < size-2; i++){
					String v = var.get(i);
					varWarning.append(v);
					varWarning.append(", ");
				}
				varWarning.append(var.get(size-1));
				}
			return varWarning;
		}

		public void Warning(){
			StringBuilder warning = new StringBuilder();
			StringBuilder var = exibeVariavelSemUso();
			if(var != null) return;
			warning.append(exibeVariavelSemUso());
			System.out.println(warning);
			
		}

		public String generateCode(){
				return program.generateTarget();
			}

		public ArrayList<String> getWarnings() {
				ArrayList<String> warnings = new ArrayList<String>();
				for(IsiSymbol s: symbolTable.getNotUsedSymbols())
					warnings.add(String.format("Warning: Variavel <%s> foi declarada, mas nao utilizada", s.getName()));
				return warnings;
			}


	public LangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001d\u0104\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u00a7\b\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u00b2\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u00c9\b\u0016\u0001\u0017\u0001\u0017\u0005\u0017\u00cd\b\u0017"+
		"\n\u0017\f\u0017\u00d0\t\u0017\u0001\u0018\u0004\u0018\u00d3\b\u0018\u000b"+
		"\u0018\f\u0018\u00d4\u0001\u0018\u0001\u0018\u0004\u0018\u00d9\b\u0018"+
		"\u000b\u0018\f\u0018\u00da\u0003\u0018\u00dd\b\u0018\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u00e1\b\u0019\n\u0019\f\u0019\u00e4\t\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u00f0\b\u001b\n\u001b"+
		"\f\u001b\u00f3\t\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c"+
		"\u00fe\b\u001c\n\u001c\f\u001c\u0101\t\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u00f1\u0000\u001d\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d\u0001\u0000\t"+
		"\u0003\u0000*+--//\u0002\u0000<<>>\u0001\u0000az\u0003\u000009AZaz\u0001"+
		"\u000009\u0002\u0000\"\"\'\'\u0004\u0000  09AZaz\u0003\u0000\t\n\r\r "+
		" \u0002\u0000\n\n\r\r\u0111\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;"+
		"\u0001\u0000\u0000\u0000\u0003D\u0001\u0000\u0000\u0000\u0005M\u0001\u0000"+
		"\u0000\u0000\u0007T\u0001\u0000\u0000\u0000\tZ\u0001\u0000\u0000\u0000"+
		"\u000bd\u0001\u0000\u0000\u0000\rk\u0001\u0000\u0000\u0000\u000fp\u0001"+
		"\u0000\u0000\u0000\u0011v\u0001\u0000\u0000\u0000\u0013\u007f\u0001\u0000"+
		"\u0000\u0000\u0015\u0084\u0001\u0000\u0000\u0000\u0017\u0087\u0001\u0000"+
		"\u0000\u0000\u0019\u008d\u0001\u0000\u0000\u0000\u001b\u008f\u0001\u0000"+
		"\u0000\u0000\u001d\u0091\u0001\u0000\u0000\u0000\u001f\u0093\u0001\u0000"+
		"\u0000\u0000!\u0095\u0001\u0000\u0000\u0000#\u0097\u0001\u0000\u0000\u0000"+
		"%\u0099\u0001\u0000\u0000\u0000\'\u009b\u0001\u0000\u0000\u0000)\u00a6"+
		"\u0001\u0000\u0000\u0000+\u00b1\u0001\u0000\u0000\u0000-\u00c8\u0001\u0000"+
		"\u0000\u0000/\u00ca\u0001\u0000\u0000\u00001\u00d2\u0001\u0000\u0000\u0000"+
		"3\u00de\u0001\u0000\u0000\u00005\u00e7\u0001\u0000\u0000\u00007\u00eb"+
		"\u0001\u0000\u0000\u00009\u00f9\u0001\u0000\u0000\u0000;<\u0005p\u0000"+
		"\u0000<=\u0005r\u0000\u0000=>\u0005o\u0000\u0000>?\u0005g\u0000\u0000"+
		"?@\u0005r\u0000\u0000@A\u0005a\u0000\u0000AB\u0005m\u0000\u0000BC\u0005"+
		"a\u0000\u0000C\u0002\u0001\u0000\u0000\u0000DE\u0005f\u0000\u0000EF\u0005"+
		"i\u0000\u0000FG\u0005m\u0000\u0000GH\u0005p\u0000\u0000HI\u0005r\u0000"+
		"\u0000IJ\u0005o\u0000\u0000JK\u0005g\u0000\u0000KL\u0005;\u0000\u0000"+
		"L\u0004\u0001\u0000\u0000\u0000MN\u0005n\u0000\u0000NO\u0005u\u0000\u0000"+
		"OP\u0005m\u0000\u0000PQ\u0005e\u0000\u0000QR\u0005r\u0000\u0000RS\u0005"+
		"o\u0000\u0000S\u0006\u0001\u0000\u0000\u0000TU\u0005t\u0000\u0000UV\u0005"+
		"e\u0000\u0000VW\u0005x\u0000\u0000WX\u0005t\u0000\u0000XY\u0005o\u0000"+
		"\u0000Y\b\u0001\u0000\u0000\u0000Z[\u0005c\u0000\u0000[\\\u0005a\u0000"+
		"\u0000\\]\u0005r\u0000\u0000]^\u0005a\u0000\u0000^_\u0005c\u0000\u0000"+
		"_`\u0005t\u0000\u0000`a\u0005e\u0000\u0000ab\u0005r\u0000\u0000bc\u0005"+
		"e\u0000\u0000c\n\u0001\u0000\u0000\u0000de\u0005l\u0000\u0000ef\u0005"+
		"o\u0000\u0000fg\u0005g\u0000\u0000gh\u0005i\u0000\u0000hi\u0005c\u0000"+
		"\u0000ij\u0005o\u0000\u0000j\f\u0001\u0000\u0000\u0000kl\u0005r\u0000"+
		"\u0000lm\u0005e\u0000\u0000mn\u0005a\u0000\u0000no\u0005d\u0000\u0000"+
		"o\u000e\u0001\u0000\u0000\u0000pq\u0005w\u0000\u0000qr\u0005r\u0000\u0000"+
		"rs\u0005i\u0000\u0000st\u0005t\u0000\u0000tu\u0005e\u0000\u0000u\u0010"+
		"\u0001\u0000\u0000\u0000vw\u0005e\u0000\u0000wx\u0005n\u0000\u0000xy\u0005"+
		"q\u0000\u0000yz\u0005u\u0000\u0000z{\u0005a\u0000\u0000{|\u0005n\u0000"+
		"\u0000|}\u0005t\u0000\u0000}~\u0005o\u0000\u0000~\u0012\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0005f\u0000\u0000\u0080\u0081\u0005a\u0000\u0000\u0081"+
		"\u0082\u0005c\u0000\u0000\u0082\u0083\u0005a\u0000\u0000\u0083\u0014\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005s\u0000\u0000\u0085\u0086\u0005e\u0000"+
		"\u0000\u0086\u0016\u0001\u0000\u0000\u0000\u0087\u0088\u0005s\u0000\u0000"+
		"\u0088\u0089\u0005e\u0000\u0000\u0089\u008a\u0005n\u0000\u0000\u008a\u008b"+
		"\u0005a\u0000\u0000\u008b\u008c\u0005o\u0000\u0000\u008c\u0018\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005(\u0000\u0000\u008e\u001a\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005)\u0000\u0000\u0090\u001c\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005;\u0000\u0000\u0092\u001e\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0007\u0000\u0000\u0000\u0094 \u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005=\u0000\u0000\u0096\"\u0001\u0000\u0000\u0000\u0097\u0098\u0005"+
		",\u0000\u0000\u0098$\u0001\u0000\u0000\u0000\u0099\u009a\u0005{\u0000"+
		"\u0000\u009a&\u0001\u0000\u0000\u0000\u009b\u009c\u0005}\u0000\u0000\u009c"+
		"(\u0001\u0000\u0000\u0000\u009d\u009e\u0005=\u0000\u0000\u009e\u00a7\u0005"+
		"=\u0000\u0000\u009f\u00a0\u0005!\u0000\u0000\u00a0\u00a7\u0005=\u0000"+
		"\u0000\u00a1\u00a2\u0005>\u0000\u0000\u00a2\u00a7\u0005=\u0000\u0000\u00a3"+
		"\u00a4\u0005<\u0000\u0000\u00a4\u00a7\u0005=\u0000\u0000\u00a5\u00a7\u0007"+
		"\u0001\u0000\u0000\u00a6\u009d\u0001\u0000\u0000\u0000\u00a6\u009f\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a1\u0001\u0000\u0000\u0000\u00a6\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7*\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0005t\u0000\u0000\u00a9\u00aa\u0005r\u0000\u0000"+
		"\u00aa\u00ab\u0005u\u0000\u0000\u00ab\u00b2\u0005e\u0000\u0000\u00ac\u00ad"+
		"\u0005f\u0000\u0000\u00ad\u00ae\u0005a\u0000\u0000\u00ae\u00af\u0005l"+
		"\u0000\u0000\u00af\u00b0\u0005s\u0000\u0000\u00b0\u00b2\u0005e\u0000\u0000"+
		"\u00b1\u00a8\u0001\u0000\u0000\u0000\u00b1\u00ac\u0001\u0000\u0000\u0000"+
		"\u00b2,\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005p\u0000\u0000\u00b4\u00b5"+
		"\u0005o\u0000\u0000\u00b5\u00b6\u0005t\u0000\u0000\u00b6\u00b7\u0005e"+
		"\u0000\u0000\u00b7\u00b8\u0005n\u0000\u0000\u00b8\u00b9\u0005c\u0000\u0000"+
		"\u00b9\u00ba\u0005i\u0000\u0000\u00ba\u00c9\u0005a\u0000\u0000\u00bb\u00bc"+
		"\u0005l\u0000\u0000\u00bc\u00bd\u0005o\u0000\u0000\u00bd\u00be\u0005g"+
		"\u0000\u0000\u00be\u00bf\u0005a\u0000\u0000\u00bf\u00c0\u0005r\u0000\u0000"+
		"\u00c0\u00c1\u0005i\u0000\u0000\u00c1\u00c2\u0005t\u0000\u0000\u00c2\u00c3"+
		"\u0005m\u0000\u0000\u00c3\u00c9\u0005o\u0000\u0000\u00c4\u00c5\u0005r"+
		"\u0000\u0000\u00c5\u00c6\u0005a\u0000\u0000\u00c6\u00c7\u0005i\u0000\u0000"+
		"\u00c7\u00c9\u0005z\u0000\u0000\u00c8\u00b3\u0001\u0000\u0000\u0000\u00c8"+
		"\u00bb\u0001\u0000\u0000\u0000\u00c8\u00c4\u0001\u0000\u0000\u0000\u00c9"+
		".\u0001\u0000\u0000\u0000\u00ca\u00ce\u0007\u0002\u0000\u0000\u00cb\u00cd"+
		"\u0007\u0003\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cf0\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d3\u0007\u0004\u0000\u0000\u00d2\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00dc\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d8\u0005.\u0000\u0000\u00d7\u00d9\u0007\u0004"+
		"\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000"+
		"\u0000\u0000\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00d6\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd2\u0001\u0000\u0000"+
		"\u0000\u00de\u00e2\u0007\u0005\u0000\u0000\u00df\u00e1\u0007\u0006\u0000"+
		"\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e5\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0007\u0005\u0000\u0000\u00e64\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e8\u0007\u0007\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0006\u001a\u0000\u0000\u00ea6\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ec\u0005/\u0000\u0000\u00ec\u00ed\u0005*\u0000\u0000\u00ed\u00f1\u0001"+
		"\u0000\u0000\u0000\u00ee\u00f0\t\u0000\u0000\u0000\u00ef\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005*\u0000"+
		"\u0000\u00f5\u00f6\u0005/\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0006\u001b\u0000\u0000\u00f88\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0005/\u0000\u0000\u00fa\u00fb\u0005/\u0000\u0000\u00fb\u00ff\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fe\b\b\u0000\u0000\u00fd\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0102\u0001\u0000"+
		"\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0103\u0006\u001c"+
		"\u0000\u0000\u0103:\u0001\u0000\u0000\u0000\r\u0000\u00a6\u00b1\u00c8"+
		"\u00cc\u00ce\u00d4\u00da\u00dc\u00e0\u00e2\u00f1\u00ff\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}