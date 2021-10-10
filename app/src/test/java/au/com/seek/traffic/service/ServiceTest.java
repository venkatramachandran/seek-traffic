package au.com.seek.traffic.service;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import au.com.seek.traffic.model.Count;
import au.com.seek.traffic.parser.Parser;
import au.com.seek.traffic.parser.impl.FileParser;
import au.com.seek.traffic.service.Service;
import java.util.List;
import java.io.File;

public class ServiceTest {
    Parser p;
    Service s;
    @Before public void setup() throws Exception {
        p = new FileParser(new File("src/test/resources/sample.txt"));
        List<Count> cars = p.parse();
        s = new Service(cars);
    }

    @Test public void testgetTotalCarsSeen() {
        assertEquals(s.getTotalCarsSeen(), 398);
    }

    @Test public void testgetTopNHours() {
        int periods = 3;
        List<Count> c = s.getTopNHours(periods);
        assertEquals(c.size(), periods);
    }

    @Test public void testgetTopNHours2() {
        int periods = 4;
        List<Count> c = s.getTopNHours(periods);
        assertEquals(c.size(), periods);
        assertEquals(c.get(0).getVehicleCount(), 46);
    }
}