package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class LinkElement implements ElementRenderer
{

    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.LINK);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.textBetween("[",elementData.getProperty("title"),"]");
        textBuilder.textBetween("(",elementData.getProperty("link"),")");
        textBuilder.space();
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

    }
}
