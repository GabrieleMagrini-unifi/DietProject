package Program;

public abstract class Food {

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbos() {
        return carbos;
    }

    public void setCarbos(int carbos) {
        this.carbos = carbos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int calcCalories(int proteins, int fats, int carbos){
        return fats*10+proteins*5+carbos*20;
    };


    String nome;
    int calories;
    int proteins;
    int fats;
    int carbos;

}
