package examples;

import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.github.DescrabbleGithub;
import io.github.jwdeveloper.descrabble.Descrabble;

import java.util.ArrayList;

public class GithubDocumentationExample {
    public static void main(String[] args) {
        var githubRenderer = DescrabbleGithub.createRenderer();
        DescriptionGenerator descriptionGenerator = Descrabble.descriptionBuilder()
                .withDecorator((root, factory) ->
                {
                    String link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley";
                    Element linkElement = factory.linkElement("DO NOT CLICK THIS LINK", link);
                    Element titleElement = factory.titleElement("Hello world");
                    titleElement.addProperty("size",6);

                    Element videoElement = factory.videoElement("example video",link);
                    Element codeElement = factory.codeElement("""
                            public static void main(String[] args) {
                                System.out.printLine("hello world");
                            }
                            ""","java");

                    Element listElement = factory.listElement(new ArrayList<>());
                    for(int i =0;i<5;i++)
                    {
                        Element listContent = factory.textElement("List content "+i);
                        listContent.addTag("quote");
                        listElement.addElement(listContent);
                    }

                    root.addElement(titleElement);
                    root.addElement(listElement);
                    root.addElement(linkElement);
                    root.addElement(videoElement);
                    root.addElement(codeElement);

                })
                .withRenderer(githubRenderer)
                .build();

        String outputPath = "D:\\Git\\DescriptionGenerator\\example";
        descriptionGenerator.generate(outputPath);

    }
}
