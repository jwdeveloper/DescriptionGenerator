package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class SpoilerElement implements ElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CUSTOM) && element.getName().equals("spoiler");
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine()
                .textNewLine("<details>");

        if (elementData.hasProperty("title")) {
            textBuilder.textBetween("<summary>", elementData.getProperty("title"), "</summary>").newLine();
        }
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine().textNewLine("</details>");

    }
}
