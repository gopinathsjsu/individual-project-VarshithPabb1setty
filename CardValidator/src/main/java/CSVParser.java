import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class CSVParser implements FileParser {

    @Override
    public void parseFile(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath))) {

            // Write the header
            writer.write("cardNumber,cardType");
            writer.newLine();

            // Skip the header in the input file if it exists
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String cardNumber = data.length > 0 ? data[0] : "";

                String cardType = CardValidationUtil.getCardTypeAndValidity(cardNumber);

                StringJoiner joiner = new StringJoiner(",");
                joiner.add(cardNumber).add(cardType);
                writer.write(joiner.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

