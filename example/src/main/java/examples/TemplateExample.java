package examples;

import io.github.jwdeveloper.descrabble.Descrabble;
import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.core.spigot.DescrabbleSpigot;
import io.github.jwdeveloper.descrabble.github.DescrabbleGithub;
import java.io.File;

public class TemplateExample {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = TemplateExample.class.getClassLoader();
            File file = new File(classLoader.getResource("template.html").getFile());

            DescriptionGenerator generator = Descrabble.descriptionBuilder()
                    .withTemplate(file)
                    .withRenderer(DescrabbleGithub.createRenderer())
                    .withRenderer(DescrabbleSpigot.create())
                    .build();

            String output = "C:\\Users\\ja\\IdeaProjects\\DescriptionGenerator\\example\\src\\main\\resources\\output";
            generator.generate(output);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
