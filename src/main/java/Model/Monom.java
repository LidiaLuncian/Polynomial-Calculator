package Model;

public class Monom {

    private double coeficient;
    private int putere;

    public Monom(double coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
    }

    public double getCoeficient(){
        return this.coeficient;
    }

    public void setCoeficient(double coeficient){
        this.coeficient = coeficient;
    }

    public int getPutere(){
        return this.putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }
    @Override
    public String toString() {

        if(coeficient > 0)
        {return  "+" + coeficient + "x^"
                + putere;}
        else if(coeficient<0)
        {return coeficient + "x^"
                + putere;}
        else return "";
    }
    public void adunareMonoame(Monom rez, Monom m1, Monom m2){
        rez.setCoeficient(m1.getCoeficient()+ m2.getCoeficient());
        rez.setPutere(m1.getPutere());
    }
    public void scadereMonoame(Monom rez, Monom m1, Monom m2){
        rez.setCoeficient(m1.getCoeficient()- m2.getCoeficient());
        rez.setPutere(m1.getPutere());
    }
    public void inmultireMonoame(Monom rez, Monom m1, Monom m2){
        rez.setCoeficient(m1.getCoeficient()* m2.getCoeficient());
        rez.setPutere(m1.getPutere()+m2.getPutere());
    }
    public void impartireMonoame (Monom rez, Monom m1, Monom m2 )
    {
        rez.setCoeficient(m1.getCoeficient() / m2.getCoeficient());
        rez.setPutere(m1.getPutere()- m2.getPutere());
    }
}
