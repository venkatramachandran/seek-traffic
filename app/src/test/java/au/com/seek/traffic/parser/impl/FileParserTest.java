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

public class FileParserTest {
    Parser p;
    @Before public void setup() {
        p = new FileParser(new File("resources/sample.txt"));
    }
    @Test public void parsesSample() {
        try {
            Count[] c = p.parse();
            assertNotNull(p);
            assertEquals(c.length, 24);
            assertEquals(c[0].getVehicleCount(), 5);
            assertEquals(c[0].getAt(), LocalDateTime.parse("2016-12-01T05:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        } catch (ParseException pe) {

        }
    }
}
