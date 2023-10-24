import java.util.List;
public class CodeGenerate{
    public /*static*/ String generateCode(AstNode node){
        switch(node.type){
            case "program":
            return generateprogramCode(node);
            case "ExpressionStatement":
            return generateCode(node.expression)+";";
            case "CallExpression":
            return generateCode(node.callee)+"("+generateArgumentsCode(node.arguments)+")";
            case "Identifier":
            return node.value;
            case "NumberLiteral":
            return node.value;
            case "StringLiteral":
            return "\""+node.value+"\"";
            default:
            throw new IllegalArgumentException("UNKNOWN NODE TYPE:"+node.type);

        }
    }
    private /*static*/ String generateprogramCode(AstNode node){
        StringBuilder code =new StringBuilder();
        for(AstNode statement:node.body){
            code.append(generateCode(statement)).append("\n");
        }
        return code.toString();
    }
     private /*static*/ String generateArgumentsCode(List<AstNode> arguments){
        StringBuilder code =new StringBuilder();
        for(int i=0; i<arguments.size();i++){
            code.append(generateCode(arguments.get(i)));
            if(i<arguments.size()-1){
                code.append(", ");
            }
        }
        return code.toString();
    }
   /*public static void main (String[]args){
        AstNode samples= new program(List.of(
                new ExpressionStatement(new CallExpression(new Identifier("add"), List.of(
                        new NumberLiteral("2"),
                        new CallExpression(new Identifier("subtract"), List.of(
                                new NumberLiteral("4"),
                                new NumberLiteral("2")
                        ))
                )))
        ));
        String generatedcode=generateCode(samples);
         System.out.println("Generated Code:");
        System.out.println(generatedcode);
    }*/
}