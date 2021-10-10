package au.com.seek.traffic.parser;
import au.com.seek.traffic.model.Count;
import au.com.seek.traffic.exception.ParseException;
import java.util.List;

public interface Parser {
   List<Count> parse() throws ParseException;
}