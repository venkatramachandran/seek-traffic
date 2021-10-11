/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package au.com.seek.traffic;

import au.com.seek.traffic.parser.Parser;
import au.com.seek.traffic.model.Count;
import au.com.seek.traffic.service.Service;
import au.com.seek.traffic.parser.impl.FileParser;
import au.com.seek.traffic.exception.ParseException;
import java.util.List;
import java.io.File;

public class App {

    public static void main(String[] args) {
        String path = "";
        if (args.length == 1) {
            path = args[0];
        } else {
            System.err.println("Need path of input file as param");
            System.exit(1);
        }
        try {
            List<Count> cars = new FileParser(new File(path)).parse();
            Service s = new Service(cars);
            System.out.println(s.getTotalCarsSeen());
            s.getDailyStatistics().stream().forEach(System.out::println);
            System.out.println("Least amount of cars seen in 90 minutes is in the period starting "+s.getLeastTrafficHoursStart());
        } catch(ParseException e) {
            System.out.println("caught error: "+e.getCause().getMessage());
        }
    }
}
