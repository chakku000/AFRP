// Generated from AFRP.g4 by ANTLR 4.5
package jp.ac.titech.itpro.sdl.afrp;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AFRPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, ID=29, INT=30, WS=31;
	public static final int
		RULE_topLevel = 0, RULE_inputdef = 1, RULE_outputdef = 2, RULE_definition = 3, 
		RULE_expression = 4, RULE_constant = 5, RULE_binOpMulDiv = 6, RULE_binOpAddSub = 7, 
		RULE_binOpShift = 8, RULE_binOpCompare = 9, RULE_binOpEqual = 10, RULE_binOpBitAnd = 11, 
		RULE_binOpBitXor = 12, RULE_binOpBitOr = 13, RULE_binOpLogicOr = 14, RULE_binOpLogicAnd = 15, 
		RULE_number = 16;
	public static final String[] ruleNames = {
		"topLevel", "inputdef", "outputdef", "definition", "expression", "constant", 
		"binOpMulDiv", "binOpAddSub", "binOpShift", "binOpCompare", "binOpEqual", 
		"binOpBitAnd", "binOpBitXor", "binOpBitOr", "binOpLogicOr", "binOpLogicAnd", 
		"number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'in'", "','", "'out'", "'node'", "'='", "'if'", "'then'", "'else'", 
		"'True'", "'False'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", 
		"'<'", "'<='", "'>='", "'>'", "'=='", "'!='", "'&'", "'^'", "'|'", "'&&'", 
		"'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "ID", "INT", "WS"
	};
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
	public String getGrammarFileName() { return "AFRP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AFRPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TopLevelContext extends ParserRuleContext {
		public InputdefContext inputdef() {
			return getRuleContext(InputdefContext.class,0);
		}
		public OutputdefContext outputdef() {
			return getRuleContext(OutputdefContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public TopLevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterTopLevel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitTopLevel(this);
		}
	}

	public final TopLevelContext topLevel() throws RecognitionException {
		TopLevelContext _localctx = new TopLevelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_topLevel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			inputdef();
			setState(35);
			outputdef();
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				definition();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
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

	public static class InputdefContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AFRPParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AFRPParser.ID, i);
		}
		public InputdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterInputdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitInputdef(this);
		}
	}

	public final InputdefContext inputdef() throws RecognitionException {
		InputdefContext _localctx = new InputdefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_inputdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			match(ID);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(43);
				match(T__1);
				setState(44);
				match(ID);
				}
				}
				setState(49);
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

	public static class OutputdefContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AFRPParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AFRPParser.ID, i);
		}
		public OutputdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterOutputdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitOutputdef(this);
		}
	}

	public final OutputdefContext outputdef() throws RecognitionException {
		OutputdefContext _localctx = new OutputdefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_outputdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__2);
			setState(51);
			match(ID);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(52);
				match(T__1);
				setState(53);
				match(ID);
				}
				}
				setState(58);
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

	public static class DefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AFRPParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitDefinition(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__3);
			setState(60);
			match(ID);
			setState(61);
			match(T__4);
			setState(62);
			expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode ID() { return getToken(AFRPParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinOpMulDivContext binOpMulDiv() {
			return getRuleContext(BinOpMulDivContext.class,0);
		}
		public BinOpAddSubContext binOpAddSub() {
			return getRuleContext(BinOpAddSubContext.class,0);
		}
		public BinOpShiftContext binOpShift() {
			return getRuleContext(BinOpShiftContext.class,0);
		}
		public BinOpCompareContext binOpCompare() {
			return getRuleContext(BinOpCompareContext.class,0);
		}
		public BinOpEqualContext binOpEqual() {
			return getRuleContext(BinOpEqualContext.class,0);
		}
		public BinOpBitAndContext binOpBitAnd() {
			return getRuleContext(BinOpBitAndContext.class,0);
		}
		public BinOpBitXorContext binOpBitXor() {
			return getRuleContext(BinOpBitXorContext.class,0);
		}
		public BinOpBitOrContext binOpBitOr() {
			return getRuleContext(BinOpBitOrContext.class,0);
		}
		public BinOpLogicOrContext binOpLogicOr() {
			return getRuleContext(BinOpLogicOrContext.class,0);
		}
		public BinOpLogicAndContext binOpLogicAnd() {
			return getRuleContext(BinOpLogicAndContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case INT:
				{
				setState(65);
				constant();
				}
				break;
			case ID:
				{
				setState(66);
				match(ID);
				}
				break;
			case T__5:
				{
				setState(67);
				match(T__5);
				setState(68);
				expression(0);
				setState(69);
				match(T__6);
				setState(70);
				expression(0);
				setState(71);
				match(T__7);
				setState(72);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(76);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(77);
						binOpMulDiv();
						setState(78);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(80);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(81);
						binOpAddSub();
						setState(82);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(85);
						binOpShift();
						setState(86);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(88);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(89);
						binOpCompare();
						setState(90);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(93);
						binOpEqual();
						setState(94);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(97);
						binOpBitAnd();
						setState(98);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(100);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(101);
						binOpBitXor();
						setState(102);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(105);
						binOpBitOr();
						setState(106);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(109);
						binOpLogicOr();
						setState(110);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(112);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(113);
						binOpLogicAnd();
						setState(114);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ConstantContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constant);
		try {
			setState(124);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(T__9);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				number();
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

	public static class BinOpMulDivContext extends ParserRuleContext {
		public BinOpMulDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpMulDiv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpMulDiv(this);
		}
	}

	public final BinOpMulDivContext binOpMulDiv() throws RecognitionException {
		BinOpMulDivContext _localctx = new BinOpMulDivContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_binOpMulDiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class BinOpAddSubContext extends ParserRuleContext {
		public BinOpAddSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpAddSub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpAddSub(this);
		}
	}

	public final BinOpAddSubContext binOpAddSub() throws RecognitionException {
		BinOpAddSubContext _localctx = new BinOpAddSubContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_binOpAddSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class BinOpShiftContext extends ParserRuleContext {
		public BinOpShiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpShift; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpShift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpShift(this);
		}
	}

	public final BinOpShiftContext binOpShift() throws RecognitionException {
		BinOpShiftContext _localctx = new BinOpShiftContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_binOpShift);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__16) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class BinOpCompareContext extends ParserRuleContext {
		public BinOpCompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpCompare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpCompare(this);
		}
	}

	public final BinOpCompareContext binOpCompare() throws RecognitionException {
		BinOpCompareContext _localctx = new BinOpCompareContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binOpCompare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class BinOpEqualContext extends ParserRuleContext {
		public BinOpEqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpEqual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpEqual(this);
		}
	}

	public final BinOpEqualContext binOpEqual() throws RecognitionException {
		BinOpEqualContext _localctx = new BinOpEqualContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_binOpEqual);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class BinOpBitAndContext extends ParserRuleContext {
		public BinOpBitAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpBitAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpBitAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpBitAnd(this);
		}
	}

	public final BinOpBitAndContext binOpBitAnd() throws RecognitionException {
		BinOpBitAndContext _localctx = new BinOpBitAndContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_binOpBitAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__23);
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

	public static class BinOpBitXorContext extends ParserRuleContext {
		public BinOpBitXorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpBitXor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpBitXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpBitXor(this);
		}
	}

	public final BinOpBitXorContext binOpBitXor() throws RecognitionException {
		BinOpBitXorContext _localctx = new BinOpBitXorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_binOpBitXor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__24);
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

	public static class BinOpBitOrContext extends ParserRuleContext {
		public BinOpBitOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpBitOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpBitOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpBitOr(this);
		}
	}

	public final BinOpBitOrContext binOpBitOr() throws RecognitionException {
		BinOpBitOrContext _localctx = new BinOpBitOrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_binOpBitOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__25);
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

	public static class BinOpLogicOrContext extends ParserRuleContext {
		public BinOpLogicOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpLogicOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpLogicOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpLogicOr(this);
		}
	}

	public final BinOpLogicOrContext binOpLogicOr() throws RecognitionException {
		BinOpLogicOrContext _localctx = new BinOpLogicOrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binOpLogicOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__26);
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

	public static class BinOpLogicAndContext extends ParserRuleContext {
		public BinOpLogicAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpLogicAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterBinOpLogicAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitBinOpLogicAnd(this);
		}
	}

	public final BinOpLogicAndContext binOpLogicAnd() throws RecognitionException {
		BinOpLogicAndContext _localctx = new BinOpLogicAndContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binOpLogicAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__27);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AFRPParser.INT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AFRPListener ) ((AFRPListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(INT);
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
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0097\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\6\2(\n\2\r\2\16\2)\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\4\3\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6M\n\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"w\n\6\f\6\16\6z\13\6\3\7\3\7\3\7\5\7\177\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\2\3\n\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\7\3\2"+
		"\r\17\3\2\20\21\3\2\22\23\3\2\24\27\3\2\30\31\u0096\2$\3\2\2\2\4+\3\2"+
		"\2\2\6\64\3\2\2\2\b=\3\2\2\2\nL\3\2\2\2\f~\3\2\2\2\16\u0080\3\2\2\2\20"+
		"\u0082\3\2\2\2\22\u0084\3\2\2\2\24\u0086\3\2\2\2\26\u0088\3\2\2\2\30\u008a"+
		"\3\2\2\2\32\u008c\3\2\2\2\34\u008e\3\2\2\2\36\u0090\3\2\2\2 \u0092\3\2"+
		"\2\2\"\u0094\3\2\2\2$%\5\4\3\2%\'\5\6\4\2&(\5\b\5\2\'&\3\2\2\2()\3\2\2"+
		"\2)\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+,\7\3\2\2,\61\7\37\2\2-.\7\4\2\2.\60"+
		"\7\37\2\2/-\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2"+
		"\2\63\61\3\2\2\2\64\65\7\5\2\2\65:\7\37\2\2\66\67\7\4\2\2\679\7\37\2\2"+
		"8\66\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\7\3\2\2\2<:\3\2\2\2=>\7\6"+
		"\2\2>?\7\37\2\2?@\7\7\2\2@A\5\n\6\2A\t\3\2\2\2BC\b\6\1\2CM\5\f\7\2DM\7"+
		"\37\2\2EF\7\b\2\2FG\5\n\6\2GH\7\t\2\2HI\5\n\6\2IJ\7\n\2\2JK\5\n\6\2KM"+
		"\3\2\2\2LB\3\2\2\2LD\3\2\2\2LE\3\2\2\2Mx\3\2\2\2NO\f\r\2\2OP\5\16\b\2"+
		"PQ\5\n\6\16Qw\3\2\2\2RS\f\f\2\2ST\5\20\t\2TU\5\n\6\rUw\3\2\2\2VW\f\13"+
		"\2\2WX\5\22\n\2XY\5\n\6\fYw\3\2\2\2Z[\f\n\2\2[\\\5\24\13\2\\]\5\n\6\13"+
		"]w\3\2\2\2^_\f\t\2\2_`\5\26\f\2`a\5\n\6\naw\3\2\2\2bc\f\b\2\2cd\5\30\r"+
		"\2de\5\n\6\tew\3\2\2\2fg\f\7\2\2gh\5\32\16\2hi\5\n\6\biw\3\2\2\2jk\f\6"+
		"\2\2kl\5\34\17\2lm\5\n\6\7mw\3\2\2\2no\f\5\2\2op\5\36\20\2pq\5\n\6\6q"+
		"w\3\2\2\2rs\f\4\2\2st\5 \21\2tu\5\n\6\5uw\3\2\2\2vN\3\2\2\2vR\3\2\2\2"+
		"vV\3\2\2\2vZ\3\2\2\2v^\3\2\2\2vb\3\2\2\2vf\3\2\2\2vj\3\2\2\2vn\3\2\2\2"+
		"vr\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\13\3\2\2\2zx\3\2\2\2{\177\7"+
		"\13\2\2|\177\7\f\2\2}\177\5\"\22\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\r"+
		"\3\2\2\2\u0080\u0081\t\2\2\2\u0081\17\3\2\2\2\u0082\u0083\t\3\2\2\u0083"+
		"\21\3\2\2\2\u0084\u0085\t\4\2\2\u0085\23\3\2\2\2\u0086\u0087\t\5\2\2\u0087"+
		"\25\3\2\2\2\u0088\u0089\t\6\2\2\u0089\27\3\2\2\2\u008a\u008b\7\32\2\2"+
		"\u008b\31\3\2\2\2\u008c\u008d\7\33\2\2\u008d\33\3\2\2\2\u008e\u008f\7"+
		"\34\2\2\u008f\35\3\2\2\2\u0090\u0091\7\35\2\2\u0091\37\3\2\2\2\u0092\u0093"+
		"\7\36\2\2\u0093!\3\2\2\2\u0094\u0095\7 \2\2\u0095#\3\2\2\2\t)\61:Lvx~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}