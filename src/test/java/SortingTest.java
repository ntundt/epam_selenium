import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortingTest {

    public static void main(String[] args) {

    }

    @Test
    protected void sortingTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.ti.com/amplifier-circuit/comparators/products.html");

        By idTblResults = new By.ById("tblResults");
        WebElement element = driver.findElement(idTblResults);
        driver.findElement(new By.ById("consent_prompt_submit")).click();
        element.findElement(new By.ByXPath("//thead[1]/tr[1]/th[5]/span[1]")).click();

        boolean inOrder = true;

        List<WebElement> tableRows =  element.findElements(new By.ByXPath("//table[@id=\"tblResults\"]/tbody[1]/tr/td[5]/span[1]"));
        int prevv = Integer.parseInt(tableRows.get(0).getText());
        for (WebElement e : tableRows) {
            int currv = Integer.parseInt(e.getText());
            if (currv > prevv) {
                inOrder = false;
                break;
            }
            prevv = currv;
        }

        assertTrue(inOrder);
    }
}
