package io.github.jwdeveloper.dg.spigot.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementType;
import io.github.jwdeveloper.dg.spigot.SpigotElement;

public class LinkElement extends SpigotElement {

    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.LINK);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {


        if(elementData.hasProperty("link"))
        {
            String link = elementData.getProperty("link");
            openTag(textBuilder,"URL","'"+link+"'");
        }
        if(elementData.hasProperty("title"))
        {
            String title = elementData.getProperty("title");
            textBuilder.text(title);
        }
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        closeTag(textBuilder,"URL");
    }
}
