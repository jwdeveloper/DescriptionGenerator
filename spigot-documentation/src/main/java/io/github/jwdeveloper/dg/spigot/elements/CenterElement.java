package io.github.jwdeveloper.dg.spigot.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementType;

public class CenterElement implements ElementRenderer
{

    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CUSTOM) && element.hasTag("center");
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.text("[CENTER]");
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.text("[/CENTER]");
    }
}
