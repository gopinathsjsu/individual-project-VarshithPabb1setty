// package parser;

import com.fasterxml.jackson.databind.ObjectMapper;

// import factory.CreditCardFactory;
// import model.AmExCC;
// import model.CardRecords;
// import model.CreditCard;
// import model.DiscoverCC;
// import model.MasterCC;
// import model.VisaCC;

// import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONParser implements FileParser {

    @Override

    public void parseFile(String inputFilePath, String outputFilePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CardRecords records = mapper.readValue(new File(inputFilePath), CardRecords.class);

            List<CardRecordOutput> processedRecords = new ArrayList<>();

            for (CardRecords.CardRecord record : records.getCards()) {
                // if (record.getCardNumber() == null || record.getCardNumber().isEmpty()) {
                //     processedRecords.add(new CardRecordOutput(null, "Invalid: empty/null card number"));
                //     continue;
                // }

                // if (!record.getCardNumber().matches("\\d+")) {
                //     processedRecords.add(new CardRecordOutput(record.getCardNumber(), "Invalid: non numeric characters"));
                //     continue;
                // }

                // if (record.getCardNumber().length() > 19) {
                //     processedRecords.add(new CardRecordOutput(record.getCardNumber(), "Invalid: more than 19 digits"));
                //     continue;
                // }

                // CreditCard card = CreditCardFactory.getCreditCard(record.getCardNumber(), 
                //                                                   record.getExpirationDate(), 
                //                                                   record.getCardHolderName());
                // String cardType = "Unknown";
                // boolean isValid = false;

                // if (card != null) {
                //     isValid = card.isValid();
                //     cardType = isValid ? getCardType(card) : "Invalid: Not a possible card number";
                // } else {
                //     cardType = "Invalid: Not a possible card number";
                // }

                String cardType = CardValidationUtil.getCardTypeAndValidity(record.getCardNumber());

                processedRecords.add(new CardRecordOutput(record.getCardNumber(), cardType));
            }

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(outputFilePath), new CardRecordsOutput(processedRecords));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
}

