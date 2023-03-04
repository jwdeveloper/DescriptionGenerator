package io.github.jwdeveloper.descrabble.github.elements;

import io.github.jwdeveloper.descrabble.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.api.ElementRendererModel;
import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class CodeElement implements DescrabbleElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CODE);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        String language = elementData.getProperty("language");

        textBuilder.newLine();
        textBuilder.newLine().text("```").textNewLine(language);

        if(elementData.hasProperty("code"))
        {
            String code = elementData.getProperty("code");
            textBuilder.text(code);
        }
    }


    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.space().newLine().textNewLine("```");
    }

    @Override
    public void onRegistration(ElementRendererModel model) {

    }
}
