package example;

import io.github.jwdeveloper.dg.api.DescriptionGenerator;
import io.github.jwdeveloper.dg.api.DescriptionRenderer;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementType;
import io.github.jwdeveloper.dg.DescriptionApi;

import java.io.IOException;

public class CustomDocumentationExample {
    public static void main(String[] args) throws IOException {

        DescriptionRenderer githubRenderer = DescriptionApi.descriptionRenderer()
                .withFileName("CUSTOM_README.md")
                .withElementRenderer(elementRenderer ->
                {
                    elementRenderer.onElementValidation(element -> element.hasElementType(ElementType.LINK));
                    elementRenderer.onElementOpen((textBuilder, element) ->
                    {
                        textBuilder.textBetween("[",element.getProperty("title"),"]");
                        textBuilder.textBetween("(",element.getProperty("link"),")");
                    });
                })
                .withElementRenderer(elementRenderer ->
                {
                    elementRenderer.onElementValidation(element -> element.hasElementType(ElementType.TITLE));
                    elementRenderer.onElementOpen((textBuilder, element) ->
                    {
                        int size = element.getProperty("size");
                        String title = element.getProperty("title");
                        textBuilder.repeat("#",size);
                        textBuilder.text(title);
                        textBuilder.newLine();
                    });
                })
                .build();

        DescriptionGenerator descriptionGenerator = DescriptionApi.description()
                .withDecorator((root, factory) ->
                {
                    String link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley";
                    Element linkElement = factory.linkElement("DO NOT CLICK THIS LINK", link);
                    Element titleElement = factory.titleElement("Hello world");
                    titleElement.addProperty("size",2);

                    root.addElement(titleElement);
                    root.addElement(linkElement);
                })
                .withRenderer(githubRenderer).build();

        String outputPath = "D:\\Git\\DescriptionGenerator\\example";
        descriptionGenerator.generate(outputPath);
    }
}
