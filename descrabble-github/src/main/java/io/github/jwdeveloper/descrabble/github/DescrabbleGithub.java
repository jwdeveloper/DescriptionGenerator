package io.github.jwdeveloper.descrabble.github;

import io.github.jwdeveloper.descrabble.Descrabble;
import io.github.jwdeveloper.descrabble.api.DescriptionRenderer;
import io.github.jwdeveloper.descrabble.api.DescriptionRendererBuilder;
import io.github.jwdeveloper.descrabble.github.elements.*;
import io.github.jwdeveloper.descrabble.github.elements.html.ContainerElement;
import io.github.jwdeveloper.descrabble.github.elements.html.HtmlElement;
import io.github.jwdeveloper.descrabble.github.elements.html.ImageElement;
import io.github.jwdeveloper.descrabble.github.elements.html.VideoElement;

public class DescrabbleGithub {
    public static final String IGNORE = "github-ignore";


    public static DescriptionRenderer createRenderer() {
        return rendererBuilder().build();
    }

    public static DescriptionRenderer createRenderer(String fileName) {
        return rendererBuilder(fileName).build();
    }

    public static DescriptionRendererBuilder rendererBuilder() {
        return rendererBuilder("gtihub.md");
    }

    public static DescriptionRendererBuilder rendererBuilder(String fileName) {
        return Descrabble.descriptionRendererBuilder()
                .withFileName(fileName)
                .withOnValidationElement(element -> !element.hasTag(DescrabbleGithub.IGNORE))
                .withElementRenderer(new LinkElement())
                .withElementRenderer(new VideoElement())
                .withElementRenderer(new ListElement())
                .withElementRenderer(new ImageElement())
                .withElementRenderer(new TitleElement())
                .withElementRenderer(new TextElement())
                .withElementRenderer(new BreakLineElement())
                .withElementRenderer(new SpoilerElement())
                .withElementRenderer(new HtmlElement())
                .withElementRenderer(new QuoteElement())
                .withElementRenderer(new ContainerElement())
                .withElementRenderer(new CodeElement());
    }

}
