package io.github.jwdeveloper.dg.api;

import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementRendererBuilder;

import java.util.function.Consumer;
import java.util.function.Function;

public interface DescriptionRendererBuilder {

    DescriptionRendererBuilder withFileName(String name);

    DescriptionRendererBuilder withElementRenderer(ElementRenderer elementRenderer);

    DescriptionRendererBuilder withElementRenderer(Consumer<ElementRendererBuilder> onRender);

    DescriptionRendererBuilder withOnValidationElement(Function<Element, Boolean> onValidation);

    DescriptionRenderer build();
}
