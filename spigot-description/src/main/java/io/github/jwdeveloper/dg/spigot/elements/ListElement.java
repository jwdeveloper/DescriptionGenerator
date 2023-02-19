package io.github.jwdeveloper.dg.spigot.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementType;
import io.github.jwdeveloper.dg.spigot.SpigotElement;

public class ListElement extends SpigotElement {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.LIST);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
        openTag(textBuilder,"LIST");
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine().text("[*]");
    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
        openTag(textBuilder,"LIST");
        textBuilder.newLine();
    }
}
