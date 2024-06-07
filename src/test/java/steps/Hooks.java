package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

import java.io.IOException;

public class Hooks extends CommonMethods {

    @Before
    public void start() throws IOException {
        openBrowser();
    }

    @After
    public void end(){
        tearDown();
    }
}
