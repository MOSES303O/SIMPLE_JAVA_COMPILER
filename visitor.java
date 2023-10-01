import java.util.Map;
public class visitor {
    Map<String,NodeVisitor> visitors;
    visitor(Map<String, NodeVisitor> visitors){
        this.visitors=visitors;
    }
    interface NodeVisitor{
        void enter(AstNode node,AstNode parent);
        void exit(AstNode node,AstNode parent);
    }
}
