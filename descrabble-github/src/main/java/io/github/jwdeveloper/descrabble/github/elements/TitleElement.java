package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class TitleElement implements ElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.TITLE);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        textBuilder.newLine();
        var size= getSize(elementData);
        textBuilder.text("<h").text(size).space();

        if(elementData.hasProperty("align"))
        {
            textBuilder.textBetween("align=\"",elementData.getProperty("align"),"\"").space();
        }
        textBuilder.text(">");

        if (elementData.hasProperty("title")) {
            textBuilder.text(elementData.getProperty("title"));
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

        textBuilder.textBetween("</h", getSize(elementData), ">");
        textBuilder.newLine();
    }


    private String getSize(Element elementData) {
        if (elementData.hasProperty("size")) {
            return elementData.getProperty("size");
        }
        return "";
    }
}
