package csd.uoc.gr.A22;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String wrong_password) {super("Oops wrong password");}
}
