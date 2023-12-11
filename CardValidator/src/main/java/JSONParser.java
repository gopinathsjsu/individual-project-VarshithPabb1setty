import com.fasterxml.jackson.databind.ObjectMapper;
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

                String cardType = CardValidationUtil.getCardTypeAndValidity(record.getCardNumber());

                processedRecords.add(new CardRecordOutput(record.getCardNumber(), cardType));
            }

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(outputFilePath), new CardRecordsOutput(processedRecords));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

