package Program;

import java.time.Period;

public class Storico {

    public Storico(){
        this.risultati = new Object[3][];

    };

    public void addRisultati(Object[] data){
        for(int  i = 0; i < risultati.length;i++) {
            int n = 0;
            if (risultati[i] != null) {
                n = risultati[i].length;
            }
            Object[] newRisultato = new Object[n + 1];
            if (risultati[i] != null) {
                System.arraycopy(risultati[i], 0, newRisultato, 0, n);
            }
            newRisultato[n] = data[i];
            risultati[i] = newRisultato;
        }
    };

    //Getter and Setter


    public Object[][] getRisultati() {
        return risultati;
    }

    public void setRisultati(Object[][] risultati) {
        this.risultati = risultati;
    }

    private Object[][] risultati;

}
