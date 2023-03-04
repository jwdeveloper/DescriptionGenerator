package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.api.ElementRendererModel;
import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class LinkElement implements DescrabbleElementRenderer
{

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.textBetween("[",elementData.getProperty("title"),"]");
        textBuilder.textBetween("(",elementData.getProperty("link"),")");
        textBuilder.space();
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

    }


    @Override
    public void onRegistration(ElementRendererModel model) {

    }
}
