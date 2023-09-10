package io.github.jwdeveloper.descrabble.spigot.elements;

import io.github.jwdeveloper.descrabble.spigot.SpigotElement;
import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;

public class ContainerElement extends SpigotElement {

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine().newLine();
        var position = "center";
        if(elementData.hasTag("left"))
        {
            position = "left";
        }
        if(elementData.hasTag("right"))
        {
            position = "right";
        }
        openTag(textBuilder,position);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        var position = "center";
        if(elementData.hasTag("left"))
        {
            position = "left";
        }
        if(elementData.hasTag("right"))
        {
            position = "right";
        }
        closeTag(textBuilder,position);
        textBuilder.newLine().newLine();
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
    }

}
