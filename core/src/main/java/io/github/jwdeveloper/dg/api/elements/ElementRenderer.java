package io.github.jwdeveloper.dg.api.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;


public interface ElementRenderer {

    boolean onElementValidation(Element element);

    void onElementOpen(TextBuilder textBuilder, Element elementData);

    void onBeforeEachChild(TextBuilder textBuilder, Element elementData);

    void onAfterEachChild(TextBuilder textBuilder, Element elementData);

    void onElementClose(TextBuilder textBuilder, Element elementData);
}
