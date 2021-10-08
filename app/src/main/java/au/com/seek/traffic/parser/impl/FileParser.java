package au.com.seek.traffic.parser.impl;

import au.com.seek.traffic.parser.Parser;
import au.com.seek.traffic.model.Count;
import au.com.seek.traffic.exception.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class FileParser implements Parser {
    private File source;

    public FileParser(File source) {
        this.source = source;
    }

    public Count[] parse() throws ParseException {
        List<Count> retVal = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.source))) {
            String s;
            while((s=br.readLine()) != null) {
                String[] parts = s.split(" ");
                Count c = new Count(
                    LocalDateTime.parse(parts[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    Integer.parseInt(parts[1]));
                retVal.add(c);
            }
        } catch (Exception e) {
            throw new ParseException(e);
        }
        return retVal.toArray(new Count[0]);
    }
}