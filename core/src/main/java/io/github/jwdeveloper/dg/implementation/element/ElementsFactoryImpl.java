package io.github.jwdeveloper.dg.implementation.element;

import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementBuilder;
import io.github.jwdeveloper.dg.api.elements.ElementFactory;
import io.github.jwdeveloper.dg.api.elements.ElementType;

import java.util.List;
import java.util.Map;

public class ElementsFactoryImpl implements ElementFactory {

    public ElementBuilder getBuilder()
    {
        return new ElementBuilderImpl();
    }

    @Override
    public Element titleElement(String title) {
        return getBuilder()
                .withType(ElementType.TITLE)
                .withProperty("title",title)
                .build();
    }

    @Override
    public Element linkElement(String title, String link) {
        return getBuilder()
                .withType(ElementType.LINK)
                .withProperty("title",title)
                .withProperty("link",link)
                .build();
    }

    @Override
    public Element textElement(String text) {
        return getBuilder()
                .withType(ElementType.TEXT)
                .withProperty("text",text)
                .build();
    }

    @Override
    public Element videoElement(String title, String link) {
        return getBuilder()
                .withType(ElementType.VIDEO)
                .withProperty("title",title)
                .withProperty("link",link)
                .build();
    }

    @Override
    public Element imageElement(String link, String redirectLink) {
        return getBuilder()
                .withType(ElementType.IMAGE)
                .withProperty("link",link)
                .withProperty("redirect-link",redirectLink)
                .build();
    }

    @Override
    public Element imageElement(String link) {
        return getBuilder()
                .withType(ElementType.IMAGE)
                .withProperty("link",link)
                .build();
    }

    @Override
    public Element htmlElement(String tagName, Map<String, Object> properties) {
        var builder = getBuilder()
                .withType(ElementType.HTML)
                .withProperty("tag-name",tagName);
        for(var prop : properties.entrySet())
        {
            builder.withProperty(prop.getKey(), prop.getValue());
        }
        return builder.build();
    }

    @Override
    public Element htmlElement(String tagName) {
        return getBuilder()
                .withType(ElementType.HTML)
                .withProperty("tag-name",tagName)
                .build();
    }

    @Override
    public Element customElement() {
        return getBuilder()
                .withType(ElementType.CUSTOM)
                .build();
    }

    @Override
    public Element codeElement(String code, String language) {
        return getBuilder()
                .withType(ElementType.CODE)
                .withProperty("code",code)
                .withProperty("language",language)
                .build();
    }

    @Override
    public Element codeElementFromFile(String codeSourcePath, String language) {
        return getBuilder()
                .withType(ElementType.CODE)
                .withProperty("code-source-path",codeSourcePath)
                .withProperty("language",language)
                .build();
    }

    @Override
    public Element listElement(List<String> values) {
        return getBuilder()
                .withType(ElementType.LIST)
                .withProperty("values",values)
                .build();
    }

    @Override
    public Element spoilerElement(String title) {
        return getBuilder()
                .withType(ElementType.CUSTOM)
                .withTag("spoiler")
                .withProperty("title",title)
                .build();
    }
}
