package Program;

public class Carne extends Food{

    public Carne(String nomeAlimento,int proteins,int fats,int carbos){

        if((proteins >= 500 || proteins < 100)||(fats >= 100 || fats < 20)||(carbos >= 200 || carbos < 10)){
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
