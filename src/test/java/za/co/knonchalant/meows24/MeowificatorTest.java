package za.co.knonchalant.meows24;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MeowificatorTest {
public static final String TEMP_HTML ="/Users/evan/Library/Preferences/IntelliJIdea2019.3/scratches/scratch.html";
    @Test
    public void test() throws Exception {
        String s = Meowificator.get();
        Files.write(Paths.get(TEMP_HTML), s.getBytes());
    }

    @Test
    public void testMeow() {
        Assert.assertEquals("Meow", Meow.meow("Jim"));
        Assert.assertEquals("21-meow", Meow.meow("21-day"));
        Assert.assertEquals("MEOW", Meow.meow("SA"));
        Assert.assertEquals("Meowing", Meow.meow("Breaking"));
    }
}
