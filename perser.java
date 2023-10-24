import java.util.ArrayList;
import java.util.List;

public class perser {
    //declaring a variable with type TOken of AND ARRAY LIST
    private List<Token> tokens;
    private int current=0;
    //creating a costructor with one parameter
     perser(List<Token> tokens){
        this.tokens=tokens;
    }
    //METHOD WALK PARAMS THAT RETURNS AN ARRAY LIST OF TYPE ASTNIDE
    private List<AstNode> walkparams(){
        //creating an array list know as params
        List<AstNode> params=new ArrayList<>();
        //looping though all the tokens
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
    //METHOD WALK THAT RETURNS AN OBJECT OF A CLASS IF IT MATCHES THE TOKEN TYPE
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
            CallExpression node=new CallExpression(token.value,   walkparams());
            node.params.addAll(walkparams());
            return node;
        }
        throw new RuntimeException("UKNOWN TOKEN TYPE:"+token.type);
    }
    //METHOD PARSE RETURNS A AN ABSTRACT SYNTACTIC TREE WHICH IS AN OBJECT OF CLASS PROGRAM
    public  AstNode parse(){
        List<AstNode> bb = walkparams();
        return new program(bb);
    }
      
   /*public static void main(String[] args){
        
        Tokenize tk=new Tokenize(); 
        String input="(add 2 (subtract 4 2))";
        List<Token> tokens=tk.tokenize(input);
        perser  par = new perser(tokens);
        AstNode as = par.parse();
            System.out.print(as.body+":  ");
       /*for(Token token:tokens){
            System.out.print(token+";");
        }*
    }*/
}
