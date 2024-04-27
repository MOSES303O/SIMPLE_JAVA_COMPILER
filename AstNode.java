import java.util.List;

public class AstNode {
    public AstNode(String string, String value) {
    }
    String type;
    List<AstNode> body;
    AstNode expression;
    Identifier callee;
    List<AstNode> arguments;
    String value;
   /*AstNode(List<AstNode> body){
         this.body=body;
    }*/
    public Object params;
}
