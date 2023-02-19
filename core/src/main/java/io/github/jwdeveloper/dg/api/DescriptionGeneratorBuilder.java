package io.github.jwdeveloper.dg.api;

import io.github.jwdeveloper.dg.api.elements.ElementRenderer;

import java.util.function.Consumer;

public interface DescriptionGeneratorBuilder {

    DescriptionGeneratorBuilder withDecorator(Consumer<DescriptionDecorator> onDecoration);

    DescriptionGeneratorBuilder withDecorator(DescriptionDecorator decorator);

    DescriptionGeneratorBuilder withRenderer(DescriptionRenderer renderer);

    DescriptionGeneratorBuilder withRenderer(Consumer<DescriptionRendererBuilder> onBuild);

    DescriptionGenerator build();
}
