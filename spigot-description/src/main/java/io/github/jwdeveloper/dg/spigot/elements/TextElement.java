package io.github.jwdeveloper.dg.spigot.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementType;
import io.github.jwdeveloper.dg.spigot.SpigotElement;

public class TextElement extends SpigotElement {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.TEXT);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {




        if (elementData.hasProperty("color")) {
            openTag(textBuilder, "COLOR", elementData.getProperty("color"));
        }
        if (elementData.hasProperty("font")) {
            openTag(textBuilder, "FONT", elementData.getProperty("font"));
        }
        if (elementData.hasProperty("size")) {
            openTag(textBuilder, "SIZE", elementData.getProperty("size"));
        }
        if(elementData.hasTag("strike"))
        {
            openTag(textBuilder, "S");
        }

        if (elementData.hasTag("bold")) {
            openTag(textBuilder, "B");
        }
        if (elementData.hasTag("italic")) {
            openTag(textBuilder, "I");
        }
        if (elementData.hasTag("under-line")) {
            openTag(textBuilder, "U");
        }
        String text = elementData.getProperty("text");
        textBuilder.text(text);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        if (elementData.hasProperty("color")) {
            closeTag(textBuilder, "COLOR");
        }
        if (elementData.hasProperty("font")) {
            closeTag(textBuilder, "FONT");
        }
        if (elementData.hasProperty("size")) {
            closeTag(textBuilder, "SIZE");
        }
        if(elementData.hasTag("strike"))
        {
            openTag(textBuilder, "S");
        }
        if (elementData.hasTag("bold")) {
            closeTag(textBuilder, "B");
        }
        if (elementData.hasTag("italic")) {
            closeTag(textBuilder, "I");
        }
        if (elementData.hasTag("under-line")) {
            closeTag(textBuilder, "U");
        }
    }



}
