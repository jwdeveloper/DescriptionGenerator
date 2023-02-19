package io.github.jwdeveloper.dg.spigot;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;

public class SpigotElement implements ElementRenderer
{
    protected void openTag(TextBuilder textBuilder, String name) {
        openTag(textBuilder, name, null);
    }

    protected void openTag(TextBuilder textBuilder, String name, String value) {
        if (value == null || value.equals("")) {
            textBuilder.textBetween("[", name.toUpperCase(), "]");
            return;
        }
        textBuilder.textBetween("[", name.toUpperCase(), "=" + value + "]");
    }

    protected void closeTag(TextBuilder textBuilder, String name) {
        textBuilder.textBetween("[/", name.toUpperCase(), "]");
    }

    @Override
    public boolean onElementValidation(Element element) {
        return false;
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
    }
}
