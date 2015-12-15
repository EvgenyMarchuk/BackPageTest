import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeMethod
    public void setup(){
        open("http://the-internet.herokuapp.com/status_codes");
    }

    @Test
    public void caseOneTest(){
        ElementsCollection links = $$(".example>ul>li>a");
        int count = links.size();
        for (int i = 0; i < count; i++) {
            links.get(i).click();
            back();
        }
    }

}
