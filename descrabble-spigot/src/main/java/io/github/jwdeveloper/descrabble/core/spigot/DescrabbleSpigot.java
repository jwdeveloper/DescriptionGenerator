package io.github.jwdeveloper.descrabble.core.spigot;

import io.github.jwdeveloper.descrabble.Descrabble;
import io.github.jwdeveloper.descrabble.core.spigot.elements.*;
import io.github.jwdeveloper.descrabble.api.DescriptionRenderer;
import io.github.jwdeveloper.descrabble.api.DescriptionRendererBuilder;


public class DescrabbleSpigot {
    public static final String IGNORE = "spigot-ignore";

    public static DescriptionRenderer create() {
        return builder().build();
    }

    public static DescriptionRenderer create(String fileName) {
        return builder(fileName).build();
    }

    public static DescriptionRendererBuilder builder() {
        return builder("spigot.txt");
    }

    public static DescriptionRendererBuilder builder(String fileName) {
        return Descrabble.descriptionRendererBuilder()
                .withFileName(fileName)
                .withOnValidationElement(element -> !element.hasTag(DescrabbleSpigot.IGNORE))
                .withElementRenderer(new LinkElement())
                .withElementRenderer(new VideoElement())
                .withElementRenderer(new ListElement())
                .withElementRenderer(new ImageElement())
                .withElementRenderer(new TitleElement())
                .withElementRenderer(new TextElement())
                .withElementRenderer(new BreakLineElement())
                .withElementRenderer(new SpoilerElement())
                .withElementRenderer(new ContainerElement())
                .withElementRenderer(new CodeElement())
                .withElementRenderer(new QuoteElement());
    }

}
