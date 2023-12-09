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

    // private String getCardTypeAndValidity(String cardNumber) {
    //     if (cardNumber == null || cardNumber.isEmpty()) {
    //         return "Invalid: empty/null card number";
    //     }

    //     if (!cardNumber.matches("\\d+")) {
    //         return "Invalid: non numeric characters";
    //     }

    //     if (cardNumber.length() > 19) {
    //         return "Invalid: more than 19 digits";
    //     }

    //     CreditCard card = CreditCardFactory.getCreditCard(cardNumber, "", ""); // Assuming expiration date and cardholder name are not needed for type determination

    //     if (card == null) {
    //         return "Invalid: not a possible card number";
    //     }

    //     boolean isValid = card.isValid();
    //     String cardType = CardValidationUtil.getCardType(card);
    //     return isValid ? cardType : "Invalid: not a possible card number";
    // }

    // private String getCardType(CreditCard card) {
    //     if (card instanceof VisaCC) {
    //         return "Visa";
    //     } else if (card instanceof MasterCC) {
    //         return "MasterCard";
    //     } else if (card instanceof AmExCC) {
    //         return "AmericanExpress";
    //     } else if (card instanceof DiscoverCC) {
    //         return "Discover";
    //     }
    //     return "Unknown";
    // }

    // Additional methods if needed...
}

