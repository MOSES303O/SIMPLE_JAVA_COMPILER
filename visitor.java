import java.util.Map;
import java.util.function.Consumer;
public class Visitor {
     Map<String, NodeVisitor> visitors;
    Visitor(Map<String, NodeVisitor> visitors){        
        this.visitors=visitors;
    }
    interface NodeVisitor{
        Void enter(AstNode node,AstNode parent);
        void exit(AstNode node,AstNode parent );
        Consumer<AstNode> enter();
        Consumer<AstNode> exit();
    } 
   /*void visit(program node){};
    void visit(CallExpression node){};
    void visit(NumberLiteral node){};
    void visit(StringLiteral node){};*/
}
