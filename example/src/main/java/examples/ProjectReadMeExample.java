package examples;

import io.github.jwdeveloper.descrabble.Descrabble;
import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.github.DescrabbleGithub;
import java.nio.file.Path;

public class ProjectReadMeExample
{
    public static void main(String[] args)
    {
        DescriptionGenerator generator = Descrabble.descriptionBuilder()
                .withTemplate(Path.of("C:\\Users\\ja\\IdeaProjects\\DescriptionGenerator\\readme-template.html"))
                .withRenderer(DescrabbleGithub.createRenderer("README.md"))
                .build();

        String output = "C:\\Users\\ja\\IdeaProjects\\DescriptionGenerator\\";
        generator.generate(output);
    }
}
