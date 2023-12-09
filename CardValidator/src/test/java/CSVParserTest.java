import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.nio.file.*;
import static org.junit.Assert.*;

public class CSVParserTest {

    private final String outputFilePath = "resources/output_file.csv";

    @Before
    public void setUp() throws Exception {
        new FileWriter(outputFilePath).close(); // Clears the file content
    }

    @Test
    public void testCSVParserOutput() throws Exception {
        String inputFilePath = "resources/input_file.csv";
        String outputFilePath = "resources/output_file.csv";
        String expectedOutputFilePath = "resources/expected_output_file.csv";

        CSVParser parser = new CSVParser();
        parser.parseFile(inputFilePath, outputFilePath);

        String actualOutput = new String(Files.readAllBytes(Paths.get(outputFilePath)));
        String expectedOutput = new String(Files.readAllBytes(Paths.get(expectedOutputFilePath)));

        assertEquals(expectedOutput, actualOutput);
    }
}

