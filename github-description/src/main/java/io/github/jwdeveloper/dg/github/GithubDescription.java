package io.github.jwdeveloper.dg.github;

import io.github.jwdeveloper.dg.api.DescriptionRenderer;
import io.github.jwdeveloper.dg.api.DescriptionRendererBuilder;
import io.github.jwdeveloper.dg.github.elements.*;
import io.github.jwdeveloper.dg.DescriptionApi;
import io.github.jwdeveloper.dg.github.elements.html.ContainerElement;
import io.github.jwdeveloper.dg.github.elements.html.HtmlElement;
import io.github.jwdeveloper.dg.github.elements.html.ImageElement;
import io.github.jwdeveloper.dg.github.elements.html.VideoElement;

public class GithubDescription {
    public static final String IGNORE = "github-ignore";


    public static DescriptionRenderer create() {
        return builder().build();
    }

    public static DescriptionRenderer create(String fileName) {
        return builder(fileName).build();
    }

    public static DescriptionRendererBuilder builder() {
        return builder("README.md");
    }

    public static DescriptionRendererBuilder builder(String fileName) {
        return DescriptionApi.descriptionRenderer()
                .withFileName(fileName)
                .withOnValidationElement(element -> !element.hasTag(GithubDescription.IGNORE))
                .withElementRenderer(new LinkElement())
                .withElementRenderer(new VideoElement())
                .withElementRenderer(new ListElement())
                .withElementRenderer(new ImageElement())
                .withElementRenderer(new TitleElement())
                .withElementRenderer(new TextElement())
                .withElementRenderer(new BreakLineElement())
                .withElementRenderer(new SpoilerElement())
                .withElementRenderer(new HtmlElement())
                .withElementRenderer(new ContainerElement())
                .withElementRenderer(new CodeElement());
    }

}
