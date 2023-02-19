package io.github.jwdeveloper.dg.github.elements;

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
        String title = elementData.getProperty("title");
        if (!link.contains("youtube")) {
            textBuilder.text("Only youtube videos currently supported");
            return;
        }

        var id = getYouTubeId(link);
        var imageUrl = "https://img.youtube.com/vi/" + id + "/0.jpg";
        textBuilder.newLine().text("[![IMAGE ALT TEXT HERE]").text("(").text(imageUrl).text(")]")
                .textNewLine("(").text(title).text(")")
                .newLine();
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

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
