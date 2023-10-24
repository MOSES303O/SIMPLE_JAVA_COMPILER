import java.util.HashMap;
import java.util.Map;

public class TransformerVisitor {
  /*  Map<String, NodeTransformer> Transformers;
   //MAKING THE PARAMETER INVISIBLE INSIDE TE CONSTRUCTOR
   TransformerVisitor(Map<String, NodeTransformer> Transformers) {
    this.Transformers=Transformers;
   }
   interface NodeTransformer{
    AstNode transform(AstNode node, AstNode parent);
   }*/
   public interface NodeTransformer {
        AstNode transform(AstNode node, AstNode parent);
    }

    public Map<String, NodeTransformer> Transformers;

    public TransformerVisitor() {
        Transformers = new HashMap<>();
        // Add your transformers here
        Transformers.put("NumberLiteral", (node, parent) -> {
            // Transformation logic for NumberLiteral nodes
            return node;
        });
        Transformers.put("StringLiteral", (node, parent) -> {
            // Transformation logic for StringLiteral nodes
            return node;
        });
        Transformers.put("CallExpression", (node, parent) -> {
            // Transformation logic for CallExpression nodes
            return node;
        });
        // Add more transformers as needed
    }
}
/*


public class Transformer {

    private AstNode transformNode(AstNode node, AstNode parent) {
        switch (node.getType()) {
            case "NumberLiteral":
                return new NumberLiteral(node.getValue());
            case "StringLiteral":
                return new StringLiteral(node.getValue());
            case "CallExpression":
                CallExpression callExpression = new CallExpression(node.getName());
                for (AstNode param : node.getParams()) {
                    callExpression.getParams().add(transformNode(param, callExpression));
                }
                if (parent instanceof CallExpression) {
                    return callExpression;
                } else {
                    return new ExpressionStatement(callExpression);
                }
            default:
                throw new RuntimeException("Unknown node type: " + node.getType());
        }
    }

    public AstNode transform(AstNode ast) {
        Program newAst = new Program();
        for (AstNode node : ast.getBody()) {
            newAst.getBody().add(transformNode(node, newAst));
        }
        return newAst;
    }

    public static void main(String[] args) {
        // Assuming you have an AST obtained from parsing
        // AstNode ast = ... (initialize your AST here)

        Transformer transformer = new Transformer();
        AstNode transformedAst = transformer.transform(ast);

        // Print the transformed AST
        System.out.println("Transformed AST: " + transformedAst);
    }
}

class AstNode {
    private String type;
    // ... other properties and methods for AstNode
}

class Program extends AstNode {
    private List<AstNode> body = new ArrayList<>();

    public List<AstNode> getBody() {
        return body;
    }
}

class NumberLiteral extends AstNode {
    private String value;

    public NumberLiteral(String value) {
        this.type = "NumberLiteral";
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

class StringLiteral extends AstNode {
    private String value;

    public StringLiteral(String value) {
        this.type = "StringLiteral";
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

class CallExpression extends AstNode {
    private String name;
    private List<AstNode> params = new ArrayList<>();

    public CallExpression(String name) {
        this.type = "CallExpression";
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<AstNode> getParams() {
        return params;
    }
}

class ExpressionStatement extends AstNode {
    private CallExpression expression;

    public ExpressionStatement(CallExpression expression) {
        this.type = "ExpressionStatement";
        this.expression = expression;
    }

    public CallExpression getExpression() {
        return expression;
    }
}

TransformerVisitor transformerVisitor = new TransformerVisitor();
Transformer TF = new Transformer(transformerVisitor);

 */