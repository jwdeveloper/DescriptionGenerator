package io.github.jwdeveloper.dg.implementation.element;

import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementData;
import io.github.jwdeveloper.dg.api.elements.ElementType;

import java.util.*;

public class ElementImpl implements Element {

    private final ElementData data;
    private final List<Element> elements;
    private final ElementsFinder elementsFinder;

    public ElementImpl() {
        this(new ElementData());
    }

    public ElementImpl(ElementData data) {
        this.data = data;
        this.elements = new ArrayList<>();
        this.elementsFinder = new ElementsFinder();
    }

    @Override
    public String getName() {
        return data.getName();
    }

    @Override
    public List<String> getTags() {
        return Collections.unmodifiableList(data.getTags());
    }

    @Override
    public void addTag(String tag) {
        data.getTags().add(tag);
    }

    @Override
    public Map<String, Object> getProperties() {
        return Collections.unmodifiableMap(data.getProperties());
    }

    @Override
    public <T> T getProperty(String property) {
        if(!data.getProperties().containsKey(property))
        {
            throw new RuntimeException("element not contains property: "+property);
        }
        return  (T)data.getProperties().get(property);
    }

    @Override
    public void addProperty(String property, Object value) {
        data.getProperties().put(property, value);
    }

    @Override
    public List<Element> getElements() {
        return Collections.unmodifiableList(elements);
    }

    @Override
    public void addElement(Element... elements) {
        for (var element : elements) {
            if (element == this) {
                throw new RuntimeException("Element can not be added to itself");
            }
            this.elements.add(element);
        }
    }

    @Override
    public List<Element> findElements(String elementName, boolean deep) {
        return elementsFinder.findByName(getElements(), elementName, deep);
    }

    @Override
    public List<Element> findElements(String elementName) {
        return findElements(elementName, false);
    }

    @Override
    public Element findElement(String elementName, boolean deep) {
        var elements = findElements(elementName, deep);
        if (elements.size() == 0) {
            throw new RuntimeException("Element " + elementName + " not found in " + getName());
        }
        return elements.get(0);
    }

    @Override
    public Element findElement(String elementName) {
        return findElement(elementName, false);
    }

    @Override
    public boolean hasName() {
        return getName() != null;
    }

    @Override
    public boolean hasProperty(String key) {
        return data.getProperties().containsKey(key);
    }

    @Override
    public boolean hasTag(String tag) {
        return getTags().contains(tag);
    }

    @Override
    public boolean hasElements() {
        return elements.size() != 0;
    }

    @Override
    public boolean hasElementType(ElementType elementType) {
        return data.getElementType().equals(elementType);
    }
}
