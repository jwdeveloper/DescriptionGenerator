package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class BreakLineElement implements ElementRenderer
{
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CUSTOM) && element.getName().equals("br");
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
               textBuilder.newLine().newLine();
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
