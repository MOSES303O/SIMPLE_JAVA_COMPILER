class ExpressionStatement extends AstNode{
    AstNode expression;
    ExpressionStatement(AstNode expression){
        this.type="ExpressionStatement";
        this.expression=expression;
    }

}