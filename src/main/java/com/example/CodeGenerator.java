package com.example;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    public static String scanner(String tip){
        Scanner scanner =new Scanner(System.in);
        StringBuilder help=new StringBuilder();
        help.append("请输入"+tip+":");
        System.out.println(help.toString());
        if(scanner.hasNext()){
            String ipt=scanner.next();
            if(StringUtils.isNotBlank(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的"+tip+"!");
    }
    public static void main(String[] args){
        //代码生成器
        AutoGenerator mpg=new AutoGenerator();
        //全局配置
        GlobalConfig gc=new GlobalConfig();
        String projectPath=System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");//代码生成存放位置
//        gc.setFileOverride(true);
//        gc.setActiveRecord(false);
//        gc.setEnableCache(false);// XML 二级缓存
//        gc.setBaseResultMap(true);// XML ResultMap
//        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("zhuhui");
        gc.setOpen(false);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
      //  dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");//数据库用户名
        dsc.setPassword("zhu.5201314");//数据库密码
        dsc.setUrl("jdbc:mysql://localhost:3306/music?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");//数据库连接地址
        mpg.setDataSource(dsc);
        //包配置
        PackageConfig pc=new PackageConfig();
        pc.setParent("com.example");
        mpg.setPackageInfo(pc);
        //自定义配置
        InjectionConfig cfg=new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        //模板引擎是freemarker
        String templatePath ="/templates/mapper.xml.ftl";
        //如果模板引擎是velocity
        //String templatePath="/templates/mapper.xml.vm";
        //自定义输出配置
        List<FileOutConfig> focList=new ArrayList<>();
        //自定义配置会被优先输出
        focList.add(new FileOutConfig() {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath+"/src/resources/mapper/"+pc.getModuleName()
                        +"/"+tableInfo.getEntityName()+"Mapper"+ StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        //配置模板
        TemplateConfig templateConfig=new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        //配置策略
        StrategyConfig strategy=new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        strategy.setSuperControllerClass("BaseController");
//        strategy.setSuperEntityColumns("id","created","updated","statu");
        strategy.setInclude(scanner("表名,多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }
}
