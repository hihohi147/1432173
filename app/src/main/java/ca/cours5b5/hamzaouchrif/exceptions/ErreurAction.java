package ca.cours5b5.hamzaouchrif.exceptions;

public class ErreurAction extends RuntimeException {

    public ErreurAction(Exception e){}

    public ErreurAction(String message){super(message);}
}