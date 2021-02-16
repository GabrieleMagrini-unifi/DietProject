package Program;

public class Frutta extends Food{

    public Frutta(String nomeAlimento,int proteins,int fats,int carbos){

        if((proteins >= 10 || proteins < 5)||(fats >= 5 || fats < 1)||(carbos >= 200 || carbos < 10)){
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