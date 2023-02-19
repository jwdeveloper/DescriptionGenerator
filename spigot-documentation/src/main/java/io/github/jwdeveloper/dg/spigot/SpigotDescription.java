package io.github.jwdeveloper.dg.spigot;

import io.github.jwdeveloper.dg.api.DescriptionRenderer;
import io.github.jwdeveloper.dg.api.DescriptionRendererBuilder;
import io.github.jwdeveloper.dg.DescriptionApi;
import io.github.jwdeveloper.dg.spigot.elements.*;

public class SpigotDescription {
    public static final String IGNORE = "spigot-ignore";


    public static DescriptionRenderer create() {
        return builder().build();
    }

    public static DescriptionRenderer create(String fileName) {
        return builder(fileName).build();
    }

    public static DescriptionRendererBuilder builder() {
        return builder("Spigot.txt");
    }

    public static DescriptionRendererBuilder builder(String fileName) {
        return DescriptionApi.descriptionRenderer()
                .withFileName(fileName)
                .withOnValidationElement(element -> !element.hasTag(SpigotDescription.IGNORE))
                .withElementRenderer(new LinkElement())
                .withElementRenderer(new VideoElement())
                .withElementRenderer(new ListElement())
                .withElementRenderer(new ImageElement())
                .withElementRenderer(new TitleElement())
                .withElementRenderer(new TextElement())
                .withElementRenderer(new CenterElement())
                .withElementRenderer(new CodeElement());
    }

}
