package io.github.jwdeveloper.dg.api;

import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementFactory;

public interface DescriptionDecorator
{
    void decorate(Element root, ElementFactory factory);
}
