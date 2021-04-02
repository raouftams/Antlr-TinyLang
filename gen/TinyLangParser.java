// Generated from C:/Users/Raouftams/IdeaProjects/TinyLang\TinyLang.g4 by ANTLR 4.9.1

    package antlr;
    
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinyLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, SINGLE_LINE_COMMENT=27, MULTIPLE_LINE_COMMENT=28, 
		NOM_PROG=29, IDENTIFIANT=30, AFFECTATION=31, CNST=32, INT=33, FLOAT=34, 
		STRING=35, WHITESPACE=36;
	public static final int
		RULE_programme = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_type = 3, 
		RULE_identifiants = 4, RULE_instructions = 5, RULE_instruction = 6, RULE_affectation = 7, 
		RULE_expressionArithmetique = 8, RULE_expressionLogique = 9, RULE_condition = 10, 
		RULE_optelse = 11, RULE_boucle = 12, RULE_scan = 13, RULE_print = 14, 
		RULE_print_val = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"programme", "declarations", "declaration", "type", "identifiants", "instructions", 
			"instruction", "affectation", "expressionArithmetique", "expressionLogique", 
			"condition", "optelse", "boucle", "scan", "print", "print_val"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'compil'", "'('", "')'", "'{'", "'start'", "'}'", "';'", "'intCompil'", 
			"'floatCompil'", "'stringCompil'", "','", "'-'", "'+'", "'*'", "'/'", 
			"'!='", "'=='", "'<'", "'>'", "'if'", "'then'", "'else'", "'do'", "'while'", 
			"'scanCompil'", "'printCompil'", null, null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "SINGLE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", "NOM_PROG", 
			"IDENTIFIANT", "AFFECTATION", "CNST", "INT", "FLOAT", "STRING", "WHITESPACE"
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
	public String getGrammarFileName() { return "TinyLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TinyLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgrammeContext extends ParserRuleContext {
		public TerminalNode NOM_PROG() { return getToken(TinyLangParser.NOM_PROG, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TinyLangParser.EOF, 0); }
		public ProgrammeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programme; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterProgramme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitProgramme(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitProgramme(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgrammeContext programme() throws RecognitionException {
		ProgrammeContext _localctx = new ProgrammeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programme);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			match(NOM_PROG);
			setState(34);
			match(T__1);
			setState(35);
			match(T__2);
			setState(36);
			match(T__3);
			setState(37);
			declarations();
			setState(38);
			match(T__4);
			setState(39);
			instructions();
			setState(40);
			match(T__5);
			setState(41);
			match(EOF);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				declaration();
				setState(44);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
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

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifiantsContext identifiants() {
			return getRuleContext(IdentifiantsContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			type();
			setState(51);
			identifiants();
			setState(52);
			match(T__6);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class IdentifiantsContext extends ParserRuleContext {
		public TerminalNode IDENTIFIANT() { return getToken(TinyLangParser.IDENTIFIANT, 0); }
		public IdentifiantsContext identifiants() {
			return getRuleContext(IdentifiantsContext.class,0);
		}
		public IdentifiantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterIdentifiants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitIdentifiants(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitIdentifiants(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifiantsContext identifiants() throws RecognitionException {
		IdentifiantsContext _localctx = new IdentifiantsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_identifiants);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(IDENTIFIANT);
				setState(57);
				match(T__10);
				setState(58);
				identifiants();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(IDENTIFIANT);
				}
				break;
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

	public static class InstructionsContext extends ParserRuleContext {
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitInstructions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitInstructions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instructions);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				instruction();
				setState(63);
				instructions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				instruction();
				}
				break;
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

	public static class InstructionContext extends ParserRuleContext {
		public AffectationContext affectation() {
			return getRuleContext(AffectationContext.class,0);
		}
		public ExpressionArithmetiqueContext expressionArithmetique() {
			return getRuleContext(ExpressionArithmetiqueContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BoucleContext boucle() {
			return getRuleContext(BoucleContext.class,0);
		}
		public ScanContext scan() {
			return getRuleContext(ScanContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instruction);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				affectation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				expressionArithmetique(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				condition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				boucle();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				scan();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				print();
				}
				break;
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

	public static class AffectationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIANT() { return getToken(TinyLangParser.IDENTIFIANT, 0); }
		public TerminalNode AFFECTATION() { return getToken(TinyLangParser.AFFECTATION, 0); }
		public ExpressionArithmetiqueContext expressionArithmetique() {
			return getRuleContext(ExpressionArithmetiqueContext.class,0);
		}
		public AffectationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterAffectation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitAffectation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitAffectation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AffectationContext affectation() throws RecognitionException {
		AffectationContext _localctx = new AffectationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_affectation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(IDENTIFIANT);
			setState(77);
			match(AFFECTATION);
			setState(78);
			expressionArithmetique(0);
			setState(79);
			match(T__6);
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

	public static class ExpressionArithmetiqueContext extends ParserRuleContext {
		public List<ExpressionArithmetiqueContext> expressionArithmetique() {
			return getRuleContexts(ExpressionArithmetiqueContext.class);
		}
		public ExpressionArithmetiqueContext expressionArithmetique(int i) {
			return getRuleContext(ExpressionArithmetiqueContext.class,i);
		}
		public TerminalNode IDENTIFIANT() { return getToken(TinyLangParser.IDENTIFIANT, 0); }
		public TerminalNode CNST() { return getToken(TinyLangParser.CNST, 0); }
		public TerminalNode INT() { return getToken(TinyLangParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TinyLangParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(TinyLangParser.STRING, 0); }
		public ExpressionArithmetiqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionArithmetique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterExpressionArithmetique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitExpressionArithmetique(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitExpressionArithmetique(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionArithmetiqueContext expressionArithmetique() throws RecognitionException {
		return expressionArithmetique(0);
	}

	private ExpressionArithmetiqueContext expressionArithmetique(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionArithmetiqueContext _localctx = new ExpressionArithmetiqueContext(_ctx, _parentState);
		ExpressionArithmetiqueContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expressionArithmetique, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(82);
				match(T__1);
				setState(83);
				expressionArithmetique(0);
				setState(84);
				match(T__2);
				}
				break;
			case IDENTIFIANT:
				{
				setState(86);
				match(IDENTIFIANT);
				}
				break;
			case CNST:
				{
				setState(87);
				match(CNST);
				}
				break;
			case INT:
				{
				setState(88);
				match(INT);
				}
				break;
			case FLOAT:
				{
				setState(89);
				match(FLOAT);
				}
				break;
			case STRING:
				{
				setState(90);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(105);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionArithmetiqueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionArithmetique);
						setState(93);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(94);
						match(T__11);
						setState(95);
						expressionArithmetique(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionArithmetiqueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionArithmetique);
						setState(96);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(97);
						match(T__12);
						setState(98);
						expressionArithmetique(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionArithmetiqueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionArithmetique);
						setState(99);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(100);
						match(T__13);
						setState(101);
						expressionArithmetique(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionArithmetiqueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionArithmetique);
						setState(102);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(103);
						match(T__14);
						setState(104);
						expressionArithmetique(7);
						}
						break;
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionLogiqueContext extends ParserRuleContext {
		public List<ExpressionArithmetiqueContext> expressionArithmetique() {
			return getRuleContexts(ExpressionArithmetiqueContext.class);
		}
		public ExpressionArithmetiqueContext expressionArithmetique(int i) {
			return getRuleContext(ExpressionArithmetiqueContext.class,i);
		}
		public ExpressionLogiqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionLogique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterExpressionLogique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitExpressionLogique(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitExpressionLogique(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionLogiqueContext expressionLogique() throws RecognitionException {
		ExpressionLogiqueContext _localctx = new ExpressionLogiqueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressionLogique);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				expressionArithmetique(0);
				setState(111);
				match(T__15);
				setState(112);
				expressionArithmetique(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				expressionArithmetique(0);
				setState(115);
				match(T__16);
				setState(116);
				expressionArithmetique(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				expressionArithmetique(0);
				setState(119);
				match(T__17);
				setState(120);
				expressionArithmetique(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				expressionArithmetique(0);
				setState(123);
				match(T__18);
				setState(124);
				expressionArithmetique(0);
				}
				break;
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

	public static class ConditionContext extends ParserRuleContext {
		public ExpressionLogiqueContext expressionLogique() {
			return getRuleContext(ExpressionLogiqueContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public OptelseContext optelse() {
			return getRuleContext(OptelseContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__19);
			setState(129);
			match(T__1);
			setState(130);
			expressionLogique();
			setState(131);
			match(T__2);
			setState(132);
			match(T__20);
			setState(133);
			match(T__3);
			setState(134);
			instructions();
			setState(135);
			match(T__5);
			setState(136);
			optelse();
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

	public static class OptelseContext extends ParserRuleContext {
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public OptelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterOptelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitOptelse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitOptelse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptelseContext optelse() throws RecognitionException {
		OptelseContext _localctx = new OptelseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_optelse);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(T__21);
				setState(139);
				match(T__3);
				setState(140);
				instructions();
				setState(141);
				match(T__5);
				}
				break;
			case T__1:
			case T__5:
			case T__19:
			case T__22:
			case T__24:
			case T__25:
			case IDENTIFIANT:
			case CNST:
			case INT:
			case FLOAT:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class BoucleContext extends ParserRuleContext {
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public ExpressionLogiqueContext expressionLogique() {
			return getRuleContext(ExpressionLogiqueContext.class,0);
		}
		public BoucleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterBoucle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitBoucle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitBoucle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoucleContext boucle() throws RecognitionException {
		BoucleContext _localctx = new BoucleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_boucle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__22);
			setState(147);
			match(T__3);
			setState(148);
			instructions();
			setState(149);
			match(T__5);
			setState(150);
			match(T__23);
			setState(151);
			match(T__1);
			setState(152);
			expressionLogique();
			setState(153);
			match(T__2);
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

	public static class ScanContext extends ParserRuleContext {
		public IdentifiantsContext identifiants() {
			return getRuleContext(IdentifiantsContext.class,0);
		}
		public ScanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterScan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitScan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitScan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScanContext scan() throws RecognitionException {
		ScanContext _localctx = new ScanContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_scan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__24);
			setState(156);
			match(T__1);
			setState(157);
			identifiants();
			setState(158);
			match(T__2);
			setState(159);
			match(T__6);
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

	public static class PrintContext extends ParserRuleContext {
		public Print_valContext print_val() {
			return getRuleContext(Print_valContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__25);
			setState(162);
			match(T__1);
			setState(163);
			print_val();
			setState(164);
			match(T__2);
			setState(165);
			match(T__6);
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

	public static class Print_valContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(TinyLangParser.STRING, 0); }
		public IdentifiantsContext identifiants() {
			return getRuleContext(IdentifiantsContext.class,0);
		}
		public Print_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).enterPrint_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangListener ) ((TinyLangListener)listener).exitPrint_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TinyLangVisitor ) return ((TinyLangVisitor<? extends T>)visitor).visitPrint_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_valContext print_val() throws RecognitionException {
		Print_valContext _localctx = new Print_valContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_print_val);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(STRING);
				}
				break;
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				identifiants();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expressionArithmetique_sempred((ExpressionArithmetiqueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressionArithmetique_sempred(ExpressionArithmetiqueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00ae\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\63\n\3\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6?\n\6\3\7\3\7\3\7\3\7\5\7E\n\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\bM\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n^\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\nl\n\n\f\n\16\no\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0081\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0093\n\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00ac\n\21\3\21\2\3"+
		"\22\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\n\f\2\u00b4\2\""+
		"\3\2\2\2\4\62\3\2\2\2\6\64\3\2\2\2\b8\3\2\2\2\n>\3\2\2\2\fD\3\2\2\2\16"+
		"L\3\2\2\2\20N\3\2\2\2\22]\3\2\2\2\24\u0080\3\2\2\2\26\u0082\3\2\2\2\30"+
		"\u0092\3\2\2\2\32\u0094\3\2\2\2\34\u009d\3\2\2\2\36\u00a3\3\2\2\2 \u00ab"+
		"\3\2\2\2\"#\7\3\2\2#$\7\37\2\2$%\7\4\2\2%&\7\5\2\2&\'\7\6\2\2\'(\5\4\3"+
		"\2()\7\7\2\2)*\5\f\7\2*+\7\b\2\2+,\7\2\2\3,\3\3\2\2\2-.\5\6\4\2./\5\4"+
		"\3\2/\63\3\2\2\2\60\63\5\6\4\2\61\63\3\2\2\2\62-\3\2\2\2\62\60\3\2\2\2"+
		"\62\61\3\2\2\2\63\5\3\2\2\2\64\65\5\b\5\2\65\66\5\n\6\2\66\67\7\t\2\2"+
		"\67\7\3\2\2\289\t\2\2\29\t\3\2\2\2:;\7 \2\2;<\7\r\2\2<?\5\n\6\2=?\7 \2"+
		"\2>:\3\2\2\2>=\3\2\2\2?\13\3\2\2\2@A\5\16\b\2AB\5\f\7\2BE\3\2\2\2CE\5"+
		"\16\b\2D@\3\2\2\2DC\3\2\2\2E\r\3\2\2\2FM\5\20\t\2GM\5\22\n\2HM\5\26\f"+
		"\2IM\5\32\16\2JM\5\34\17\2KM\5\36\20\2LF\3\2\2\2LG\3\2\2\2LH\3\2\2\2L"+
		"I\3\2\2\2LJ\3\2\2\2LK\3\2\2\2M\17\3\2\2\2NO\7 \2\2OP\7!\2\2PQ\5\22\n\2"+
		"QR\7\t\2\2R\21\3\2\2\2ST\b\n\1\2TU\7\4\2\2UV\5\22\n\2VW\7\5\2\2W^\3\2"+
		"\2\2X^\7 \2\2Y^\7\"\2\2Z^\7#\2\2[^\7$\2\2\\^\7%\2\2]S\3\2\2\2]X\3\2\2"+
		"\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^m\3\2\2\2_`\f\13\2\2`a\7\16"+
		"\2\2al\5\22\n\fbc\f\n\2\2cd\7\17\2\2dl\5\22\n\13ef\f\t\2\2fg\7\20\2\2"+
		"gl\5\22\n\nhi\f\b\2\2ij\7\21\2\2jl\5\22\n\tk_\3\2\2\2kb\3\2\2\2ke\3\2"+
		"\2\2kh\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\23\3\2\2\2om\3\2\2\2pq\5"+
		"\22\n\2qr\7\22\2\2rs\5\22\n\2s\u0081\3\2\2\2tu\5\22\n\2uv\7\23\2\2vw\5"+
		"\22\n\2w\u0081\3\2\2\2xy\5\22\n\2yz\7\24\2\2z{\5\22\n\2{\u0081\3\2\2\2"+
		"|}\5\22\n\2}~\7\25\2\2~\177\5\22\n\2\177\u0081\3\2\2\2\u0080p\3\2\2\2"+
		"\u0080t\3\2\2\2\u0080x\3\2\2\2\u0080|\3\2\2\2\u0081\25\3\2\2\2\u0082\u0083"+
		"\7\26\2\2\u0083\u0084\7\4\2\2\u0084\u0085\5\24\13\2\u0085\u0086\7\5\2"+
		"\2\u0086\u0087\7\27\2\2\u0087\u0088\7\6\2\2\u0088\u0089\5\f\7\2\u0089"+
		"\u008a\7\b\2\2\u008a\u008b\5\30\r\2\u008b\27\3\2\2\2\u008c\u008d\7\30"+
		"\2\2\u008d\u008e\7\6\2\2\u008e\u008f\5\f\7\2\u008f\u0090\7\b\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u008c\3\2\2\2\u0092\u0091\3\2"+
		"\2\2\u0093\31\3\2\2\2\u0094\u0095\7\31\2\2\u0095\u0096\7\6\2\2\u0096\u0097"+
		"\5\f\7\2\u0097\u0098\7\b\2\2\u0098\u0099\7\32\2\2\u0099\u009a\7\4\2\2"+
		"\u009a\u009b\5\24\13\2\u009b\u009c\7\5\2\2\u009c\33\3\2\2\2\u009d\u009e"+
		"\7\33\2\2\u009e\u009f\7\4\2\2\u009f\u00a0\5\n\6\2\u00a0\u00a1\7\5\2\2"+
		"\u00a1\u00a2\7\t\2\2\u00a2\35\3\2\2\2\u00a3\u00a4\7\34\2\2\u00a4\u00a5"+
		"\7\4\2\2\u00a5\u00a6\5 \21\2\u00a6\u00a7\7\5\2\2\u00a7\u00a8\7\t\2\2\u00a8"+
		"\37\3\2\2\2\u00a9\u00ac\7%\2\2\u00aa\u00ac\5\n\6\2\u00ab\u00a9\3\2\2\2"+
		"\u00ab\u00aa\3\2\2\2\u00ac!\3\2\2\2\f\62>DL]km\u0080\u0092\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}