import Actions.Action;
import Entities.Logger;
import Entities.POOTVCore;
import Input.GeneralInput;
import Pages.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        GeneralInput inputData = objectMapper.readValue(new File(args[0]), GeneralInput.class);
        ArrayNode output = objectMapper.createArrayNode();

        POOTVCore.getInstance().initPOOTVCore(inputData);
        Logger.getInstance().initLogger(output, objectMapper);

        HomepageAuth.getInstance().completeReachable();
        HomepageUnauth.getInstance().completeReachable();
        LoginPage.getInstance().completeReachable();
        RegisterPage.getInstance().completeReachable();
        Movies.getInstance().completeReachable();
        Upgrades.getInstance().completeReachable();
        SeeDetails.getInstance().completeReachable();
        LogoutPage.getInstance().completeReachable();

        POOTVCore.getInstance().setCurrentPage(HomepageUnauth.getInstance());

        for (Action action : POOTVCore.getInstance().getActions()) {
            POOTVCore.getInstance().getCurrentPage().makeAction(action);
        }

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), output);
    }
}
