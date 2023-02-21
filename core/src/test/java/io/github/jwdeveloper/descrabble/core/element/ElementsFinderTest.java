package io.github.jwdeveloper.descrabble.core.element;

import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ElementsFinderTest {

    @Test
   public void findByName()
    {
        //Arrange
        var finder = new ElementsFinder();
        var elements = getElements();

        //Act
        var result = finder.findByName(elements,"element", false);

        //Assert
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void findByNameDeep()
    {
        //Arrange
        var finder = new ElementsFinder();
        var elements = getElements();

        //Act
        var result = finder.findByName(elements,"subElement", true);

        //Assert
        Assertions.assertEquals(1, result.size());
    }


    public List<Element> getElements()
    {
        var elements = new ArrayList<Element>();

        var subChildElementData = new ElementData();
        subChildElementData.setName("subElement");
        var subChildElement = new ElementImpl(subChildElementData);

        var childData = new ElementData();
        childData.setName("element");
        var childElement = new ElementImpl(childData);

        var child2Data = new ElementData();
        child2Data.setName("element");
        var child2Element = new ElementImpl(child2Data);

        childElement.addElement(subChildElement);
        elements.add(childElement);
        elements.add(child2Element);
        return elements;
    }
}