package io.github.jwdeveloper.dg.github.elements.html;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementType;

import java.util.HashMap;

public class ImageElement extends HtmlElement {
    @Override
    public boolean onElementValidation(Element element)
    {
        var i =0;
        return element.getName().equals("image");
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        var props = new HashMap<String,Object>();
        props.put("target","blank");
        if(elementData.hasProperty("open"))
        {
            props.put("href",elementData.getProperty("open"));
        }

        var imgProps = new HashMap<String,Object>();
        if(elementData.hasProperty("image"))
        {
            imgProps.put("src",elementData.getProperty("image"));
        }
        if(elementData.hasProperty("size"))
        {
            imgProps.put("size",elementData.getProperty("size"));
        }
        if(elementData.hasProperty("height"))
        {
            imgProps.put("height",elementData.getProperty("height"));
        }
        if(elementData.hasProperty("width"))
        {
            imgProps.put("width",elementData.getProperty("width"));
        }
        renderOpenTag(textBuilder,"a",props);
        renderOpenTag(textBuilder,"img",imgProps);
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderCloseTag(textBuilder,"img");
        renderCloseTag(textBuilder,"a");
        textBuilder.newLine();
    }
}
