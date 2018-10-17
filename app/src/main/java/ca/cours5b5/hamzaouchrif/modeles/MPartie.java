package ca.cours5b5.hamzaouchrif.modeles;

import java.util.Map;

import ca.cours5b5.hamzaouchrif.exceptions.ErreurSerialisation;
import ca.cours5b5.hamzaouchrif.serialisation.AttributSerialisable;

public class MPartie extends Modele {

    @AttributSerialisable
    public MParametresPartie paramtres;
    private final String __paramtres = "paramtres";

    public MPartie (MParametresPartie paramtres){
        this.paramtres = paramtres;

    }

    public MParametresPartie getParamtres() {
        return paramtres;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        return null;
    }
}
