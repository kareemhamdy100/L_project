import java.util.Scanner;

/**
 * Created by kareem on 10/8/2018.
 */


public class Main {

    public static void main (String [] args  ){

        Scanner m= new Scanner(System.in);
        String x = m.nextLine();

       Tokenizer t= new Tokenizer(x);
        t.scan();
        for (Token token : t.returnTokens ){

            System.out.println(token);
        }

    }
}
