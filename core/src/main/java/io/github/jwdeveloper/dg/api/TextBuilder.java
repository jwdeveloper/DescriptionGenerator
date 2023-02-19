package io.github.jwdeveloper.dg.api;

public interface TextBuilder {
    TextBuilder text(Object... texts);

    TextBuilder text(Object text);

    TextBuilder textBetween(Object open, Object text, Object close);

    TextBuilder space();

    TextBuilder space(int count);

    TextBuilder textNewLine(String text);

    TextBuilder textFormat(String pattern, Object... args);

    TextBuilder newLine();

    TextBuilder repeat(String text, int time);

    String build();
}
