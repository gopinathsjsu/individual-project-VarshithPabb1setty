import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.nio.file.*;
import static org.junit.Assert.*;

public class XMLParserTest {

    private final String outputFilePath = "resources/output_file.xml";

    @Before
    public void setUp() throws Exception {
        new FileWriter(outputFilePath).close(); // Clears the file content
    }

    private String normalizeXMLContent(String content) {
        return content.replace("\r\n", "\n").replaceAll(">\\s+<", "><").trim();
    }

    @Test
    public void testXMLParserOutput() throws Exception {
        String inputFilePath = "resources/input_file.xml";
        String outputFilePath = "resources/output_file.xml";
        String expectedOutputFilePath = "resources/expected_output_file.xml";

        XMLParser parser = new XMLParser();
        parser.parseFile(inputFilePath, outputFilePath);

        String actualOutput = normalizeXMLContent(new String(Files.readAllBytes(Paths.get(outputFilePath))));
        String expectedOutput = normalizeXMLContent(new String(Files.readAllBytes(Paths.get(expectedOutputFilePath))));

        assertEquals(expectedOutput, actualOutput);
    }
}

