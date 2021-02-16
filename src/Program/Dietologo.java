package Program;

import java.time.Period;

public class Dietologo extends User {


    public Dietologo(String name,String  surname, String  ID, String  password){
        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.password = password;
        this.Pazienti = null;
        this.Observer = Archivio.getInstance();
        this.catalogoDiets =  catalogoDiete.getInstance();
    }

    public Paziente getPatient(String  ID){
        for (Paziente paziente : Pazienti) {
            if (paziente.getID().equals(ID)) {
                return paziente;
            }
        }
        return null;
    };

    public void addPatient(Paziente p){
        int n = 0;
        if (Pazienti != null){
            n = Pazienti.length;
        }
        Paziente[] newPazienti = new Paziente[n+1];
        if (Pazienti != null) {
            System.arraycopy(Pazienti, 0, newPazienti, 0, n);
        }
        newPazienti[n] = p;
        Pazienti = newPazienti;
        notifyObserver(p);
    };

    public Paziente[] getPazienti() {
        return Pazienti;
    }

    public void setPazienti(Paziente[] pazienti) {
        Pazienti = pazienti;
    }

    public Archivio getObserver() {
        return Observer;
    }

    public void setObserver(Archivio observer) {
        Observer = observer;
    }

    public catalogoDiete getCatalogoDiets() {
        return catalogoDiets;
    }

    public void setCatalogoDiets(catalogoDiete catalogoDiets) {
        this.catalogoDiets = catalogoDiets;
    }

    public void addObserver(Archivio archivio){
        this.Observer = archivio;
    }

    public void notifyObserver(Object o){
        Observer.update(this,o);
    }

    public void removePatient(){};

    public void addPatientPrescription(Paziente p, Period timePeriod, int pesoDesiderato){
        p.addPrescrizione(timePeriod,pesoDesiderato);
    }

    private  Paziente[] Pazienti;
    private Archivio Observer;
    private catalogoDiete catalogoDiets;

}
