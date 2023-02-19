package io.github.jwdeveloper.dg.api;

import java.nio.file.Path;
import java.util.Set;

public interface DescriptionGenerator
{
    Set<Path> generate(String path);
}
