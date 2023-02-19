package io.github.jwdeveloper.dg.implementation;

import io.github.jwdeveloper.dg.api.*;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementFactory;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DescriptionGeneratorBuilderImpl implements DescriptionGeneratorBuilder {

    private final List<DescriptionRenderer> renderers;
    private final List<DescriptionDecorator> decorators;
    public DescriptionGeneratorBuilderImpl()
    {
        renderers = new ArrayList<>();
        decorators = new ArrayList<>();
    }

    @Override
    public DescriptionGeneratorBuilder withDecorator(Consumer<DescriptionDecorator> onDecoration) {
        var proxy = new ProxyDecorator();
        onDecoration.accept(proxy);
        decorators.add(proxy);
        return this;
    }

    public DescriptionGeneratorBuilder withDecorator(DescriptionDecorator decorator)
    {
        decorators.add(decorator);
        return this;
    }

    public DescriptionGeneratorBuilder withRenderer(DescriptionRenderer renderer)
    {
        renderers.add(renderer);
        return this;
    }

    public DescriptionGeneratorBuilder withRenderer(Consumer<DescriptionRendererBuilder> onBuild)
    {
        var builder = new DescriptionRendererBuilderImpl();
        onBuild.accept(builder);
        renderers.add(builder.build());
        return this;
    }

    public DescriptionGenerator build()
    {
        return new DescriptionGeneratorImpl(renderers, decorators);
    }


    @Data
    @AllArgsConstructor
    private class ProxyDecorator implements DescriptionDecorator
    {
        @Override
        public void decorate(Element root, ElementFactory factory) {
        }
    }
}
