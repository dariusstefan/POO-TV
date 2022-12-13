import Entities.POOTVCore;
import Input.GeneralInput;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        GeneralInput inputData = objectMapper.readValue(new File(args[0]), GeneralInput.class);

        POOTVCore core = new POOTVCore(inputData);

        System.out.println(core);
    }
}
