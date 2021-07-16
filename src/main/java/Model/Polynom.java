package Model;

import java.util.ArrayList;
import java.util.List;

public class Polynom{

    private ArrayList<Monom> polinom;

    public Polynom()
    {
        polinom=new ArrayList<Monom>();

    }

    public List<Monom> getPolinom()
    {
        return polinom;
    }

    public void adaugaInLista(Monom monom){
        polinom.add(monom);
    }

    @Override
    public String toString() {
        String rez = new String(" ");
        for(Monom m: polinom)
        {
            rez = rez + m.toString();
        }
        return rez;
    }

}
