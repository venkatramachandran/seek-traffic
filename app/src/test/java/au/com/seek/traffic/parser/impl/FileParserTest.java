package au.com.seek.traffic.parser.impl;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.File;
import au.com.seek.traffic.parser.Parser;
import au.com.seek.traffic.model.Count;
import au.com.seek.traffic.parser.impl.FileParser;
import au.com.seek.traffic.exception.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;

public class FileParserTest {
    Parser p;
    @Before public void setup() {
        p = new FileParser(new File("src/test/resources/sample.txt"));
    }
    @Test public void parsesSample() {
        try {
            List<Count> c = p.parse();
            assertNotNull(p);
            assertEquals(c.size(), 24);
            assertEquals(c.get(0).getVehicleCount(), 5);
            assertEquals(c.get(0).getAt(), LocalDateTime.parse("2016-12-01T05:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            assertEquals(c.get(0).toString(), "2016-12-01T05:00:00 5");
        } catch (ParseException pe) {

        }
    }
    @Test public void testThrowsException() {
        Exception e = assertThrows(ParseException.class, () -> {
            new FileParser(new File("src/test/resources/nonexistent.txt")).parse();
        });
    }
}
