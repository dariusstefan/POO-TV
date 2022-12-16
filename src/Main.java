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

//        if (!args[0].contains("5.json")) {
//            return;
//        }

        POOTVCore.getInstance().initPOOTVCore(inputData);
        Logger.getInstance().initLogger(output, objectMapper);

        HomepageAuth homepageAuth = HomepageAuth.getInstance();
        HomepageUnauth homepageUnauth = HomepageUnauth.getInstance();
        LoginPage loginPage = LoginPage.getInstance();
        RegisterPage registerPage = RegisterPage.getInstance();
        Movies moviesPage = Movies.getInstance();
        Upgrades upgradesPage = Upgrades.getInstance();
        SeeDetails seeDetailsPage = SeeDetails.getInstance();
        LogoutPage logoutPage = LogoutPage.getInstance();

        homepageAuth.completeReachable();
        homepageUnauth.completeReachable();
        loginPage.completeReachable();
        registerPage.completeReachable();
        moviesPage.completeReachable();
        upgradesPage.completeReachable();
        seeDetailsPage.completeReachable();
        logoutPage.completeReachable();

        POOTVCore.getInstance().setCurrentPage(homepageUnauth);

        for (Action action : POOTVCore.getInstance().getActions()) {
            POOTVCore.getInstance().getCurrentPage().makeAction(action);
        }

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), output);
    }
}
