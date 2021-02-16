package Program;

import java.util.*;

public final class Archivio implements Observer{

    private Archivio(){};

    public static Archivio getInstance(){

        return Instance;

    }

    public Paziente pazienteLogin(String ID,String password){
        for(Paziente paziente : pazienti) {
            if (ID.equals(paziente.getID())) {
                if (password.equals(paziente.getPassword())) {
                    return paziente;
                } else {
                    System.out.print("Password errata!");
                }
            }
            System.out.print("Utente non trovato!");
        }
        return null;
    };


    public Dietologo dietologoLogin(String ID,String password){
        for(Dietologo dietologo : dietologhi) {
            if (ID.equals(dietologo.getID())) {
                if (password.equals(dietologo.getPassword())) {
                    return dietologo;
                } else {
                    System.out.print("Password errata!");
                }
            }
            System.out.print("Utente non trovato!");
        }
        return null;
    };

    public void addDietologhi(Dietologo d){
        for(Dietologo dietologo: dietologhi){
            if (d == dietologo){
                break;
            }
        }
        dietologhi.add(d);
    }


    public void addPazienti(Paziente p){
        for(Paziente paziente : pazienti){
            if (p == paziente){
                break;
            }
        }
        pazienti.add(p);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Dietologo) {
            for (Paziente paziente : pazienti) {
                if (arg == paziente) {
                    break;
                }
            }
            this.pazienti.add((Paziente) arg);
        }else if(o instanceof Paziente){
            for (Paziente paziente : pazienti) {
                if (((Paziente) o).ID.equals(paziente.ID)){
                    paziente = (Paziente)o;
                }
            }
        }
    }

    public List<Dietologo> getDietologhi() {
        return dietologhi;
    }

    public List<Paziente> getPazienti() {
        return pazienti;
    }

    private static final Archivio Instance = new Archivio();
    private final List<Dietologo> dietologhi = new ArrayList<>();
    private final List<Paziente> pazienti = new ArrayList<>();


}
