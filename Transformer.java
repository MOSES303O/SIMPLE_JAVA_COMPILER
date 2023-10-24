import java.util.ArrayList;
import java.util.List;

public class Transformer {
    private TransformerVisitor transformerVisitor;

    Transformer(TransformerVisitor transformerVisitor){
        this.transformerVisitor=transformerVisitor;
    }
    private AstNode transformNode(AstNode node, AstNode parent){
        TransformerVisitor.NodeTransformer transformer=transformerVisitor.Transformers.get(node.type);
        if(transformer !=null){
            return transformer.transform(node, parent);
        }
        return node;
    }
    

    private List<AstNode> transformArray(List<AstNode> array, AstNode parent){
        List<AstNode> transformedArray=new ArrayList<>();
        for(AstNode child: array){
        transformedArray.add(transformNode(child, parent));
      }
      return transformedArray;
    }
    public AstNode transform(AstNode ast){
        program newAst=new program(transformArray(ast.body, ast));
        return newAst;
    }
    public static void main(String[] args){
        Tokenize tk=new Tokenize(); 
        String input="(add 2 (subtract 4 2))";
        List<Token> tokens=tk.tokenize(input);
        for(Token token:tokens){
            System.out.print(token+";");
        }
         perser par = new perser(tokens);
        AstNode as = par.parse();
            System.out.print(as.body+":  ");
        TransformerVisitor tv = new TransformerVisitor();
        Transformer TF= new Transformer(tv);
        //AstNode TRANS=TF.transform(as);
        System.out.print(TF.transform(as));
    }
}
