package io.github.jwdeveloper.dg.implementation;

import io.github.jwdeveloper.dg.api.DescriptionRenderer;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class DescriptionRendererImpl implements DescriptionRenderer {

    private final String name;
    private final List<ElementRenderer> elementRenderers;
    private final Function<Element, Boolean> onValidation;

    public DescriptionRendererImpl(String name,
                                   List<ElementRenderer> elementRenderers,
                                   Function<Element, Boolean> onValidation) {
        this.name = name;
        this.elementRenderers = elementRenderers;
        this.onValidation = onValidation;
    }

    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public List<ElementRenderer> getElementRenderers() {
        return elementRenderers;
    }

    @Override
    public boolean onElementValidation(Element element) {
        return onValidation.apply(element);
    }
}
