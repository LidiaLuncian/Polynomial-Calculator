package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        Operatii model = new Operatii();

        View v = new View(model);
        v.setVisible(true);

        Controller controller = new Controller(v,model);


    }


}
