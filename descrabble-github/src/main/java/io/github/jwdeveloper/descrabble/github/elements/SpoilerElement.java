package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.api.ElementRendererModel;
import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class SpoilerElement implements DescrabbleElementRenderer {


    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine()
                .textNewLine("<details>");

        if (elementData.hasProperty("title")) {
            textBuilder.textBetween("<summary>", elementData.getProperty("title"), "</summary>").newLine();
        }
    }



    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine().textNewLine("</details>");

    }

    @Override
    public void onRegistration(ElementRendererModel model) {

    }
}
