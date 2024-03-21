package org.yeort.generator;
import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态文件生成器
 * */
public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String inputPath =projectPath+File.separator+ "generator-demo-projects" + File.separator + "acm-template";
        String outputPath = projectPath;
        copyFilesByHutool(inputPath, outputPath);
    }

    /**
     * 使用hutool来进行文件复制
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath){
        FileUtil.copy(inputPath, outputPath,false);
    }
}
