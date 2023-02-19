package io.github.jwdeveloper.dg.spigot.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;

public class ImageElement implements ElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return false;
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

    }
}
