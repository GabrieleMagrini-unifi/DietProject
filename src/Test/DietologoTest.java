package Test;

import Program.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DietologoTest {

    private Dietologo dietologo;

    @Test
    @DisplayName("Manipulating the dietist's patient list")
    public void addPatientTest(){
       dietologo = new Dietologo("Alessia","Verdi","001","Cane");
       Archivio archivio = Archivio.getInstance();
       archivio.getPazienti().clear();
       dietologo.addObserver(archivio);
       Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
       dietologo.addPatient(p);
       assertEquals(p,dietologo.getPatient("101"),"Adding a patient should work");
    }

    @Test
    @DisplayName("Manipulating the dietist's patient list")
    public void addMultiplePatientTest(){
        dietologo = new Dietologo("Alessia","Verdi","001","Cane");
        Archivio archivio = Archivio.getInstance();
        archivio.getPazienti().clear();
        dietologo.addObserver(archivio);
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        Paziente p2  = new Paziente("Gianni","Rossi","102","Micio",false,67,22);
        dietologo.addPatient(p);
        dietologo.addPatient(p2);
        assertNotEquals(dietologo.getPatient("102"),dietologo.getPatient("101"),"Adding a patient should work");
    }


    @Test
    @DisplayName("Manipulating the dietist's list and checking the archive")
    public void addPatientObserver(){
        dietologo = new Dietologo("Alessia","Verdi","001","Cane");
        Archivio archivio = Archivio.getInstance();
        dietologo.addObserver(archivio);
        archivio.getPazienti().clear();
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        dietologo.addPatient(p);
        assertEquals(p,archivio.pazienteLogin("101","Gatto"),"Adding a patient should make observer work");
    }

    @Test
    @DisplayName("Adding precription to a patient")
    public void addPatientPrescription(){
        dietologo = new Dietologo("Alessia","Verdi","001","Cane");
        Archivio archivio = Archivio.getInstance();
        archivio.getPazienti().clear();
        dietologo.addObserver(archivio);
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        dietologo.addPatient(p);
        Dietologo dietologo2 = new Dietologo("Riccardo","Cattivo","002","Lupo");
        dietologo2.addObserver(archivio);
        dietologo2.addPatient(p);
        Period period = Period.of(0,1,0);
        dietologo2.addPatientPrescription(p,period,p.getPeso()-5);
        Prescrizione p2 = dietologo2.getPatient("101").getPrescrizione();
        Prescrizione p1 = dietologo.getPatient("101").getPrescrizione();
        assertEquals(p1,p2,"Adding a prescription to a patient should work whoever the dietist is");
    }


}
