package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class catalogoDiete implements Observer {

    private catalogoDiete(){};

    public static  catalogoDiete getInstance(){

        return Instance;

    }

    public void addDieta(Dieta d){
        for(Dieta dieta: diete){
            if (d == dieta){
                break;
            }
        }
        diete.add(d);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.addDieta((Dieta) arg);
    }


    private static final catalogoDiete Instance = new catalogoDiete();
    private final List<Dieta> diete = new ArrayList<>();
}
