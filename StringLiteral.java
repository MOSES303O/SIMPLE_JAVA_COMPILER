public class StringLiteral extends AstNode {
    String value;
    StringLiteral(String value){
        this.type="StringLiterals";
        this.value=value;
    }
}
