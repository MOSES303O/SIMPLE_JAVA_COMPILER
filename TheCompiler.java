import java.util.List;

public class TheCompiler {
     public static String compile(String input) {
        Tokenize tk=new Tokenize();
        List<Token> tokens = tk.tokenize(input);
        perser ps=new perser(tokens);
        AstNode ast = ps.parse();
        TransformerVisitor tv = new TransformerVisitor();
        Transformer tf=new Transformer(tv);
        AstNode newAst = tf.transform(ast);
        CodeGenerate cg=new CodeGenerate();
        String output = cg.generateCode(newAst);
        return output;
    }

    public static void main(String[] args) {
        String input = "(add 2 (subtract 4 2))";
        String compiledCode = compile(input);
        System.out.println(compiledCode);
    }
}
