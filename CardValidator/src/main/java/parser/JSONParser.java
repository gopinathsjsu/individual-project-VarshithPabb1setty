package parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import factory.CreditCardFactory;
import model.AmExCC;
import model.CardRecords;
import model.CreditCard;
import model.DiscoverCC;
import model.MasterCC;
import model.VisaCC;

import java.io.File;
import java.io.IOException;

public class JSONParser implements FileParser {

    @Override
    public void parseFile(String inputFilePath, String outputFilePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON file and map/convert to Java objects
            CardRecords records = mapper.readValue(new File(inputFilePath), CardRecords.class);

            // Process each card record (example: printing out)
            for (CardRecords.CardRecord record : records.getCards()) {
            // Create credit card instance using the factory
            CreditCard card = CreditCardFactory.getCreditCard(record.getCardNumber(), 
                                                              record.getExpirationDate(), 
                                                              record.getCardHolderName());

            if (card != null) {
                // Validate the credit card
                boolean isValid = card.isValid();

                // Determine card type and process accordingly
                String cardType = getCardType(card);
                System.out.println("Card Number: " + record.getCardNumber() + 
                                   ", Valid: " + isValid + 
                                   ", Card Type: " + cardType);

                // Implement logic to write processed data to outputFilePath
                // You may want to store these details in a collection or write directly to a file
            } else {
                System.out.println("Card Number: " + record.getCardNumber() + 
                                   ", Invalid card type");
            }
        }



            // You would also implement logic to write processed data to outputFilePath
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getCardType(CreditCard card) {
        if (card instanceof VisaCC) {
            return "Visa";
        } else if (card instanceof MasterCC) {
            return "MasterCard";
        } else if (card instanceof AmExCC) {
            return "American Express";
        } else if (card instanceof DiscoverCC) {
            return "Discover";
        } else {
            return "Unknown";
        }
    }
}

