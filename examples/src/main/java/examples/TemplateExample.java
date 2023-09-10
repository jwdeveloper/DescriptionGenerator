package examples;

import io.github.jwdeveloper.descrabble.Descrabble;
import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.spigot.DescrabbleSpigot;
import io.github.jwdeveloper.descrabble.github.DescrabbleGithub;
import java.io.File;

public class TemplateExample {
    public static void main(String[] args) {
        ClassLoader classLoader = TemplateExample.class.getClassLoader();
        File file = new File(classLoader.getResource("template.html").getFile());

        DescriptionGenerator generator = Descrabble.create()
                .withTemplate(file)
                .withPlugin(DescrabbleGithub.plugin())
                .withPlugin(DescrabbleSpigot.plugin())
                .build();

        String output = "C:\\Users\\ja\\IdeaProjects\\DescriptionGenerator\\examples\\src\\main\\resources\\output";
        generator.generate(output);
    }
}
