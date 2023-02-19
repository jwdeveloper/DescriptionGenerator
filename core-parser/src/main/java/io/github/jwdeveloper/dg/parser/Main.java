package io.github.jwdeveloper.dg.parser;

import io.github.jwdeveloper.dg.DescriptionApi;
import io.github.jwdeveloper.dg.github.GithubDescription;
import io.github.jwdeveloper.dg.spigot.SpigotDescription;

import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            var test = DescriptionApi.description();
            test.withDecorator(new ParserDecorator("template.html"));
            test.withRenderer(SpigotDescription.create());
            var renderer = test.build();

            renderer.generate("D:\\Git\\DescriptionGenerator\\core-parser\\src\\main\\resources");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



}
