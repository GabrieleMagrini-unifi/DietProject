package Program;

import java.time.Period;
import java.util.Arrays;

public class Paziente extends User{

    public Paziente(String name,String  surname, String  ID, String  password,boolean sesso,
                    int peso,int age){

        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.password = password;
        this.prescrizione = null;
        this.storico = new Storico();
        this.sesso = sesso;
        this.peso = peso;
        this.age = age;
        this.Observer = Archivio.getInstance();

    }


    public void addPrescrizione(Period timePeriod,int pesoDesiderato){
        Prescrizione p = new Prescrizione(this.peso,pesoDesiderato,timePeriod);
        notifyObserver(Observer);
    }




    public void addIntoStorico(){
        if(this.prescrizione != null) {
            Object[] data = {this.prescrizione.getPesoDesiderato(), this.prescrizione.getPesoRaggiunto(), this.age};
            storico.addRisultati(data);
            notifyObserver(Observer);
        }
        else {
            Object[] data = {this.peso-5, this.peso, this.age};
            storico.addRisultati(data);
            notifyObserver(Observer);
        }
    };

    public void seeStorico(){

        System.out.print(Arrays.deepToString(storico.getRisultati()));

    };

    public Dieta seeDieta(){
        return null;
    };


    public void addSgarro(){};

    //Getter and Setter



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyObserver(Observer);
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
        notifyObserver(Observer);
    }

    public Prescrizione getPrescrizione() {
        return prescrizione;
    }

    public void setPrescrizione(Prescrizione prescrizione) {
        this.prescrizione = prescrizione;
        notifyObserver(Observer);
    }

    public Storico getStorico() {
        return storico;
    }

    public void setStorico(Storico storico) {
        this.storico = storico;
        notifyObserver(Observer);
    }

    public boolean isSesso() {
        return sesso;
    }

    public void setSesso(boolean sesso) {
        this.sesso = sesso;
        notifyObserver(Observer);
    }


    public void addObserver(Archivio archivio){
        this.Observer = archivio;
    }

    public void notifyObserver(Object o){
        Observer.update(this,o);
    }

    //Attributes


    private int age;
    private int peso;
    private Prescrizione prescrizione;
    private Storico storico;
    private Archivio Observer;
    private boolean sesso;
}
