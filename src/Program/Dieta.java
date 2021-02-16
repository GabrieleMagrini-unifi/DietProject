package Program;

import java.util.ArrayList;
import java.util.List;

public class Dieta {

    public Dieta(){
        this.composizione = new ArrayList<Food>();
    };

    public void addFood(Food cibo){

        composizione.add(cibo);
    };

    public int totProteins(){

        int totProt = 0;
        for(Food cibi:composizione){
            totProt += cibi.getProteins();
        }
        return totProt;
    };

    public int totFats(){

        int totFats = 0;
        for(Food cibi:composizione){
            totFats += cibi.getFats();
        }
        return totFats;
    };

    public int totCarbos(){

        int totCarbos = 0;
        for(Food cibi:composizione){
            totCarbos += cibi.getCarbos();
        }
        return totCarbos;
    };

    public int totCalories(){

        int totCalories = 0;
        for(Food cibi:composizione){
            totCalories += cibi.getCalories();
        }
        return totCalories;
    };

    public List<Food> getComposizione() {
        return composizione;
    };

    public void setComposizione(List<Food> composizione) {
        this.composizione = composizione;
    };

    private List<Food> composizione;

}
