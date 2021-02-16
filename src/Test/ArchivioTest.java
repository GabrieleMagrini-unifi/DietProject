package Test;

import Program.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ArchivioTest {

    private Archivio archivio;


    @Test
    @DisplayName("Manipulating the archive's list")
    public void testLogInDietologo(){
        archivio = Archivio.getInstance();
        archivio.getDietologhi().clear();
        Dietologo d  = new Dietologo("Alessia","Verdi","001","Cane");
        archivio.addDietologhi(d);
        assertEquals(d,archivio.dietologoLogin("001","Cane"),"Adding dietologo to the archive should work");
    }

    @Test
    @DisplayName("Manipulating the archive's list")
    public void testAddDietologo(){
        archivio = Archivio.getInstance();
        archivio.getDietologhi().clear();
        Dietologo d  = new Dietologo("Alessia","Verdi","001","Cane");
        archivio.addDietologhi(d);
        assertEquals(1,archivio.getDietologhi().size(),"Adding dietologo to the archive should work");
    }

    @Test
    @DisplayName("Manipulating the archive's list")
    public void testLogInPaziente(){
        archivio = Archivio.getInstance();
        archivio.getPazienti().clear();
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        archivio.addPazienti(p);
        assertEquals(p,archivio.pazienteLogin("101","Gatto"),"Adding paziente to the archive should work");
    }

    @Test
    @DisplayName("Manipulating the archive's list")
    public void testAddPaziente(){
        archivio = Archivio.getInstance();
        archivio.getPazienti().clear();
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        archivio.addPazienti(p);
        assertEquals(1,archivio.getPazienti().size(),"Adding pazienti to the archive should work");
    }

    @Test
    @DisplayName("Manipulating the archive's list")
    public void testWrongLogInDietologo(){
        archivio = Archivio.getInstance();
        archivio.getDietologhi().clear();
        Dietologo d  = new Dietologo("Alessia","Verdi","001","Cane");
        archivio.addDietologhi(d);
        assertNotEquals(d,archivio.dietologoLogin("002","Cane"),"Adding dietologo to the archive should work");
    }

    @Test
    @DisplayName("Manipulating the archive's list")
    public void testDietologoAddPatient(){
        archivio = Archivio.getInstance();
        archivio.getDietologhi().clear();
        Dietologo d  = new Dietologo("Alessia","Verdi","001","Cane");
        archivio.addDietologhi(d);
        d.setObserver(archivio);
        Paziente p  = new Paziente("Gianni","Rossi","101","Gatto",false,65,21);
        d.addPatient(p);
        assertEquals(p,archivio.pazienteLogin("101","Gatto"),"Adding paziente through to the archive should work");
    }
}
