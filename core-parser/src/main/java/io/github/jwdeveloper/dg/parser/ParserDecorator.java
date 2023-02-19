package io.github.jwdeveloper.dg.parser;

import io.github.jwdeveloper.dg.api.DescriptionDecorator;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementFactory;
import io.github.jwdeveloper.dg.api.elements.ElementType;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ParserDecorator implements DescriptionDecorator {

    private final org.jsoup.nodes.Element htmlBody;

    public ParserDecorator(String fileName) throws URISyntaxException, IOException {
        var file = getFile(fileName);
        var doc = Jsoup.parse(file, "UTF-8");
        htmlBody = doc.getElementsByTag("body").get(0);
    }

    @Override
    public void decorate(Element root, ElementFactory factory) {
        decorate(htmlBody, root, factory);
    }

    public void decorate(org.jsoup.nodes.Element htmlRoot, Element root, ElementFactory factory) {
        for (var htmlElement : htmlRoot.children()) {

            var builder = factory.getBuilder();
            var name = htmlElement.tagName();
            if(name.equals("img"))
            {
                name = "image";
            }
            var elementType = ElementType.byName(name);
            builder.withName(name);
            builder.withType(elementType);


            for (var htmlAttribute : htmlElement.attributes()) {
                var key = htmlAttribute.getKey();
                if (key.contains("#")) {
                    key = key.substring(1);
                    builder.withTag(key);
                    continue;
                }
                var value = htmlAttribute.getValue();
                builder.withProperty(key, value);
            }

            var newRoot = builder.build();
            if (htmlElement.hasText()) {
                var text = htmlElement.ownText();
                if (elementType != ElementType.TEXT) {
                    var textElement = factory.textElement(text);
                    newRoot.addElement(textElement);
                }
                newRoot.addProperty("text", text);
            }
            decorate(htmlElement, newRoot, factory);
            root.addElement(newRoot);
        }
    }


    public static File getFile(String fileName) throws URISyntaxException {
        URL resource = Main.class.getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        }
        return new File(resource.toURI());
    }


}
