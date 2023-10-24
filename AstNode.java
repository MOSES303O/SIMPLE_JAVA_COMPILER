import java.util.List;

public class AstNode {
    String type;
    public List<AstNode> body;
    AstNode expression;
    Identifier callee;
    List<AstNode> arguments;
    String value;
   /*AstNode(List<AstNode> body){
         this.body=body;
    }*/
}
