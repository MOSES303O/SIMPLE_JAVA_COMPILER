import java.util.ArrayList;
import java.util.List;

public class program extends AstNode{
     List<AstNode> body;
    program(){
        this.type="program";
        this.body=new ArrayList<>();
    }
    program(List<AstNode> body) {
        this.type = "program";
        this.body = body;
    }
}
