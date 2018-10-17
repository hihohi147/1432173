package ca.cours5b5.hamzaouchrif.exceptions;

public class ErreurObservation extends RuntimeException {

    public ErreurObservation(Exception e){}

    public ErreurObservation(String message){super(message);}
}
