public class NumberLiteral extends AstNode {
    String value;
    NumberLiteral(String value){
        this.type="NumberLiteral";
        this.value=value;
    }
}
