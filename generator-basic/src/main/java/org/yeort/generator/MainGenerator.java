package org.yeort.generator;

import freemarker.template.TemplateException;
import org.yeort.model.MainTemplateConfig;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        // 1、静态文件生成
        String projectPath = System.getProperty("user.dir");
        String inputPath =projectPath+ File.separator+ "generator-demo-projects" + File.separator + "acm-template";
        StaticGenerator.copyFilesByHutool(inputPath, projectPath);

        String dynamicInputPath = projectPath + File.separator + "generator-basic" + File.separator +"src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yeort/acm/MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("111yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求sdasdad和结果：");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
