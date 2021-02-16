package Program;

import java.util.Scanner;

public class Program {
    public static void main (String[] args){

        Archivio a = Archivio.getInstance();

        Dietologo d = new Dietologo("Alessia","Verdi","001","Cane");

        Paziente p = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);

        d.addPatient(p);
        a.addDietologhi(d);
        a.addPazienti(p);
        //Ask Program.User if it access as Program.Dietologo or Program.Paziente
        p.addIntoStorico();
        p.seeStorico();

        System.out.print("Premere 'd' per accedere come Program.Dietologo, un tasto qualsisi per accedere come Program.Paziente\n");
        Scanner input = new Scanner(System.in);
        String scelta = input.nextLine();


        if(scelta.equals("d")){
            System.out.print("Si è scelto l'accesso da dietologo\n");

            System.out.print("Inserire ID utente\n");
            String ID = input.nextLine();
            System.out.print("Inserire Password utente\n");
            String password = input.nextLine();

            Dietologo d1 = a.dietologoLogin(ID, password);

            System.out.print("Benvenuto " + d1.getName() + "!\n");

            boolean programState = true;

            while(programState) {
                System.out.print("""
                        Cosa si desidera fare?
                        (Premere 'h' per mostrare i comandi)
                        """ + "\n");
                String choice = input.nextLine();
                switch (choice) {
                    case "h" -> System.out.print("""
                            0: Esci dal programma
                            1: Mostra pazienti
                            2: Seleziona paziente
                            3: Aggiungi paziente
                            """ + "\n");
                    case "0" -> programState = false;
                    case "1" -> {
                        if(d1.getPazienti() != null){
                            for(int i = 0; i<d1.getPazienti().length; i++) {
                                System.out.print(  d1.getPazienti()[i].getID() + ":" + d1.getPazienti()[i].getName() + " " + d1.getPazienti()[i].getSurname() + "\n" );
                            }
                        }else{
                            System.out.print("Nessun paziente in lista\n");
                        }
                    }
                    case "2" -> {
                        System.out.print("Inserire ID paziente:" + "\n");
                        String pazienteID = input.nextLine();
                        Paziente p1 = d1.getPatient(pazienteID);
                    }
                    case "3" -> {
                        //d1.addPatient();
                    }
                }
            }

        }else {
            Paziente p1 = a.pazienteLogin("101","Gatto");
        }
        System.out.print("A presto!");
    }
}
