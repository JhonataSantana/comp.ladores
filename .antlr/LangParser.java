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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, AP=13, FP=14, SC=15, OP=16, ATTR=17, VIR=18, 
		ACH=19, FCH=20, OPREL=21, BOOLEAN=22, OPFUNCAOMAT=23, ID=24, NUMBER=25, 
		TEXTO=26, WS=27, MLCOMMENT=28, SLCOMMENT=29, CHAR=30, TEXT=31;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdenquanto = 9, RULE_cmdselecao = 10, RULE_expr = 11, RULE_funcaomat = 12, 
		RULE_term = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"cmdattrib", "cmdenquanto", "cmdselecao", "expr", "funcaomat", "term"
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
			"OPFUNCAOMAT", "ID", "NUMBER", "TEXTO", "WS", "MLCOMMENT", "SLCOMMENT", 
			"CHAR", "TEXT"
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

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			decl();
			setState(30);
			bloco();
			setState(31);
			match(T__1);

						program.setVarTable(symbolTable);
						program.setComandos(stack.pop());
						showWarningsUnusedVariables();
					  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declaravar();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 120L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(LangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(LangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(LangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			tipo();
			setState(40);
			match(ID);

						  			_varName = _input.LT(-1).getText();
						  			_varValue = null;
						  			symbol = new IsiVariable(_varName, _tipo, _varValue);
									System.out.println("Simbolo adicionado " +symbol);
									if (!symbolTable.exists(_varName)){
						  				symbolTable.add(symbol);
									}
									else{
										throw new IsiSemanticException("Symbol" +_varName+" already declared");
									}
									
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(42);
				match(VIR);
				setState(43);
				match(ID);

										_varName = _LT(-1).getText();
							  			_varValue = null;
							  			symbol = new IsiVariable(_varName, _tipo, _varValue);
										if (!symbolTable.exists(_varName)){
							  				symbolTable.add(symbol);
										}
										else{
											throw new IsiSemanticException("Symbol" +_varName+" already declared");
										}
									
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__2);
				 _tipo = IsiVariable.Number; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__3);
				 _tipo = IsiVariable.TEXT; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(T__4);
				 _tipo = IsiVariable.CHAR;  
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				match(T__5);
				 _tipo = IsiVariable.BOOLEAN;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			curThread = new ArrayList<AbstractCommand>();
							stack.push(curThread);
					  
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				cmd();
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 16780160L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdenquantoContext cmdenquanto() {
			return getRuleContext(CmdenquantoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				cmdleitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				cmdattrib();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				cmdselecao();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				cmdenquanto();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(LangParser.AP, 0); }
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode FP() { return getToken(LangParser.FP, 0); }
		public TerminalNode SC() { return getToken(LangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__6);
			setState(76);
			match(AP);
			setState(77);
			match(ID);
			 verificaID(_input.LT(-1).getText());
								 	  _readID = _input.LT(-1).getText();
								 
			setState(79);
			match(FP);
			setState(80);
			match(SC);

									IsiVariable var = (IsiVariable)symbolTable.get(_readID);
									CommandLeitura cmd = new CommandLeitura(_readID, var);
									setInitialized(_readID);
									stack.peek().add(cmd);
								 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(LangParser.AP, 0); }
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode FP() { return getToken(LangParser.FP, 0); }
		public TerminalNode SC() { return getToken(LangParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__7);
			setState(84);
			match(AP);
			setState(85);
			match(ID);
			 verificaID(_input.LT(-1).getText());
							 _writeID = _input.LT(-1).getText();
							 checkInitialized(_writeID);
						
			setState(87);
			match(FP);
			setState(88);
			match(SC);

							CommandEscrita cmd = new CommandEscrita(_writeID);
							stack.peek().add(cmd);
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(LangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(LangParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(ID);
			 verificaID(_input.LT(-1).getText());
								verificaAttrib(_input.LT(-1).getText());
								_exprID = _input.LT(-1).getText();
						   
			setState(93);
			match(ATTR);

								_exprContent = "";
						   
			setState(95);
			expr();
			setState(96);
			match(SC);

								if(_exprContent == "")
								{
									throw new IsiSemanticException("Variavel " +_exprID+ " não foi atribuida");
								}
								else{
									COmmandAtribuicao cmd = new COmmandAtribuicao(_expreID, _exprContent);
									stack.peek().add(cmd);
								}
						   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdenquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(LangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(LangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(LangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(LangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(LangParser.FCH, 0); }
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdenquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenquanto; }
	}

	public final CmdenquantoContext cmdenquanto() throws RecognitionException {
		CmdenquantoContext _localctx = new CmdenquantoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdenquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__8);
			setState(100);
			match(AP);
			setState(101);
			match(ID);

								_expreRepetition = _input.LT(-1).getText(); #n sei se deixa assim
									
							
			setState(103);
			match(OPREL);
			_expreRepetition += _input.TL(-1).getText(); 
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_expreRepetition += _input.LT(-1).getText(); 
			setState(107);
			match(FP);
			 verificaCompatibilidade(_tipoVar); 
			setState(109);
			match(T__9);
			setState(110);
			match(ACH);
			curThread = new ArrayList<AbstractCommand>();
								 stack.push(curThread);
								
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				cmd();
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 16780160L) != 0) );
			setState(117);
			match(FCH);
			 listTrue = stack.pop();
								  CommandRepeticao cmd = new CommandRepeticao(_expreRepetition, listTrue);
								  stack.peek().add(cmd);
								
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(LangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(LangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(LangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(LangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(LangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(LangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(LangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__10);
			setState(121);
			match(AP);
			setState(122);
			match(ID);

								verificaID(_input.LT(-1).getText());
								verificaAttrib(_input.LT(-1).getText());
								_expreDecision = _input.LT(-1).getText(); 
								_tipoVar.add(symbolTable.getTypeBy(_input.LT(-1).getText()));
							
			setState(124);
			match(OPREL);
			_expreDecision += _input.LT(-1).getText(); 
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

								verificaAttrib(_input.LT(-1).getText());
								if (_input.LT(-1).getText().matches("\\d+(\\.\\d+)?"))
									_tipoVar.add(IsiVariable.NUMBER);
								else {
									verificaID(_input.LT(-1).getText());
									_tipoVar.add(symbolTable.getTypeBy(_input.LT(-1).getText()));
									}
								_expreDecision += _input.LT(-1).getText(); 
							
			setState(128);
			match(FP);
			 verificaCompatibilidade(_tipoVar); 
			setState(130);
			match(ACH);
			curThread = new ArrayList<AbstractCommand>();
								 stack.push(curThread);
								
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				cmd();
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 16780160L) != 0) );
			setState(137);
			match(FCH);
			 listaTrue = stack.pop();
								
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(139);
				match(T__11);
				setState(140);
				match(ACH);

										curThread = new ArrayList<AbstractCommand>();
									 	stack.push(curThread);
									
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(142);
					cmd();
					}
					}
					setState(145); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 16780160L) != 0) );
				setState(147);
				match(FCH);
				 listFalse = stack.pop();
										  CommandDecisao cmd = new CommandDecisao(_expreDecision, listTrue, listFalse);
										  stack.peek().add(cmd);
										
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<FuncaomatContext> funcaomat() {
			return getRuleContexts(FuncaomatContext.class);
		}
		public FuncaomatContext funcaomat(int i) {
			return getRuleContext(FuncaomatContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(LangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(LangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case ID:
			case NUMBER:
			case CHAR:
			case TEXT:
				{
				setState(152);
				term();
				}
				break;
			case OPFUNCAOMAT:
				{
				setState(153);
				funcaomat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(156);
				match(OP);
				_exprContent += _input.LT(-1).getText();
				setState(160);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN:
				case ID:
				case NUMBER:
				case CHAR:
				case TEXT:
					{
					setState(158);
					term();
					}
					break;
				case OPFUNCAOMAT:
					{
					setState(159);
					funcaomat();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncaomatContext extends ParserRuleContext {
		public TerminalNode OPFUNCAOMAT() { return getToken(LangParser.OPFUNCAOMAT, 0); }
		public TerminalNode AP() { return getToken(LangParser.AP, 0); }
		public TerminalNode VIR() { return getToken(LangParser.VIR, 0); }
		public TerminalNode FP() { return getToken(LangParser.FP, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(LangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(LangParser.NUMBER, i);
		}
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public FuncaomatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcaomat; }
	}

	public final FuncaomatContext funcaomat() throws RecognitionException {
		FuncaomatContext _localctx = new FuncaomatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funcaomat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(OPFUNCAOMAT);

									  _opfunmat = _input.LT(-1).getText();
									  if (_input.LT(-1).getText().equals("logaritmo"))
										_exprContent += String.format("(%s", _input.LT(-1).getText()));
									  else
									  	_exprContent += _input.LT(-1).getText();
									
			setState(169);
			match(AP);

									  _exprContent += _input.LT(-1).getText();
									
			setState(171);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

									  if (_input.LT(-1).getText().matches("\\d+(\\.\\d+)?"))
									  	_tipoVar.add(IsiVariable.NUMBER);
									  else {
									  	verificaID(_input.LT(-1).getText());
										checkInitialized(_input.LT(-1).getText());
				               	   	  	_tipoVar.add(symbolTable.getTypeBy(_input.LT(-1).getText()));
									  }

									  _exprContent += _input.LT(-1).getText();
									
			setState(173);
			match(VIR);

									  if (_opfunmat.equals("logaritmo")) {
										_exprContent += ") / Math.log(";
									  }
									  else
									  	_exprContent += _input.LT(-1).getText();
									
			setState(175);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

									  if (_input.LT(-1).getText().matches("\\d+(\\.\\d+)?"))
									  	_tipoVar.add(IsiVariable.NUMBER);
									  else {
									  	verificaID(_input.LT(-1).getText());
										checkInitialized(_input.LT(-1).getText());
									  	_tipoVar.add(symbolTable.getTypeBy(_input.LT(-1).getText()));
									  }

									  if (_opfunmat.equals("raiz"))
										_exprContent += String.format("1/%s", _input.LT(-1).getText());
									  else
									    _exprContent += _input.LT(-1).getText();
									
			setState(177);
			match(FP);

									  if (_opfunmat.equals("logaritmo"))
									  	_exprContent += _input.LT(-1).getText();
									  _exprContent += _input.LT(-1).getText();
									
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public TerminalNode CHAR() { return getToken(LangParser.CHAR, 0); }
		public TerminalNode TEXT() { return getToken(LangParser.TEXT, 0); }
		public TerminalNode BOOLEAN() { return getToken(LangParser.BOOLEAN, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(ID);

								verificaID(_input.LT(-1).getText());
								checkInitialized(_input.LT(-1).getText());
					            _tipoVar.add(symbolTable.getTypeBy(_input.LT(-1).getText()));
								_exprContent += _input.LT(-1).getText();
							  
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(NUMBER);

									   	_tipoVar.add(IsiVariable.NUMBER);
				              		    _exprContent += _input.LT(-1).getText();
				              		  
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(CHAR);

											_tipoVar.add(IsiVariable.CHAR);
											_exprContent += _input.LT(-1).getText();
										
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				match(TEXT);

											_tipoVar.add(IsiVariable.TEXT);
											_exprContent += _input.LT(-1).getText();
										
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 5);
				{
				setState(188);
				match(BOOLEAN);

											_tipoVar.add(IsiVariable.BOOLEAN);
											_exprContent += _input.LT(-1).getText();
										
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00c1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001$\b\u0001\u000b"+
		"\u0001\f\u0001%\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002.\b\u0002\n\u0002\f\u00021\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003=\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0004\u0004A\b\u0004\u000b\u0004\f\u0004B\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005J\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0004\tr\b\t\u000b\t\f\ts\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0004\n\u0086\b\n\u000b\n\f\n\u0087\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u0090\b\n\u000b\n\f\n\u0091\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u0097\b\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u009b\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00a1\b\u000b\u0005\u000b\u00a3\b\u000b\n\u000b\f\u000b\u00a6\t\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00bf\b\r\u0001\r\u0000"+
		"\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u0000\u0001\u0001\u0000\u0018\u0019\u00c7\u0000\u001c\u0001"+
		"\u0000\u0000\u0000\u0002#\u0001\u0000\u0000\u0000\u0004\'\u0001\u0000"+
		"\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000"+
		"\nI\u0001\u0000\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000eS\u0001\u0000"+
		"\u0000\u0000\u0010[\u0001\u0000\u0000\u0000\u0012c\u0001\u0000\u0000\u0000"+
		"\u0014x\u0001\u0000\u0000\u0000\u0016\u009a\u0001\u0000\u0000\u0000\u0018"+
		"\u00a7\u0001\u0000\u0000\u0000\u001a\u00be\u0001\u0000\u0000\u0000\u001c"+
		"\u001d\u0005\u0001\u0000\u0000\u001d\u001e\u0003\u0002\u0001\u0000\u001e"+
		"\u001f\u0003\b\u0004\u0000\u001f \u0005\u0002\u0000\u0000 !\u0006\u0000"+
		"\uffff\uffff\u0000!\u0001\u0001\u0000\u0000\u0000\"$\u0003\u0004\u0002"+
		"\u0000#\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&\u0003\u0001\u0000\u0000\u0000"+
		"\'(\u0003\u0006\u0003\u0000()\u0005\u0018\u0000\u0000)/\u0006\u0002\uffff"+
		"\uffff\u0000*+\u0005\u0012\u0000\u0000+,\u0005\u0018\u0000\u0000,.\u0006"+
		"\u0002\uffff\uffff\u0000-*\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000023\u0005\u000f\u0000\u00003\u0005"+
		"\u0001\u0000\u0000\u000045\u0005\u0003\u0000\u00005=\u0006\u0003\uffff"+
		"\uffff\u000067\u0005\u0004\u0000\u00007=\u0006\u0003\uffff\uffff\u0000"+
		"89\u0005\u0005\u0000\u00009=\u0006\u0003\uffff\uffff\u0000:;\u0005\u0006"+
		"\u0000\u0000;=\u0006\u0003\uffff\uffff\u0000<4\u0001\u0000\u0000\u0000"+
		"<6\u0001\u0000\u0000\u0000<8\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000=\u0007\u0001\u0000\u0000\u0000>@\u0006\u0004\uffff\uffff\u0000"+
		"?A\u0003\n\u0005\u0000@?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000C\t\u0001\u0000\u0000"+
		"\u0000DJ\u0003\f\u0006\u0000EJ\u0003\u000e\u0007\u0000FJ\u0003\u0010\b"+
		"\u0000GJ\u0003\u0014\n\u0000HJ\u0003\u0012\t\u0000ID\u0001\u0000\u0000"+
		"\u0000IE\u0001\u0000\u0000\u0000IF\u0001\u0000\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000J\u000b\u0001\u0000\u0000\u0000"+
		"KL\u0005\u0007\u0000\u0000LM\u0005\r\u0000\u0000MN\u0005\u0018\u0000\u0000"+
		"NO\u0006\u0006\uffff\uffff\u0000OP\u0005\u000e\u0000\u0000PQ\u0005\u000f"+
		"\u0000\u0000QR\u0006\u0006\uffff\uffff\u0000R\r\u0001\u0000\u0000\u0000"+
		"ST\u0005\b\u0000\u0000TU\u0005\r\u0000\u0000UV\u0005\u0018\u0000\u0000"+
		"VW\u0006\u0007\uffff\uffff\u0000WX\u0005\u000e\u0000\u0000XY\u0005\u000f"+
		"\u0000\u0000YZ\u0006\u0007\uffff\uffff\u0000Z\u000f\u0001\u0000\u0000"+
		"\u0000[\\\u0005\u0018\u0000\u0000\\]\u0006\b\uffff\uffff\u0000]^\u0005"+
		"\u0011\u0000\u0000^_\u0006\b\uffff\uffff\u0000_`\u0003\u0016\u000b\u0000"+
		"`a\u0005\u000f\u0000\u0000ab\u0006\b\uffff\uffff\u0000b\u0011\u0001\u0000"+
		"\u0000\u0000cd\u0005\t\u0000\u0000de\u0005\r\u0000\u0000ef\u0005\u0018"+
		"\u0000\u0000fg\u0006\t\uffff\uffff\u0000gh\u0005\u0015\u0000\u0000hi\u0006"+
		"\t\uffff\uffff\u0000ij\u0007\u0000\u0000\u0000jk\u0006\t\uffff\uffff\u0000"+
		"kl\u0005\u000e\u0000\u0000lm\u0006\t\uffff\uffff\u0000mn\u0005\n\u0000"+
		"\u0000no\u0005\u0013\u0000\u0000oq\u0006\t\uffff\uffff\u0000pr\u0003\n"+
		"\u0005\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"uv\u0005\u0014\u0000\u0000vw\u0006\t\uffff\uffff\u0000w\u0013\u0001\u0000"+
		"\u0000\u0000xy\u0005\u000b\u0000\u0000yz\u0005\r\u0000\u0000z{\u0005\u0018"+
		"\u0000\u0000{|\u0006\n\uffff\uffff\u0000|}\u0005\u0015\u0000\u0000}~\u0006"+
		"\n\uffff\uffff\u0000~\u007f\u0007\u0000\u0000\u0000\u007f\u0080\u0006"+
		"\n\uffff\uffff\u0000\u0080\u0081\u0005\u000e\u0000\u0000\u0081\u0082\u0006"+
		"\n\uffff\uffff\u0000\u0082\u0083\u0005\u0013\u0000\u0000\u0083\u0085\u0006"+
		"\n\uffff\uffff\u0000\u0084\u0086\u0003\n\u0005\u0000\u0085\u0084\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005\u0014\u0000\u0000\u008a\u0096\u0006"+
		"\n\uffff\uffff\u0000\u008b\u008c\u0005\f\u0000\u0000\u008c\u008d\u0005"+
		"\u0013\u0000\u0000\u008d\u008f\u0006\n\uffff\uffff\u0000\u008e\u0090\u0003"+
		"\n\u0005\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000"+
		"\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0014"+
		"\u0000\u0000\u0094\u0095\u0006\n\uffff\uffff\u0000\u0095\u0097\u0001\u0000"+
		"\u0000\u0000\u0096\u008b\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u0015\u0001\u0000\u0000\u0000\u0098\u009b\u0003\u001a"+
		"\r\u0000\u0099\u009b\u0003\u0018\f\u0000\u009a\u0098\u0001\u0000\u0000"+
		"\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u00a4\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0005\u0010\u0000\u0000\u009d\u00a0\u0006\u000b\uffff"+
		"\uffff\u0000\u009e\u00a1\u0003\u001a\r\u0000\u009f\u00a1\u0003\u0018\f"+
		"\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u009c\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u0017\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0017\u0000"+
		"\u0000\u00a8\u00a9\u0006\f\uffff\uffff\u0000\u00a9\u00aa\u0005\r\u0000"+
		"\u0000\u00aa\u00ab\u0006\f\uffff\uffff\u0000\u00ab\u00ac\u0007\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0006\f\uffff\uffff\u0000\u00ad\u00ae\u0005\u0012\u0000"+
		"\u0000\u00ae\u00af\u0006\f\uffff\uffff\u0000\u00af\u00b0\u0007\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0006\f\uffff\uffff\u0000\u00b1\u00b2\u0005\u000e\u0000"+
		"\u0000\u00b2\u00b3\u0006\f\uffff\uffff\u0000\u00b3\u0019\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0005\u0018\u0000\u0000\u00b5\u00bf\u0006\r\uffff\uffff"+
		"\u0000\u00b6\u00b7\u0005\u0019\u0000\u0000\u00b7\u00bf\u0006\r\uffff\uffff"+
		"\u0000\u00b8\u00b9\u0005\u001e\u0000\u0000\u00b9\u00bf\u0006\r\uffff\uffff"+
		"\u0000\u00ba\u00bb\u0005\u001f\u0000\u0000\u00bb\u00bf\u0006\r\uffff\uffff"+
		"\u0000\u00bc\u00bd\u0005\u0016\u0000\u0000\u00bd\u00bf\u0006\r\uffff\uffff"+
		"\u0000\u00be\u00b4\u0001\u0000\u0000\u0000\u00be\u00b6\u0001\u0000\u0000"+
		"\u0000\u00be\u00b8\u0001\u0000\u0000\u0000\u00be\u00ba\u0001\u0000\u0000"+
		"\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u001b\u0001\u0000\u0000"+
		"\u0000\r%/<BIs\u0087\u0091\u0096\u009a\u00a0\u00a4\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}