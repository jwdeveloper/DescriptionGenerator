package io.github.jwdeveloper.dg.spigot.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementType;
import io.github.jwdeveloper.dg.spigot.SpigotElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainerElement extends SpigotElement {
    private List<String> allowedNames;

    public ContainerElement() {
        allowedNames = new ArrayList<>();
        allowedNames.add("left");
        allowedNames.add("right");
        allowedNames.add("center");
        allowedNames.add("container");
    }

    private boolean hasValidName(String name) {
        for (var allowed : allowedNames) {
            if (allowed.equals(name))
                return true;
        }
        return false;
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine().newLine();
        openTag(textBuilder,elementData.getName());
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        closeTag(textBuilder,elementData.getName());
        textBuilder.newLine().newLine();
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
    }

    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CUSTOM) && hasValidName(element.getName());
    }


}
