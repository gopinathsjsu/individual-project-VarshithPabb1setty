public class CreditCardProcessor {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java CreditCardProcessor <input file path> <output file path>");
            System.exit(1);
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];
        FileParser parser;

        // Determine file format and select appropriate parser
        if (inputFilePath.endsWith(".csv")) {
            parser = new CSVParser();
        } else if (inputFilePath.endsWith(".json")) {
            parser = new JSONParser();
        } else if (inputFilePath.endsWith(".xml")) {
            parser = new XMLParser();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }

        parser.parseFile(inputFilePath, outputFilePath);
    }
}
