package Program;

import java.time.Period;
import java.util.Observable;

public class Prescrizione extends Observable {

    public Prescrizione(int pesoIniziale,int pesoDesiderato, Period periodo){
        this.pesoIniziale = pesoIniziale;
        this.pesoDesiderato = pesoDesiderato;
        this.pesoDesiderato = pesoIniziale;
        this.catalogoDiets =  catalogoDiete.getInstance();
        this.dieta = dietaCreator(pesoIniziale,pesoDesiderato);
    };

    public void addDieta(){};

    public Dieta dietaCreator(int pesoIniziale,int pesoDesiderato){
        int calorieTot = 0;
        Dieta dieta = new Dieta();
        int caloriesScope = 2000-(Math.abs(pesoDesiderato-pesoIniziale)*50);
        while(calorieTot < caloriesScope){
            if(calorieTot < caloriesScope%2){
                dieta.addFood(new Cereali("pasta",10,5,50));
            }else if(calorieTot < caloriesScope%4) {
                dieta.addFood(new Carne("pollo",120,30,20));
            }else{
                dieta.addFood(new Verdura("Insalata",10,2,30));
            }
            calorieTot = dieta.totCalories();
        }
        notifyObservers(dieta);
        return dieta;
    };


    //Getter and Setter


    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public int getPesoIniziale() {
        return pesoIniziale;
    }

    public void setPesoIniziale(int pesoIniziale) {
        this.pesoIniziale = pesoIniziale;
    }

    public int getPesoDesiderato() {
        return pesoDesiderato;
    }

    public void setPesoDesiderato(int pesoDesiderato) {
        this.pesoDesiderato = pesoDesiderato;
    }

    public int getPesoRaggiunto() {
        return pesoRaggiunto;
    }

    public void setPesoRaggiunto(int pesoRaggiunto) {
        this.pesoRaggiunto = pesoRaggiunto;
    }

    public catalogoDiete getCatalogoDiets() {
        return catalogoDiets;
    }

    public void setCatalogoDiets(catalogoDiete catalogoDiets) {
        this.catalogoDiets = catalogoDiets;
    }


    private Dieta dieta;
    private catalogoDiete catalogoDiets;
    private int pesoIniziale;
    private int pesoDesiderato;
    private int pesoRaggiunto;

}
