package io.github.jwdeveloper.dg.github.elements.html;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementType;

import java.util.Map;

public class HtmlElement implements ElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.HTML);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        renderOpenTag(textBuilder, elementData.getName(), elementData.getProperties());
    }


    public void renderOpenTag(TextBuilder textBuilder,String name, Map<String, Object> properties)
    {
        textBuilder.newLine();
        textBuilder.text("<").text(name).space();

        for(var property : properties.entrySet())
        {
            textBuilder.text(property.getKey()).text("=\"").text(property.getValue()).text("\"").space();
        }
        textBuilder.text(">").newLine();
    }

    public void renderCloseTag(TextBuilder textBuilder, String name)
    {
        textBuilder.textBetween("</",name , ">");
        textBuilder.newLine();
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderCloseTag(textBuilder, elementData.getName());
    }
}
