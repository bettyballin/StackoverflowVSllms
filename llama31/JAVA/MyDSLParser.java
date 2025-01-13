// Generated from MyDSL.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"SimplifiableIfStatement", "unused"})
public class MyDSLParser extends Parser {
    public static final String[] tokenNames = {
        "<INVALID>", "WS", "ID", "'hello'"
    };
    public static final int
        WS=1, ID=2, T__0=3;
    public static final int
        RULE_prog = 0, RULE_statement = 1;

    @Override
    public String getGrammarFileName() { return "MyDSL.g4"; }

    @Override
    public String[] getTokenNames() { return tokenNames; }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public MyDSLParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }

    public static class ProgContext extends ParserRuleContext {
        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }
        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class,i);
        }
        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_prog; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof MyDSLListener ) ((MyDSLListener)listener).enterProg(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof MyDSLListener ) ((MyDSLListener)listener).exitProg(this);
        }
        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if ( visitor instanceof MyDSLVisitor ) return ((MyDSLVisitor<? extends T>)visitor).visitProg(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prog);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(5);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la==T__0) {
                {
                {
                setState(2);
                statement();
                }
                }
                setState(7);
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

    public static class StatementContext extends ParserRuleContext {
        public TerminalNode ID() { return getToken(MyDSLParser.ID, 0); }
        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_statement; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof MyDSLListener ) ((MyDSLListener)listener).enterStatement(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof MyDSLListener ) ((MyDSLListener)listener).exitStatement(this);
        }
        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if ( visitor instanceof MyDSLVisitor ) return ((MyDSLVisitor<? extends T>)visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(8);
            match(T__0);
            setState(9);
            match(ID);
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
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\5\17\4\2\t\2\4"+
        "\3\t\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\2\2\2\4\2\4\2\2"+
        "\2\16\2\t\3\2\r\16\3\2\3\3\2\2\2\2\17\2\b\3\2\2\2\4\n\3\2\2\2\6\b\5\4"+
        "\3\2\7\6\3\2\2\2\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\3\3\2\2\2\13"+
        "\t\3\2\2\2\f\r\7\3\2\2\r\16\7\4\2\2\16\5\3\2\2\2\4\t";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public static void main(String[] args) {
        String input = "hello world";
        CharStream stream = CharStreams.fromString(input);
        MyDSLLexer lexer = new MyDSLLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        MyDSLParser parser = new MyDSLParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }
}