package io.github.jwdeveloper.dg.spigot.elements;

import io.github.jwdeveloper.dg.api.TextBuilder;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementRenderer;
import io.github.jwdeveloper.dg.api.elements.ElementType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoElement implements ElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.VIDEO);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        String link = elementData.getProperty("link");

        if (link.contains("youtube")) {
            var id = getYouTubeId(link);
            textBuilder.text("[MEDIA=youtube]").space().text(id);
        }
        else
        {
            textBuilder.text("[MEDIA]");
        }
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
      textBuilder.text("[/MEDIA]");
    }


    private String getYouTubeId(String youTubeUrl) {
        String pattern = "(?<=youtu.be/|watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(youTubeUrl);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }
}
