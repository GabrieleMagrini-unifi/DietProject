package Test;

import Program.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PazienteTest {

    private Paziente paziente;

    @Test
    @DisplayName("Patient trying to LogIn")
    public void testLogIn(){
        Archivio archivio = Archivio.getInstance();
        archivio.getPazienti().clear();
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        archivio.addPazienti(p);
        Paziente p1 = archivio.pazienteLogin("101","Gatto");
        assertEquals(p1,p,"Paient should be able to Log In the program");
    }

    @Test
    @DisplayName("Patient updating the storico")
    public void testPatientStorico(){
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        p.addIntoStorico();
        Storico s = p.getStorico();
        Object[] o = {60, 65, 21};
        assertEquals(s.getRisultati()[0][0],o[0],"Patient should be able to update the storico");
        assertEquals(s.getRisultati()[1][0],o[1]);
        assertEquals(s.getRisultati()[2][0],o[2]);
    }

    @Test
    @DisplayName("Patient updating the storico with multiple values")
    public void testPatientUpdateStorico(){
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        p.addIntoStorico();
        p.setPeso(60);
        p.setAge(22);
        p.addIntoStorico();
        Storico s = p.getStorico();
        Object[] o = {60,65,21};
        Object[] o2 = {55,60,22};
        assertEquals(s.getRisultati()[0][0],o[0],"Patient should be able to update the storico multiple times");
        assertEquals(s.getRisultati()[1][0],o[1]);
        assertEquals(s.getRisultati()[2][0],o[2]);
        //Cycling through the second results
        assertEquals(s.getRisultati()[0][1],o2[0],"Patient should be able to update the storico multiple times");
        assertEquals(s.getRisultati()[1][1],o2[1]);
        assertEquals(s.getRisultati()[2][1],o2[2]);

    }



}
