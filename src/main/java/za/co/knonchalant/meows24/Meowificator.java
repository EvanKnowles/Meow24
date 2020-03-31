package za.co.knonchalant.meows24;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Meowificator {

    public static String get() throws IOException {
        Document document = Jsoup.connect("https://www.news24.com")
                .get();

        document.select("#divToHide").remove();
        document.select("script").remove();
        document.select(".tt_widget").remove();
        document.select(".corner").remove();
        document.select(".lotto_block").remove();
        document.select(".horoscope_item").remove();

        for (Element img : document.select("img")) {
            img.attr("src", "https://cataas.com/cat?" + getRandom());
        }


        meow(document, "p");
        meow(document, "a");

        meow(document, "h1");
        meow(document, "h2");
        meow(document, "h3");
        meow(document, "h4");
        meow(document, "h5");


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
