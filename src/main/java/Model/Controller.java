package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private Operatii o_op;
    private View v_v;
    Controller(View v, Operatii op){

        o_op=op;
        v_v=v;
        v.adunareListener(new SumaListener());
        v.scadereListener(new DifListener());
        v.derivareListener(new DerivListener());
        v.integrareListener(new IntegListener());
        v.inmultireListener(new InmListener());
        v.impartireListener(new ImpartListener());

    }

    class SumaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String pol1 ="", pol2="";

            o_op.setRezultat();
            pol1=v_v.getPol1Input();
            pol2= v_v.getPol2Input();
            if(pol1.equals("") && pol2.equals("")){
                v_v.setRezultat("Nu ati introdus polinoamele");
            }else {
                o_op.adunare(pol1, pol2);
                v_v.setRezultat(o_op.getRezultat());
            }

        }
    }

    class DifListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String pol1 ="", pol2="";

            o_op.setRezultat();
            pol1=v_v.getPol1Input();
            pol2= v_v.getPol2Input();
            if(pol1.equals("") && pol2.equals("")){
                v_v.setRezultat("Nu ati introdus polinoamele");
            }else {
                o_op.scadere(pol1, pol2);
                v_v.setRezultat(o_op.getRezultat());
            }


        }
    }
    class DerivListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String pol1 ="", pol2="";

            o_op.setRezultat();
            pol1=v_v.getPol1Input();
            pol2= v_v.getPol2Input();
            if(!pol1.equals("")){
                o_op.derivare(pol1);
                v_v.setRezultat(o_op.getRezultat());
            }
            else if(!pol2.equals("")){
                o_op.derivare(pol2);
                v_v.setRezultat(o_op.getRezultat());
            }
            else{
                v_v.setRezultat("Nu ati introdus niciun polinom");
            }

        }
    }

    class IntegListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String pol1 ="", pol2="";

            o_op.setRezultat();
            pol1=v_v.getPol1Input();
            pol2= v_v.getPol2Input();
            if(!pol1.equals("")){
                o_op.integrare(pol1);
                v_v.setRezultat(o_op.getRezultat());}
            else if(!pol2.equals("")){
                o_op.integrare(pol2);
                v_v.setRezultat(o_op.getRezultat());

            }
            else{
                v_v.setRezultat("Nu ati introdus niciun polinom");
            }

        }
    }

    class InmListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String pol1 ="", pol2="";

            o_op.setRezultat();
            pol1=v_v.getPol1Input();
            pol2= v_v.getPol2Input();
            if(!pol1.equals("") && !pol2.equals("")) {
                o_op.inmultire(pol1, pol2);
                v_v.setRezultat(o_op.getRezultat());
            }
            else if(pol2.equals("")){
                o_op.inmultire(pol1, "0x^0");
                v_v.setRezultat(o_op.getRezultat());}
            else{
                v_v.setRezultat("Nu ati introdus polinoamele");
            }

        }
    }

    class ImpartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String pol1 ="", pol2="";

            o_op.setRezultat();
            pol1=v_v.getPol1Input();
            pol2= v_v.getPol2Input();
            if(!pol1.equals("") && !pol2.equals("")) {
                o_op.impartire(pol1, pol2);
                v_v.setRezultat(o_op.getRezultat());
            }
            else {
                v_v.setRezultat("Nu ati introdus polinoamele");
            }

        }
    }
}
