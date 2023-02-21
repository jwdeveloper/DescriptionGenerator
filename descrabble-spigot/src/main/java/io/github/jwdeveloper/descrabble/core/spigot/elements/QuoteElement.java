package io.github.jwdeveloper.descrabble.core.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;
import io.github.jwdeveloper.descrabble.core.spigot.SpigotElement;

public class QuoteElement extends SpigotElement
{

    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CUSTOM) && element.getName().equals("quote");
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        textBuilder.newLine();
        openTag(textBuilder,"quote");
        textBuilder.newLine();
    }


    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
        closeTag(textBuilder,"quote");
        textBuilder.newLine();
    }
}
