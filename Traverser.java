import java.util.List;

import javax.management.RuntimeErrorException;

public class Traverser {
    private Visitor visitor;
    Traverser(Visitor visitor){
        this.visitor=visitor;
    }
    //from private to protected traverseArray
       private void traverseArray(List<AstNode> array, AstNode parent){
            array.forEach(child ->{
                TraverseNode(child,parent);
            });
        }
         private void TraverseNode(AstNode node,AstNode parent){
            Visitor.NodeVisitor methods=visitor.visitors.get(node.type);
            //Customer<AstNode> enter=methods.enter();
            if(methods !=null && methods.enter() !=null){
                methods.enter().accept(node);
            }
            switch(node.type){
                case "program":
                traverseArray(((program) node).body, node);
                break;
                case "CallExpression":
                traverseArray(((CallExpression) node).params, node);
                break;
                case "NumberLiteral":
                case "StringLiteral":
                break;
                default:
                throw new RuntimeErrorException(null, "UNKOWN NODE TYPE"+node.type);
            }
            if(methods !=null && methods.exit() !=null){
                methods.enter().accept(node);
            }
        }
        public void traverse(AstNode ast){
            TraverseNode(ast,null);
        }
}
