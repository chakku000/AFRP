// Generated from AFRP.g4 by ANTLR 4.5
package jp.ac.titech.itpro.sdl.afrp;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AFRPLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, ID=29, INT=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "ID", "INT", "WS"
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


	public AFRPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AFRP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00a8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\7\36\u0098\n\36\f\36\16\36\u009b"+
		"\13\36\3\37\6\37\u009e\n\37\r\37\16\37\u009f\3 \6 \u00a3\n \r \16 \u00a4"+
		"\3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!\3\2\6\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\""+
		"\"\u00aa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5D\3\2\2\2\7F\3\2\2\2"+
		"\tJ\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17T\3\2\2\2\21Y\3\2\2\2\23^\3\2\2\2"+
		"\25c\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35o\3\2\2\2\37q\3\2\2"+
		"\2!s\3\2\2\2#v\3\2\2\2%y\3\2\2\2\'{\3\2\2\2)~\3\2\2\2+\u0081\3\2\2\2-"+
		"\u0083\3\2\2\2/\u0086\3\2\2\2\61\u0089\3\2\2\2\63\u008b\3\2\2\2\65\u008d"+
		"\3\2\2\2\67\u008f\3\2\2\29\u0092\3\2\2\2;\u0095\3\2\2\2=\u009d\3\2\2\2"+
		"?\u00a2\3\2\2\2AB\7k\2\2BC\7p\2\2C\4\3\2\2\2DE\7.\2\2E\6\3\2\2\2FG\7q"+
		"\2\2GH\7w\2\2HI\7v\2\2I\b\3\2\2\2JK\7p\2\2KL\7q\2\2LM\7f\2\2MN\7g\2\2"+
		"N\n\3\2\2\2OP\7?\2\2P\f\3\2\2\2QR\7k\2\2RS\7h\2\2S\16\3\2\2\2TU\7v\2\2"+
		"UV\7j\2\2VW\7g\2\2WX\7p\2\2X\20\3\2\2\2YZ\7g\2\2Z[\7n\2\2[\\\7u\2\2\\"+
		"]\7g\2\2]\22\3\2\2\2^_\7V\2\2_`\7t\2\2`a\7w\2\2ab\7g\2\2b\24\3\2\2\2c"+
		"d\7H\2\2de\7c\2\2ef\7n\2\2fg\7u\2\2gh\7g\2\2h\26\3\2\2\2ij\7,\2\2j\30"+
		"\3\2\2\2kl\7\61\2\2l\32\3\2\2\2mn\7\'\2\2n\34\3\2\2\2op\7-\2\2p\36\3\2"+
		"\2\2qr\7/\2\2r \3\2\2\2st\7>\2\2tu\7>\2\2u\"\3\2\2\2vw\7@\2\2wx\7@\2\2"+
		"x$\3\2\2\2yz\7>\2\2z&\3\2\2\2{|\7>\2\2|}\7?\2\2}(\3\2\2\2~\177\7@\2\2"+
		"\177\u0080\7?\2\2\u0080*\3\2\2\2\u0081\u0082\7@\2\2\u0082,\3\2\2\2\u0083"+
		"\u0084\7?\2\2\u0084\u0085\7?\2\2\u0085.\3\2\2\2\u0086\u0087\7#\2\2\u0087"+
		"\u0088\7?\2\2\u0088\60\3\2\2\2\u0089\u008a\7(\2\2\u008a\62\3\2\2\2\u008b"+
		"\u008c\7`\2\2\u008c\64\3\2\2\2\u008d\u008e\7~\2\2\u008e\66\3\2\2\2\u008f"+
		"\u0090\7(\2\2\u0090\u0091\7(\2\2\u00918\3\2\2\2\u0092\u0093\7~\2\2\u0093"+
		"\u0094\7~\2\2\u0094:\3\2\2\2\u0095\u0099\t\2\2\2\u0096\u0098\t\3\2\2\u0097"+
		"\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a<\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\t\4\2\2\u009d\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		">\3\2\2\2\u00a1\u00a3\t\5\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2"+
		"\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\b \2\2\u00a7@\3\2\2\2\6\2\u0099\u009f\u00a4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}