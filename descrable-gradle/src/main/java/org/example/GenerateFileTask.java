package org.example;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.internal.impldep.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class GenerateFileTask extends DefaultTask {
    private File filePath;

    @Input
    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

    @OutputFile
    public File getOutputFile() {
        return new File(getProject().getBuildDir(), "output.txt");
    }

    @TaskAction
    public void generateFile() throws IOException {
        String content = "This is the content of the generated file.";
        var file = getOutputFile();
        file.getParentFile().mkdirs();
        FileUtils.writeStringToFile(file,content);
        System.out.println("File generated at " + getOutputFile().getAbsolutePath());
    }
}