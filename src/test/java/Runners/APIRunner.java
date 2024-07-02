package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //место нахожджения функций
        features = "src/test/resources/feature/",
        //находим реализацию шагов
        glue = "APISteps",
        // будет только сканирование и быстро найдутся не реализованные шаги
        //dryRun = true,
        dryRun = false,   // - начнется выполнение

        //позволяет легко читать вывод на консоле, удалит все не читаемые символы
        monochrome = true,
        tags = "@dynamic",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}//для создания отчетов

        // pretty - вывод шагов в консоле


)


public class APIRunner {
}
