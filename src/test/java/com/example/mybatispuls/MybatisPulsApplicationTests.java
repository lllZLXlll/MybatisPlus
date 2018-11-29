package com.example.mybatispuls;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPulsApplicationTests {
    /**
     * ------------------------------
     * -以下数据需要根据项目情况修改 begin-
     * ------------------------------
     */
    // 绝对项目路径
    private final static String PROJECTPATH = "F:/workspace/mybatis-puls";
    // 作者
    private final static String AUTHOR = "zlx";
    // 顶级包名
    private final static String PARENTPACKAGE = "com.example.mybatispuls";
    // 数据库连接地址
    private final static String URL = "jdbc:mysql://localhost:3306/guns?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
    // 驱动
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    // 账户
    private final static String USERNAME = "root";
    // 密码
    private final static String PASSWORD = "123456";
    // key: 模块名 value: 表名
    private static Map<String, List<String>> tables = new LinkedHashMap<>();
    /**
     * ------------------------------
     * -以下数据需要根据项目情况修改 end-
     * ------------------------------
     */


    private void initTables() {
        List<String> tableNames = new ArrayList<>();
        tableNames.add("sys_user");
        tableNames.add("sys_dept");
        tables.put("sys", tableNames);

        tableNames = new ArrayList<>();
        tableNames.add("code_dbinfo");
        tables.put("code", tableNames);
    }

    @Test
    public void main1() {
        initTables();
        tables.forEach((modeName, list) -> {
            list.forEach(tableName -> {
                createFile(modeName, tableName);
            });
        });
    }

    public void createFile(String modeName, String tableName) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 源文件目录
        gc.setOutputDir(PROJECTPATH + "/src/main/java");
        // 作者
        gc.setAuthor(AUTHOR);
        // 完成生成文件后是否打开项目根路径
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PARENTPACKAGE);
        mpg.setPackageInfo(pc);

        // 生成的包名
        pc.setModuleName(modeName);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义生成Mapper文件名称
                return PROJECTPATH + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 实体类是否使用lombok插件生成get、set、构造函数等
        strategy.setEntityLombokModel(true);
        // 实体类类名上方是否加上表名映射注解
        strategy.setEntityBuilderModel(true);
        // 控制器是否用RestController注解
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tableName);
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
