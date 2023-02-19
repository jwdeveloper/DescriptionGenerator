package io.github.jwdeveloper.dg.github.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementType;

public class CodeElement implements ElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CODE);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        String language = elementData.getProperty("language");
        String code = elementData.getProperty("code");
        textBuilder.space().text("```").textNewLine(language);
        textBuilder.text(code);
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.space().textNewLine("```");
    }
}
