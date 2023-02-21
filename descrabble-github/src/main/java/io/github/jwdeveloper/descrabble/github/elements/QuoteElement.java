package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class QuoteElement implements ElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CUSTOM) && element.getName().equals("quote");
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.text(">").space();
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

        textBuilder.newLine();
    }
}
