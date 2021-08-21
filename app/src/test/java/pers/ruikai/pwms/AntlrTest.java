package pers.ruikai.pwms;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;


import org.junit.jupiter.api.Test;

import pers.ruikai.pwms.compiler.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;

public class AntlrTest {

    // This method is run before each method annotated with @Test below
    @Test
    public void setup() throws Exception {
        InputStream is = getClass().getResourceAsStream("/testfile");
        CharStream input = CharStreams.fromStream(is);
        PWMSLexer lexer = new PWMSLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PWMSParser parser = new PWMSParser(tokens);
        parser.setBuildParseTree(true);      // tell ANTLR to build a parse tree
        ParseTree tree = parser.records(); // parse

        // EvalVisitor evalVisitor = new EvalVisitor();
        // int result = evalVisitor.visit(tree);
        // System.out.println("visitor result = "+result);
    }
}