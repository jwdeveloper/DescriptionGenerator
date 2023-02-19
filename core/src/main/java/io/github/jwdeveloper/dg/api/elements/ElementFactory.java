package io.github.jwdeveloper.dg.api.elements;

import java.util.List;
import java.util.Map;

public interface ElementFactory {
    ElementBuilder getBuilder();

    Element titleElement(String title);

    Element linkElement(String title, String link);

    Element textElement(String text);

    Element videoElement(String title, String link);

    Element imageElement(String link, String redirectLink);

    Element imageElement(String link);

    Element htmlElement(String tagName, Map<String, Object> properties);

    Element htmlElement(String tagName);

    Element codeElement(String code, String language);

    Element codeElementFromFile(String codeSourcePathString, String language);

    Element listElement(List<String> values);

    Element spoilerElement(String title);

    Element customElement();
}
