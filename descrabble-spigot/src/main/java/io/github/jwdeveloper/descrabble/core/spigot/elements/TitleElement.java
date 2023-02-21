package io.github.jwdeveloper.descrabble.core.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class TitleElement implements ElementRenderer{
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.TITLE);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

    }


}
