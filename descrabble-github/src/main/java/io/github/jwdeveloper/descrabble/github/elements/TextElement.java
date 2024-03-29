package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.api.ElementRendererModel;
import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class TextElement implements DescrabbleElementRenderer {
    @Override
    public void onRegistration(ElementRendererModel model) {

    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        if(elementData.hasTag("quote"))
        {
            textBuilder.text(">").space();
        }

        if(elementData.hasTag("bold"))
        {
            textBuilder.text("**");
        }
        if(elementData.hasTag("italic"))
        {
            textBuilder.text("* *");
        }
        if(elementData.hasTag("strikethrough"))
        {
            textBuilder.text("~~");
        }
        if(elementData.hasTag("checked"))
        {
            textBuilder.space().text("[x]");
        }
        if(elementData.hasTag("not-checked"))
        {
            textBuilder.space().text("[x]");
        }
        if(elementData.hasTag("emoji"))
        {
            textBuilder.text(":");
        }

        String text = elementData.getProperty("text");
        textBuilder.text(text);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

        if(elementData.hasTag("italic"))
        {
            textBuilder.text("* *");
        }

        if(elementData.hasTag("emoji"))
        {
            textBuilder.text(":");
        }

        if(elementData.hasTag("strikethrough"))
        {
            textBuilder.text("~~");
        }

        if(elementData.hasTag("bold"))
        {
            textBuilder.text("**");
        }
    }
}
