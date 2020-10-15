// Generated from D:/AndroidStudio/Projects/UnivLab1/app/src/main/java/com/delitx/univlab1\ExpressionDecode.g4 by ANTLR 4.8
package com.delitx.univlab1.language_decryption.generated.com.delitx.univlab1;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionDecodeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, MIN=4, MAX=5, NUMBER=6, ADD=7, SUBTRACT=8, MULTIPLY=9, 
		DIVIDE=10, NOT=11, EQUALS=12, LESS=13, MOR=14, MOD=15, DIV=16, LINK=17, 
		WORD=18, CHAR=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "MIN", "MAX", "NUMBER", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "NOT", "EQUALS", "LESS", "MOR", "MOD", "DIV", "LINK", "WORD", 
			"CHAR"
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


	public ExpressionDecodeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExpressionDecode.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25k\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\7\6\79\n\7\r\7\16\7:\3\7\3\7\6\7?\n\7\r\7\16\7@\5\7C\n\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\7\22`\n\22\f\22\16"+
		"\22c\13\22\3\23\6\23f\n\23\r\23\16\23g\3\24\3\24\2\2\25\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25\3\2\3\4\2C\\c|\2o\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3"+
		"\2\2\2\7-\3\2\2\2\t/\3\2\2\2\13\63\3\2\2\2\r8\3\2\2\2\17D\3\2\2\2\21F"+
		"\3\2\2\2\23H\3\2\2\2\25J\3\2\2\2\27L\3\2\2\2\31N\3\2\2\2\33P\3\2\2\2\35"+
		"R\3\2\2\2\37T\3\2\2\2!X\3\2\2\2#\\\3\2\2\2%e\3\2\2\2\'i\3\2\2\2)*\7*\2"+
		"\2*\4\3\2\2\2+,\7.\2\2,\6\3\2\2\2-.\7+\2\2.\b\3\2\2\2/\60\7o\2\2\60\61"+
		"\7k\2\2\61\62\7p\2\2\62\n\3\2\2\2\63\64\7o\2\2\64\65\7c\2\2\65\66\7z\2"+
		"\2\66\f\3\2\2\2\679\4\62;\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2"+
		";B\3\2\2\2<>\7\60\2\2=?\4\62;\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2"+
		"\2AC\3\2\2\2B<\3\2\2\2BC\3\2\2\2C\16\3\2\2\2DE\7-\2\2E\20\3\2\2\2FG\7"+
		"/\2\2G\22\3\2\2\2HI\7,\2\2I\24\3\2\2\2JK\7\61\2\2K\26\3\2\2\2LM\7#\2\2"+
		"M\30\3\2\2\2NO\7?\2\2O\32\3\2\2\2PQ\7>\2\2Q\34\3\2\2\2RS\7@\2\2S\36\3"+
		"\2\2\2TU\7o\2\2UV\7q\2\2VW\7f\2\2W \3\2\2\2XY\7f\2\2YZ\7k\2\2Z[\7x\2\2"+
		"[\"\3\2\2\2\\]\5%\23\2]a\4\63;\2^`\4\62;\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2"+
		"\2ab\3\2\2\2b$\3\2\2\2ca\3\2\2\2df\5\'\24\2ed\3\2\2\2fg\3\2\2\2ge\3\2"+
		"\2\2gh\3\2\2\2h&\3\2\2\2ij\t\2\2\2j(\3\2\2\2\b\2:@Bag\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}