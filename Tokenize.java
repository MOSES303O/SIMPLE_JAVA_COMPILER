import java.util.ArrayList;
import java.util.List;

public class Tokenize {
//take in a set of strings and split into tokens for beter understanding of the program through method tonenization
   public /*static*/ List<Token> tokenize(String input) {
    int current =0;
    //create object for the array list class so that you will be able to push your token in them.
    List<Token> tokens=new ArrayList<>();
    //loop through the input string to idetify the context of the input string array.
    while(current<input.length()){
        //getting the current index in the input array string.
        char character=input.charAt(current);
        if(character=='('){
            //checking left parenthesis
            tokens.add(new Token("paren","("));
            //continue checking through the input string
            current++;
            continue;
        }
        if(character==')'){
            //checking  right parenthesis
            tokens.add(new Token("paren", ")"));
             //continue checking through the input string
            current++;
            continue;
        }
        if(Character.isWhitespace(character)){
            //checking for spaces within the input string
             //continue checking through the input string
            current++;
            continue;
        }
        if(Character.isDigit(character)){
            //thecking for numeric entry in the input string
            StringBuilder value=new StringBuilder();
            //Sometimes u might enter a number with more than one digit so its wise to loop through the number
            while(Character.isDigit(character)){
                value.append(character);
                character=input.charAt(++current);
            }
            tokens.add(new Token("number", value.toString()));
            continue;
        }
        if(character=='"'){
            //checking for quotation marks within the input string
            StringBuilder value=new StringBuilder();
             character =input.charAt(++current);
             //for the first opening parenth loop throught the input string to identify the second parenth to match the second
             while(character != '"'){
                value.append(character);
                character=input.charAt(++current);
             }character=input.charAt(++current);
             tokens.add(new Token("string",value.toString()));
             continue;
        }
        if(Character.isLetter(character)){
            StringBuilder value=new StringBuilder();
            //loop through the input string since aword most of the time is made up of more than one letter
            while(Character.isLetterOrDigit(character)){
                value.append(character);
                character=input.charAt(++current);
            }
            tokens.add(new Token("name",value.toString()));
            continue;
        }
        throw new   RuntimeException("unknown character changamka broo kwa:"+character);
    }
    //return an object f the array class after operating in it.
    return tokens;
   }
  /*public static void main(String[] args){
    String input="(add (())2 (subtract 4 2))";
    //creating an object of a class
    List<Token> tokens= tokenize(input);
    for(Token token:tokens){
        System.out.print("{ type: '" + token.type + "', value: '" + token.value + "' }");
    }
   } */ 
}
