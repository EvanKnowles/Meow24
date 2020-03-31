package za.co.knonchalant.meows24;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Meowificator {

    public static String get() throws IOException {
        Document document = Jsoup.connect("https://www.news24.com")
                .get();

        byte[] bytes = Files.readAllBytes(Paths.get("/Users/evan/dev/GitHub/Meows24/src/main/resources/Meows24.png"));
        String logoPngBase64 = Base64.getEncoder().encodeToString(bytes);
        String backgroundAttribute = "background: none;";
        Elements logo = document.select("#news24HeaderLogo");

        logo.attr("style", String.format(backgroundAttribute, logoPngBase64));

        document.select("#divToHide").remove();
        document.select("script").remove();
        document.select(".tt_widget").remove();
        document.select(".corner").remove();
        document.select(".lotto_block").remove();
        document.select(".horoscope_item").remove();

        for (Element img : document.select("img")) {
            img.attr("src", "https://cataas.com/cat?" + getRandom());
        }


        meow(document, "span");
        meow(document, "p");
        meow(document, "a");

        meow(document, "h1");
        meow(document, "h2");
        meow(document, "h3");
        meow(document, "h4");
        meow(document, "h5");
        meow(document, ".absolute.update_time");

        logo.select("a").html("<img src='data:image/png;base64," + logoPngBase64 + "' style='    position: absolute;\n" +
                "    top: 0;\n" +
                "    left: 0;\n" +
                "    width: 208px;\n" +
                "    height: 75px;'/>");
        logo.attr("id", "naah");

        return document.html();
    }

    private static String getRandom() {
        return String.valueOf((int)(Math.random() * 396));

    }

    private static void meow(Document document, String selector) {
        Elements p = document.body().select(selector);

        for (Element element : p) {
            for (TextNode textNode : element.textNodes()) {
                String[] s = textNode.text().split(" ");

                StringBuilder result = new StringBuilder();
                for (String s1 : s) {
                    result.append(Meow.meow(s1)).append(" ");
                }
                textNode.text(result.toString());
            }
        }
    }


}
