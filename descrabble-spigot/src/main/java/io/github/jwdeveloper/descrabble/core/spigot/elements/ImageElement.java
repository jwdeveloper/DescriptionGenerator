package io.github.jwdeveloper.descrabble.core.spigot.elements;

import io.github.jwdeveloper.descrabble.core.spigot.SpigotElement;
import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;

public class ImageElement extends SpigotElement {
    @Override
    public boolean onElementValidation(Element element) {
        return element.getName().equals("image");
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        if (elementData.hasProperty("open")) {
            openTag(textBuilder, "URL", "'" + elementData.getProperty("open") + "'");
        }

        if (elementData.hasProperty("image")) {
            var image = elementData.getProperty("image");
            openTag(textBuilder, "IMG");
            textBuilder.text(image);
        }
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        if (elementData.hasProperty("image")) {
            closeTag(textBuilder, "IMG");
        }
        if (elementData.hasProperty("open")) {
            closeTag(textBuilder, "URL");
        }

        textBuilder.newLine();
    }
}
