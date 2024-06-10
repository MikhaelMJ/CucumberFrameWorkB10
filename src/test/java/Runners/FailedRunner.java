package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //место нахожджения функций
        features = "@target/failed.txt",
        //находим реализацию шагов
        glue = "steps",
        // будет только сканирование и быстро найдутся не реализованные шаги
        //dryRun = true,
        //dryRun = false,   // - начнется выполнение

        //позволяет легко читать вывод на консоле, удалит все не читаемые символы
        monochrome = true,
        //tags = "@errorvalidation",
        plugin = {"pretty"}//для создания отчетав

        // pretty - вывод шагов в консоле


)

public class FailedRunner {
}
