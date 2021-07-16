package Model;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Operatii {

    private String pol1, pol2;
    private Polynom rezultat = new Polynom();
    private Polynom polinom1 = new Polynom();
    private Polynom polinom2 = new Polynom();
    Operatii(){
        reset();
    }

    private void reset() {
        pol1 = new String("");
        pol2 = new String("");
    }
    public String getPol1(){
        return pol1.toString();
    }
    public String getPol2(){
        return pol2.toString();
    }
    public String getRezultat(){
        return rezultat.toString();
    }
    public void setRezultat(){
        int i=0;
        int size = rezultat.getPolinom().size();
        while(i<size){
            rezultat.getPolinom().remove(0);
            i++;
        }
        i=0;
        size = polinom1.getPolinom().size();
        while(i<size){
            polinom1.getPolinom().remove(0);
            i++;
        }
        i=0;
        size = polinom2.getPolinom().size();
        while(i<size){
            polinom2.getPolinom().remove(0);
            i++;
        }
    }
    public void regex(Polynom inp, String input) {
        Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^?(-?\\d+\\b)");
        Matcher m = p.matcher(input);
        while (m.find()) {
            Monom mon = new Monom(Double.parseDouble(m.group(1)), Integer.parseInt(m.group(2)));
            inp.adaugaInLista(mon);
        }
    }
    public void  adunare(String pol1, String pol2) {
        regex(polinom1, pol1);
        regex(polinom2, pol2);
        int i = 0, j = 0;
        while (i < polinom1.getPolinom().size() && j < polinom2.getPolinom().size()) {
            if (polinom1.getPolinom().get(i).getPutere() > polinom2.getPolinom().get(j).getPutere()) {
                rezultat.adaugaInLista(polinom1.getPolinom().get(i));
                i++;
            }
            else if(polinom1.getPolinom().get(i).getPutere() < polinom2.getPolinom().get(j).getPutere()){
                rezultat.adaugaInLista(polinom2.getPolinom().get(j));
                j++;
            }
            else{
                Monom mon = new Monom(polinom1.getPolinom().get(i).getCoeficient() + polinom2.getPolinom().get(j).getCoeficient(), polinom1.getPolinom().get(i).getPutere());
                rezultat.adaugaInLista(mon);
                i++;
                j++;
            }
        }
        while(i < polinom1.getPolinom().size()){
            rezultat.adaugaInLista(polinom1.getPolinom().get(i));
            i++;
        }
        while(j < polinom2.getPolinom().size()){
            rezultat.adaugaInLista(polinom2.getPolinom().get(j));
            j++;
        }
    }
    public  void scadere(String pol1, String pol2) {
        regex(polinom1, pol1);
        regex(polinom2, pol2);
        int i = 0, j = 0;
        while (i < polinom1.getPolinom().size() && j < polinom2.getPolinom().size()) {
            if (polinom1.getPolinom().get(i).getPutere() > polinom2.getPolinom().get(j).getPutere()) {
                rezultat.adaugaInLista(polinom1.getPolinom().get(i));
                i++;
            }
            else if(polinom1.getPolinom().get(i).getPutere() < polinom2.getPolinom().get(j).getPutere()){
                polinom2.getPolinom().get(j).setCoeficient(-polinom2.getPolinom().get(j).getCoeficient());
                rezultat.adaugaInLista(polinom2.getPolinom().get(j));
                j++;
            }
            else{
                Monom mon = new Monom(polinom1.getPolinom().get(i).getCoeficient() - polinom2.getPolinom().get(j).getCoeficient(), polinom1.getPolinom().get(i).getPutere());
                rezultat.adaugaInLista(mon);
                i++;
                j++;
            }
        }
        while(i < polinom1.getPolinom().size()){
            rezultat.adaugaInLista(polinom1.getPolinom().get(i));
            i++;
        }
        while(j < polinom2.getPolinom().size()){
            rezultat.adaugaInLista(polinom2.getPolinom().get(j));
            j++;
        }
    }

    public void inmultire(String pol1, String pol2){
        regex(polinom1,pol1);
        regex(polinom2, pol2);

        for(Monom m:polinom1.getPolinom()){
            for(Monom m1: polinom2.getPolinom()){
                int pow = m.getPutere() + m1.getPutere();
                double coef = m.getCoeficient() * m1.getCoeficient();
                Monom m2 = new Monom(coef, pow);
                rezultat.adaugaInLista(m2);
            }
        }
        int i=0,j;
        while(i<rezultat.getPolinom().size()){
            j=i+1;
            while(j<rezultat.getPolinom().size()){
                if(rezultat.getPolinom().get(i).getPutere() == rezultat.getPolinom().get(j).getPutere()){
                    rezultat.getPolinom().get(i).setCoeficient(rezultat.getPolinom().get(i).getCoeficient() + rezultat.getPolinom().get(j).getCoeficient());
                    rezultat.getPolinom().remove(j);
                }
                else j++;
            }
            i++;
        }
    }

    public void integrare(String pol1){
        regex(polinom1, pol1);
        for(Monom m: polinom1.getPolinom()){
            int pow= m.getPutere()+1;
            double coef = m.getCoeficient()/pow;
            m.setPutere(pow);
            m.setCoeficient(coef);
            rezultat.adaugaInLista(m);
        }
    }

    public void derivare(String pol1){

        regex(polinom1,pol1);
        for(Monom m:polinom1.getPolinom()){
            double coef = m.getCoeficient()*m.getPutere();
            int pow = m.getPutere() - 1;
            m.setCoeficient(coef);
            m.setPutere(pow);
            rezultat.adaugaInLista(m);
        }
    }

    public void impartire(String pol1, String pol2){
        regex(polinom1,pol1);
        regex(polinom2,pol2);
        Polynom impartitor = new Polynom();
        Polynom deimpartit = new Polynom();
        for(Monom mm:polinom1.getPolinom()){
            deimpartit.adaugaInLista(mm);
        }
        Monom m2=polinom2.getPolinom().get(0);
        while(deimpartit.getPolinom().get(0).getPutere() > polinom2.getPolinom().get(0).getPutere()){
            for(Monom mm:polinom2.getPolinom()){
                impartitor.adaugaInLista(mm);
            }
            Monom m1=deimpartit.getPolinom().get(0);
            Monom mcat= new Monom(0,0);
            mcat.impartireMonoame(mcat,m1,m2);
            rezultat.adaugaInLista(mcat);
            int i=0;
            while(i<polinom2.getPolinom().size()){
                impartitor.getPolinom().get(i).inmultireMonoame(impartitor.getPolinom().get(i),impartitor.getPolinom().get(i), mcat);
                i++;
            }
            scadere(deimpartit.toString(),impartitor.toString());
            deimpartit.getPolinom().remove(0);
        }
        Monom mm=new Monom(0,0);
        rezultat.adaugaInLista(mm);
        for(Monom mm2:deimpartit.getPolinom()){
            rezultat.adaugaInLista(mm2);
        }
    }
}
