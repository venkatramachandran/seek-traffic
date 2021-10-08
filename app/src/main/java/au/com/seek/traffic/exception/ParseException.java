package au.com.seek.traffic.exception;

public class ParseException extends Exception {
    private static String MSG = "Error in Parsing";
    public ParseException(Exception e) {
        super(MSG, e);
    }
}