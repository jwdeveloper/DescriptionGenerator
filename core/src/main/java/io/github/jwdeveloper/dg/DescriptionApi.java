package io.github.jwdeveloper.dg;

import io.github.jwdeveloper.dg.api.DescriptionGeneratorBuilder;
import io.github.jwdeveloper.dg.api.DescriptionRendererBuilder;
import io.github.jwdeveloper.dg.implementation.DescriptionGeneratorBuilderImpl;
import io.github.jwdeveloper.dg.implementation.DescriptionRendererBuilderImpl;

public class DescriptionApi
{
    public static DescriptionGeneratorBuilder description() {
        return new DescriptionGeneratorBuilderImpl();
    }

    public static DescriptionRendererBuilder descriptionRenderer() {
        return new DescriptionRendererBuilderImpl();
    }
}
