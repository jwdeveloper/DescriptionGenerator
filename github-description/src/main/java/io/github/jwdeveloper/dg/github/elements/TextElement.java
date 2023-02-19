package io.github.jwdeveloper.dg.github.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementType;

public class TextElement implements ElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.TEXT);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        if(elementData.hasTag("quote"))
        {
            textBuilder.text(">").space();
        }

        if(elementData.hasTag("bold"))
        {
            textBuilder.text("**").space();
        }
        if(elementData.hasTag("italic"))
        {
            textBuilder.text("* *").space();
        }
        if(elementData.hasTag("strikethrough"))
        {
            textBuilder.text("~~").space();
        }
        if(elementData.hasTag("checked"))
        {
            textBuilder.space().text("[x]").space();
        }
        if(elementData.hasTag("not-checked"))
        {
            textBuilder.space().text("[x]").space();
        }
        if(elementData.hasTag("emoji"))
        {
            textBuilder.text(":");
        }

        String text = elementData.getProperty("text");
        textBuilder.text(text);
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        if(elementData.hasTag("bold"))
        {
            textBuilder.space().text("**");
        }
        if(elementData.hasTag("italic"))
        {
            textBuilder.space().text("* *");
        }
        if(elementData.hasTag("strikethrough"))
        {
            textBuilder.space().text("~~");
        }
        if(elementData.hasTag("emoji"))
        {
            textBuilder.text(":");
        }
    }
}
