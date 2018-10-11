/**
 * Created by kareem on 10/8/2018.
 */

public  class Token {
    private  String type , value;


    public  Token(String type ,String value ){
        this.type = type;
        this.value = value ;
    }

    @Override
    public String toString() {
        return  String.format("Token(%s , %s)",this.type,this.value) ;
    }
}