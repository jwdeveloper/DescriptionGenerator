package io.github.jwdeveloper.dg.implementation;

import io.github.jwdeveloper.dg.api.DescriptionDecorator;
import io.github.jwdeveloper.dg.api.DescriptionGenerator;
import io.github.jwdeveloper.dg.api.DescriptionRenderer;
import io.github.jwdeveloper.dg.api.elements.Element;
import io.github.jwdeveloper.dg.api.elements.ElementData;
import io.github.jwdeveloper.dg.api.elements.ElementType;
import io.github.jwdeveloper.dg.implementation.element.ElementImpl;
import io.github.jwdeveloper.dg.implementation.element.ElementsFactoryImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DescriptionGeneratorImpl implements DescriptionGenerator {
    private final List<DescriptionRenderer> renderers;
    private final List<DescriptionDecorator> decorators;

    public DescriptionGeneratorImpl(List<DescriptionRenderer> renderers,
                                    List<DescriptionDecorator> decorators) {
        this.renderers = renderers;
        this.decorators = decorators;
    }

    public Set<Path> generate(String path) {
        var data = new ElementData();
        data.setElementType(ElementType.ROOT);
        var root = new ElementImpl(data);
        var factory = new ElementsFactoryImpl();
        for (var decorator : decorators) {
            decorator.decorate(root, factory);
        }
        var descriptions = new HashMap<Path, String>();
        for (var renderer : renderers) {
            var output = getRender(root, renderer);
            var descriptionPath = Paths.get(path, renderer.getFileName());
            descriptions.put(descriptionPath, output);
        }
        try {
            Files.createDirectories(Paths.get(path));
            for (var entrySet : descriptions.entrySet()) {
                Files.write(entrySet.getKey(), entrySet.getValue().getBytes());
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to generate Descriptions", e);
        }
        return descriptions.keySet();
    }


    public String getRender(Element root, DescriptionRenderer descriptionRenderer) {
        var builder = new TextBuilderImpl();
        for (var element : root.getElements()) {
            var out = getRenderOutput(element, descriptionRenderer);
            builder.text(out);
        }
        return builder.build();
    }


    public String getRenderOutput(Element element, DescriptionRenderer descriptionRenderer) {
        var elementRenderers = descriptionRenderer.getElementRenderers();

        if (!descriptionRenderer.onElementValidation(element)) {
            return "";
        }
        var openTextBuilder = new TextBuilderImpl();
        var beforeTextBuilder = new TextBuilderImpl();
        var afterChildren = new TextBuilderImpl();
        var closeTextBuilder = new TextBuilderImpl();
        var childContents = new ArrayList<String>();
        for (var renderer : elementRenderers) {
            if (!renderer.onElementValidation(element)) {
                continue;
            }
            renderer.onElementOpen(openTextBuilder, element);
            renderer.onBeforeEachChild(beforeTextBuilder, element);
            renderer.onAfterEachChild(afterChildren, element);
            renderer.onElementClose(closeTextBuilder, element);

            for (var child : element.getElements()) {
                var childContent = getRenderOutput(child, descriptionRenderer);
                childContents.add(childContent);
            }
        }

        var result = new TextBuilderImpl();
        result.text(openTextBuilder);
        for (var content : childContents) {
            result.text(beforeTextBuilder.toString());
            result.text(content);
            result.text(afterChildren.toString());
        }
        result.text(closeTextBuilder);

        return result.toString();
    }
}
