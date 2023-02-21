package io.github.jwdeveloper.descrabble.api.elements;

public enum ElementType
{
    TEXT, IMAGE, CODE, TITLE, HTML, LIST, VIDEO, LINK, CUSTOM, ROOT;

    public static ElementType byName(String name)
    {
        name = name.toUpperCase();
        for(var elementType :  ElementType.values())
        {
            if(elementType.name().equals(name))
            {
                return elementType;
            }
        }
        return ElementType.CUSTOM;
    }
}
