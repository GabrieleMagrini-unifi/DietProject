package Program;

public class Cereali extends Food{


    public Cereali(String nomeAlimento,int proteins,int fats,int carbos){

        if((proteins >= 100 || proteins < 5)||(fats >= 50 || fats < 3)||(carbos >= 1000 || carbos < 10)){
            throw new IllegalArgumentException("Il cibo inserito non rientra nei valori limite!");
        }else{
            int calories = this.calcCalories(proteins,fats,carbos);
            this.nome = nomeAlimento;
            this.proteins = proteins;
            this.fats = fats;
            this.carbos = carbos;
            this.calories = calories;
        }

    };


}