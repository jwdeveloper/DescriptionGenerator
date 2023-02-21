package io.github.jwdeveloper.descrabble.github.elements.html;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainerElement extends HtmlElement {
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
        var properties = new HashMap<String, Object>();
        properties.put("align", elementData.getName());
        renderOpenTag(textBuilder, "div", properties);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderCloseTag(textBuilder, "div");
        textBuilder.newLine();
    }

    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CUSTOM) && hasValidName(element.getName());
    }


}
