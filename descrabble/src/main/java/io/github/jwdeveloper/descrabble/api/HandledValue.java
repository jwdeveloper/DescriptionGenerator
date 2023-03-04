package io.github.jwdeveloper.descrabble.api;


import lombok.Data;

@Data
public class HandledValue
{
    private String source = "default";
    private String name;
    private String description;
}
