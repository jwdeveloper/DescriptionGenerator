package io.github.jwdeveloper.descrabble.core.spigot;

import io.github.jwdeveloper.descrabble.Descrabble;
import io.github.jwdeveloper.descrabble.api.DescrabblePlugin;
import io.github.jwdeveloper.descrabble.core.spigot.elements.*;
import io.github.jwdeveloper.descrabble.api.DescriptionRenderer;
import io.github.jwdeveloper.descrabble.api.DescriptionRendererBuilder;


public class DescrabbleSpigot {

    public static DescrabblePlugin plugin() {
        return new Plugin();
    }
}
