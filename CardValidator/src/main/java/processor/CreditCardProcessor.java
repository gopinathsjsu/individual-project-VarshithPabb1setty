package processor;
// package parser;
// import parser.*;

// import parser.FileParser;
// import parser.CSVParser;
// import parser.JSONParser;
// import parser.XMLParser;

public class CreditCardProcessor {
    public static void main(String[] args) {
        String inputFilePath = args[0];
        String outputFilePath = args[1];
        parser.FileParser parser;

        // Determine file format and select appropriate parser
        if (inputFilePath.endsWith(".csv")) {
            parser = new parser.CSVParser();
        } else if (inputFilePath.endsWith(".json")) {
            parser = new parser.JSONParser();
        } else if (inputFilePath.endsWith(".xml")) {
            parser = new parser.XMLParser();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }

        parser.parseFile(inputFilePath, outputFilePath);
    }
}
