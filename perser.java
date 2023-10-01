import java.util.ArrayList;
import java.util.List;

public class perser {
    //using a list of arrays
    private List<Token> tokens;
    private int current=0;
    //creating a costructor with one parameter
     perser(List<Token> tokens){
        this.tokens=tokens;
    }
    
    private List<AstNode> walkparams(){
        List<AstNode> params=new ArrayList<>();
        while(current<tokens.size()){
            Token token=tokens.get(current);
            if(token.type.equals("paren") && token.value.equals(")")){
                current++;
                break;
            }
            params.add(walk());
        }
        return params;
    }
    private  AstNode walk(){
        Token token=tokens.get(current);
        if(token.type.equals("number")){
            current++;
            return new NumberLiteral(token.value);
        }
        if(token.type.equals("string")){
            current++;
            return new StringLiteral(token.value);
        }
        if (token.type.equals("name")) {
        current++;
        return new Identifier(token.value);
       } 
        if(token.type.equals("paren") && token.value.equals("(")){
            token=tokens.get(++current);
            CallExpression node=new CallExpression(token.value, null);
            node.params=walkparams();
            return node;
        }
        throw new RuntimeException("UKNOWN TOKEN TYPE:"+token.type);
    }
    
    public  AstNode parse(){
        AstNode ast= new AstNode();
        ast.type="program";
        ast.body=walkparams();
        return ast;
    }
    public static void main(String[] args){
        Tokenize tk=new Tokenize(); 
        String input="(add 2 (subtract 4 2))";
        List<Token> tokens=tk.tokenize(input);
        perser par = new perser(tokens);
        AstNode ast = par.parse();
         System.out.print(ast);
        /*for(Token token:tokens){
            String ps=token.type+token.value;
            List<Token> par = new perser(ps);
            AstNode ast = par.parse();  
            System.out.print(ast);    
           // System.out.print("{ type: '" + token.type + "', value: '" + token.value + "' }");
        }*/
         //System.out.print(ast);
         //System.out.print(ast);
    }
}
