package io.github.jwdeveloper.dg.api.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;

@FunctionalInterface
public interface ElementRenderEvent
{
    public void onRenderEvent(TextBuilder textBuilder, Element element);
}
