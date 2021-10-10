package au.com.seek.traffic.service;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import au.com.seek.traffic.model.Count;
import au.com.seek.traffic.parser.impl.FileParser;
import au.com.seek.traffic.service.Service;
import java.util.List;
import java.io.File;

public class ServiceTest {
    List<Count> cars;
    Service s;
    @Before public void setup() throws Exception {
        cars = new FileParser(new File("resources/sample.txt")).parse();
        s = new Service(cars);
    }

    @Test public void testgetTotalCarsSeen() {
        assertEquals(s.getTotalCarsSeen(), 397);
    }
}