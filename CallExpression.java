import java.util.List;
public class CallExpression extends AstNode {
    String name;
    List<AstNode> params;
    CallExpression(String name,List<AstNode> params){
        this.type="CallExpression";
        this.name=name;
        this.params=params;
    }
}
