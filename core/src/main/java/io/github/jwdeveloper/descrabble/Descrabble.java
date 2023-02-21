package io.github.jwdeveloper.descrabble;

import io.github.jwdeveloper.descrabble.api.DescriptionGeneratorBuilder;
import io.github.jwdeveloper.descrabble.api.DescriptionRendererBuilder;
import io.github.jwdeveloper.descrabble.api.elements.ElementRendererBuilder;
import io.github.jwdeveloper.descrabble.core.DescriptionGeneratorBuilderImpl;
import io.github.jwdeveloper.descrabble.core.DescriptionRendererBuilderImpl;
import io.github.jwdeveloper.descrabble.core.element.ElementRendererBuilderImpl;

public class Descrabble
{
    public static DescriptionGeneratorBuilder descriptionBuilder() {
        return new DescriptionGeneratorBuilderImpl();
    }

    public static DescriptionRendererBuilder descriptionRendererBuilder() {
        return new DescriptionRendererBuilderImpl();
    }

    public static ElementRendererBuilder elementRendererBuilder() {
        return new ElementRendererBuilderImpl();
    }
}
