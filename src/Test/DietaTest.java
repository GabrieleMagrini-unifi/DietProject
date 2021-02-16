package Test;

import Program.Cereali;
import Program.Dieta;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DietaTest {

    private Dieta dieta;

    @Test
    @DisplayName("Manipulating the list")
    public void testAdding(){
        dieta = new Dieta();
        dieta.addFood(new Cereali("pasta",10,5,50));
        assertEquals(1,dieta.getComposizione().size(),"Adding food to the list should work");
    }


    @Test
    @DisplayName("Manipulating the calories in the wrong way")
    public void testWrongCalories() {
        dieta = new Dieta();
        dieta.addFood(new Cereali("pasta", 10, 5, 50));
        assertNotEquals(985, dieta.totCalories(), "Adding food to the list should manipulate the calories");
    }


    @Test
    @DisplayName("Manipulating the calories")
    public void testCalories(){
        dieta = new Dieta();
        dieta.addFood(new Cereali("pasta",10,5,50));
        assertEquals(1100,dieta.totCalories(),"Adding food to the list should manipulate the calories");
    }

    @Test
    @DisplayName("Manipulating the carbos")
    public void testCarbo(){
        dieta = new Dieta();
        dieta.addFood(new Cereali("pasta",10,5,50));
        assertEquals(50,dieta.totCarbos(),"Adding food to the list should manipulate the carbos totale");
    }

    @Test
    @DisplayName("Manipulating the fats")
    public void testFat(){
        dieta = new Dieta();
        dieta.addFood(new Cereali("pasta",10,5,50));
        assertEquals(5,dieta.totFats(),"Adding food to the list should manipulate the fats totale");
    }

    @Test
    @DisplayName("Manipulating the proteins")
    public void testProtein(){
        dieta = new Dieta();
        dieta.addFood(new Cereali("pasta",10,5,50));
        assertEquals(10,dieta.totProteins(),"Adding food to the list should manipulate the proteins totale");
    }



}
