package au.com.seek.traffic.parser;
import au.com.seek.traffic.model.Count;
import au.com.seek.traffic.exception.ParseException;

public interface Parser {
   Count[] parse() throws ParseException;
}