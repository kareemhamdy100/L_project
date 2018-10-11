import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kareem on 10/8/2018.
 */


public class Tokenizer {

   public List<Token> returnTokens;
    HashMap<Character, Token> charTokens;
    HashMap<String, Token> keyWords;

    String source;
    Token current_token;
    int pos;

    public Tokenizer(String source) {
        this.source = source;
        pos = 0;
        current_token = null;
        returnTokens = new ArrayList<Token>();
        initcharTokens();
     intiKeyWords ();
    }

    private void initcharTokens() {
        charTokens = new HashMap<Character, Token>();
      charTokens.put('~', new Token(  "Tilde","~" ));
      charTokens.put('!', new Token(  "Exclamation mark","!" ));
      charTokens.put('#', new Token(  "Number sign","#" ));
      charTokens.put('$',new Token(  "Dollar sig","$"));
      charTokens.put('%', new Token(  "Percent sign","%" ));
      charTokens.put('^', new Token(  "Caret","^" ));
      charTokens.put('&', new Token(  "Ampersand","&" ));
      charTokens.put('*', new Token(  "Asterisk","*" ));
      charTokens.put('(', new Token(  "Left parenthesis","(" ));
      charTokens.put(')',new Token(   "Right parenthesis",")"));
      charTokens.put('_',new Token(   "Underscor","_"));
      charTokens.put('+', new Token(  "Plus sign","+" ));
      charTokens.put('|', new Token(  "Vertical bar","|" ));
      charTokens.put('\\',new Token("Backslas","\\"));
      charTokens.put('`',	new Token(  "Apostrophe","`"	));
      charTokens.put('–', new Token(  "Minus sign","–" ));
      charTokens.put('=', new Token(  "Equal to sign","=" ));
      charTokens.put('{', new Token(  "Left brace","{" ));
      charTokens.put('}',new Token(   "Right brace","}"));
      charTokens.put('[' , new Token(  "Left bracket","[" ));
      charTokens.put(']',new Token("Right bracke","]"));
      charTokens.put(':', new Token(  "Colon",":" ));
//      charTokens.put('"', new Token("Quotation mark","\"" ));
      charTokens.put(';',new Token( "Semicolon",";"));
      charTokens.put('<', new Token(  "Opening angle bracket","<" ));
      charTokens.put('>', new Token(  "Closing angle bracket",">" ));
      charTokens.put('?', new Token(  "Question mark","?" ));
      charTokens.put(',',new Token(  "Comma",","));
      charTokens.put('.', new Token(  "Period","." ));
      charTokens.put('/', new Token( "Slash","/" ));
    }
private void intiKeyWords (){
    keyWords = new HashMap<String, Token>();
   keyWords.put( "auto",new Token("auto",null));
   keyWords.put( "double",new Token("double",null));
   keyWords.put( "int",new Token("int",null));
   keyWords.put( "struct",new Token("struct",null));
   keyWords.put( "break",new Token("break",null));
   keyWords.put( "else",new Token("else",null));
   keyWords.put( "long",new Token("long",null));
   keyWords.put( "switch",new Token("switch",null));
   keyWords.put( "case",new Token("case",null));
   keyWords.put( "enum",new Token("enum",null));
   keyWords.put( "register",new Token("register",null));
   keyWords.put( "typedef",new Token("typedef",null));
   keyWords.put( "char",new Token("char",null));
   keyWords.put( "extern",new Token("extern",null));
   keyWords.put( "return",new Token("return",null));
   keyWords.put( "union",new Token("union",null));
   keyWords.put( "const",new Token("const",null));
   keyWords.put( "float",new Token("float",null));
   keyWords.put( "short",new Token("short",null));
   keyWords.put( "unsigned",new Token("unsigned",null));
   keyWords.put( "continue",new Token("continue",null));
   keyWords.put( "for",new Token("for",null));
   keyWords.put( "signed",new Token("signed",null));
   keyWords.put( "void",new Token("void",null));
   keyWords.put( "default",new Token("default",null));
   keyWords.put( "goto",new Token("goto",null));
   keyWords.put( "sizeof",new Token("sizeof",null));
   keyWords.put( "volatile",new Token("volatile",null));
   keyWords.put( "do",new Token("do",null));
   keyWords.put( "if",new Token("if",null));
   keyWords.put( "static",new Token("static",null));
   keyWords.put( "while",new Token("while",null));

}

    public void scan() {
        int start_po = 0;
        int end_po =0;
        for (int i = 0; i < source.length(); i++) {
            char current = source.charAt(i);
            if(current==' '){
                if(end_po <= start_po){
                    start_po= i+1;
                }else {
                    end_po=i;
                    Token newToken= checkTypeOFToken(source.substring(start_po,end_po));
                    returnTokens.add(newToken);
                    start_po=i+1;
                }
            }

        else if (charTokens.keySet().contains(current)){
              if(end_po> start_po) {
                  end_po = i;
                  returnTokens.add(checkTypeOFToken(source.substring(start_po,end_po)));
              }
                returnTokens.add(charTokens.get(current));
                start_po = i + 1;
            }else if (current == '"'){

              int end_string=  source.indexOf('"',i+1)+1;
              Token string_token= new Token("String",source.substring(i,end_string));
                returnTokens.add(string_token);
                i=end_string;
                start_po=end_string;
            }

            else {end_po=i+1;}

            if(i== source.length()-1){
                if(end_po> start_po)
                returnTokens.add(checkTypeOFToken(source.substring(start_po,end_po)));
                returnTokens.add(new Token("EOF",null));
            }

        }


    }
    private  Token checkTypeOFToken(String tokenString ){
        if(Character.isDigit(tokenString.charAt(0))){
            for (int i=0;i<tokenString.length();i++ ) {
                if(!Character.isDigit(tokenString.charAt(i))){
                    throw new Error();
                }
            }
         return new Token("constant",tokenString);
        }else if(keyWords.keySet().contains(tokenString)) {
            return keyWords.get(tokenString);
        }
        else {
            return  new Token("Identifier",tokenString);
        }

    }
}
hello Wrold 
