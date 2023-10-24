import java.util.List;
public class CallExpression extends AstNode {
    String name;
    List<AstNode> params;
    Identifier callee;
    List<AstNode> arguments;
    CallExpression(String name,List<AstNode> params){
        this.type="CallExpression";
        this.name=name;
        this.params=params;
    }
    CallExpression(Identifier callee, List<AstNode> arguments) {
        this.type = "CallExpression";
        this.callee = callee;
        this.arguments = arguments;
    }
}
