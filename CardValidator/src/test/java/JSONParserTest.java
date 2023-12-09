import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.nio.file.*;
import static org.junit.Assert.*;

public class JSONParserTest {

    private final String outputFilePath = "resources/output_file.json";

    @Before
    public void setUp() throws Exception {
        new FileWriter(outputFilePath).close(); // Clears the file content
    }

    private String normalizeWhitespace(String content) {
        return content.replaceAll("\\s+", "").trim();
    }

    @Test
    public void testJSONParserOutput() throws Exception {
        String inputFilePath = "resources/input_file.json";
        String outputFilePath = "resources/output_file.json";
        String expectedOutputFilePath = "resources/expected_output_file.json";

        JSONParser parser = new JSONParser();
        parser.parseFile(inputFilePath, outputFilePath);

        String actualOutput = new String(Files.readAllBytes(Paths.get(outputFilePath)));
        String expectedOutput = new String(Files.readAllBytes(Paths.get(expectedOutputFilePath)));

        assertEquals(normalizeWhitespace(expectedOutput), normalizeWhitespace(actualOutput));
    }
}

