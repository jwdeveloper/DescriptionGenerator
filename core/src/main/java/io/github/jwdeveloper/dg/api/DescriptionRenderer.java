package io.github.jwdeveloper.dg.api;

import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;

import java.util.List;

public interface DescriptionRenderer
{
    String getFileName();

    List<ElementRenderer> getElementRenderers();

    boolean onElementValidation(Element element);
}
