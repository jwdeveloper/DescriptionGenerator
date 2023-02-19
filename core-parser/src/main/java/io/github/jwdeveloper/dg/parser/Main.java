package io.github.jwdeveloper.dg.parser;

import io.github.jwdeveloper.dg.DescriptionApi;
import io.github.jwdeveloper.dg.github.GithubDescription;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            var test = DescriptionApi.description();
            test.withDecorator(new ParserDecorator("template.html"));
            test.withRenderer(GithubDescription.create());
            var renderer = test.build();

            renderer.generate("D:\\Git\\DescriptionGenerator\\core-parser\\src\\main\\resources");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



}
