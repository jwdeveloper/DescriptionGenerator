package io.github.jwdeveloper.descrabble;

import io.github.jwdeveloper.descrabble.api.DescrabbleBuilder;

public class Descrabble
{
    public static DescrabbleBuilder create() {
        return new DescrabbleBuilderImpl();
    }

}
