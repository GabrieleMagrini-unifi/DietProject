package Program;

public class Derivati extends Food{

    public Derivati(String nomeAlimento,int proteins,int fats,int carbos){

        if((proteins >= 150 || proteins < 25)||(fats >= 200 || fats < 10)||(carbos >= 150 || carbos < 10)){
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