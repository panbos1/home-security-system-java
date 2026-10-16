package csd.uoc.gr.A22;

public class NotDisarmedException extends Exception{
    public NotDisarmedException(String system_is_not_disarmed) {super("not disarmed ");}
}
