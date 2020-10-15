// Generated from D:/AndroidStudio/Projects/UnivLab1/app/src/main/java/com/delitx/univlab1\ExpressionDecode.g4 by ANTLR 4.8
package com.delitx.univlab1.language_decryption.generated.com.delitx.univlab1;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionDecodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, MIN=4, MAX=5, NUMBER=6, ADD=7, SUBTRACT=8, MULTIPLY=9, 
		DIVIDE=10, NOT=11, EQUALS=12, LESS=13, MOR=14, MOD=15, DIV=16, LINK=17, 
		WORD=18, CHAR=19;
	public static final int
		RULE_expr = 0, RULE_expression = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'min'", "'max'", null, "'+'", "'-'", "'*'", 
			"'/'", "'!'", "'='", "'<'", "'>'", "'mod'", "'div'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "MIN", "MAX", "NUMBER", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "NOT", "EQUALS", "LESS", "MOR", "MOD", "DIV", "LINK", "WORD", 
			"CHAR"
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
	public String getGrammarFileName() { return "ExpressionDecode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionDecodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprCalcContext extends ExprContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExpressionDecodeParser.EOF, 0); }
		public ExprCalcContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterExprCalc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitExprCalc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitExprCalc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			_localctx = new ExprCalcContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			expression(0);
			setState(5);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotExprContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(ExpressionDecodeParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LinkExprContext extends ExpressionContext {
		public TerminalNode LINK() { return getToken(ExpressionDecodeParser.LINK, 0); }
		public LinkExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterLinkExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitLinkExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitLinkExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparativeExprContext extends ExpressionContext {
		public Token operatorToken;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(ExpressionDecodeParser.EQUALS, 0); }
		public TerminalNode LESS() { return getToken(ExpressionDecodeParser.LESS, 0); }
		public TerminalNode MOR() { return getToken(ExpressionDecodeParser.MOR, 0); }
		public ComparativeExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterComparativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitComparativeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitComparativeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyExprContext extends ExpressionContext {
		public Token operatorToken;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(ExpressionDecodeParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(ExpressionDecodeParser.DIVIDE, 0); }
		public TerminalNode DIV() { return getToken(ExpressionDecodeParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ExpressionDecodeParser.MOD, 0); }
		public MultiplyExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterMultiplyExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitMultiplyExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitMultiplyExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExprContext extends ExpressionContext {
		public Token operatorToken;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ExpressionDecodeParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(ExpressionDecodeParser.SUBTRACT, 0); }
		public AdditiveExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitAdditiveExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(ExpressionDecodeParser.NUMBER, 0); }
		public BoolExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinMaxExprContext extends ExpressionContext {
		public Token operatorToken;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MIN() { return getToken(ExpressionDecodeParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(ExpressionDecodeParser.MAX, 0); }
		public MinMaxExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterMinMaxExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitMinMaxExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitMinMaxExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesesExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterParenthesesExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitParenthesesExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitParenthesesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusExprContext extends ExpressionContext {
		public TerminalNode SUBTRACT() { return getToken(ExpressionDecodeParser.SUBTRACT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MinusExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).enterMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionDecodeListener ) ((ExpressionDecodeListener)listener).exitMinusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionDecodeVisitor ) return ((ExpressionDecodeVisitor<? extends T>)visitor).visitMinusExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MIN:
			case MAX:
				{
				_localctx = new MinMaxExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(8);
				((MinMaxExprContext)_localctx).operatorToken = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MIN || _la==MAX) ) {
					((MinMaxExprContext)_localctx).operatorToken = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(9);
				match(T__0);
				setState(10);
				expression(0);
				setState(11);
				match(T__1);
				setState(12);
				expression(0);
				setState(13);
				match(T__2);
				}
				break;
			case T__0:
				{
				_localctx = new ParenthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(T__0);
				setState(16);
				expression(0);
				setState(17);
				match(T__2);
				}
				break;
			case SUBTRACT:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(SUBTRACT);
				setState(20);
				expression(7);
				}
				break;
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(NOT);
				setState(22);
				expression(3);
				}
				break;
			case NUMBER:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(NUMBER);
				}
				break;
			case LINK:
				{
				_localctx = new LinkExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(LINK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(36);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(27);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(28);
						((MultiplyExprContext)_localctx).operatorToken = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVIDE) | (1L << MOD) | (1L << DIV))) != 0)) ) {
							((MultiplyExprContext)_localctx).operatorToken = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(29);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(30);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(31);
						((AdditiveExprContext)_localctx).operatorToken = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUBTRACT) ) {
							((AdditiveExprContext)_localctx).operatorToken = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(32);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new ComparativeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(33);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(34);
						((ComparativeExprContext)_localctx).operatorToken = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << LESS) | (1L << MOR))) != 0)) ) {
							((ComparativeExprContext)_localctx).operatorToken = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(35);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25,\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\'"+
		"\n\3\f\3\16\3*\13\3\3\3\2\3\4\4\2\4\2\6\3\2\6\7\4\2\13\f\21\22\3\2\t\n"+
		"\3\2\16\20\2\61\2\6\3\2\2\2\4\33\3\2\2\2\6\7\5\4\3\2\7\b\7\2\2\3\b\3\3"+
		"\2\2\2\t\n\b\3\1\2\n\13\t\2\2\2\13\f\7\3\2\2\f\r\5\4\3\2\r\16\7\4\2\2"+
		"\16\17\5\4\3\2\17\20\7\5\2\2\20\34\3\2\2\2\21\22\7\3\2\2\22\23\5\4\3\2"+
		"\23\24\7\5\2\2\24\34\3\2\2\2\25\26\7\n\2\2\26\34\5\4\3\t\27\30\7\r\2\2"+
		"\30\34\5\4\3\5\31\34\7\b\2\2\32\34\7\23\2\2\33\t\3\2\2\2\33\21\3\2\2\2"+
		"\33\25\3\2\2\2\33\27\3\2\2\2\33\31\3\2\2\2\33\32\3\2\2\2\34(\3\2\2\2\35"+
		"\36\f\b\2\2\36\37\t\3\2\2\37\'\5\4\3\t !\f\7\2\2!\"\t\4\2\2\"\'\5\4\3"+
		"\b#$\f\6\2\2$%\t\5\2\2%\'\5\4\3\7&\35\3\2\2\2& \3\2\2\2&#\3\2\2\2\'*\3"+
		"\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3\2\2\2\5\33&(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}