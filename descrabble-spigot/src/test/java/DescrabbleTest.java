import io.github.jwdeveloper.descrabble.Descrabble;
import io.github.jwdeveloper.descrabble.core.spigot.DescrabbleSpigot;
import org.junit.jupiter.api.Test;

import java.io.File;

public class DescrabbleTest
{
    @Test
    public void test()
    {
        var classLoader = getClass().getClassLoader();
        var file = new File(classLoader.getResource("template.html").getFile());

        var descrabble = Descrabble.create()
                .withPlugin(DescrabbleSpigot.plugin())
                .withTemplate(file)
                .build();

        var outPutPath = "src/test/resources";
        var outputFile = new File(outPutPath);
        var absolutePath = outputFile.getAbsolutePath();

        descrabble.generate(absolutePath);
    }
}
