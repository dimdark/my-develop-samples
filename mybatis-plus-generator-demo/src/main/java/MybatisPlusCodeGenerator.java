import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考官方文档: https://mp.baomidou.com/config/generator-config.html#fileoutconfiglist
 * mybatis-plus的使用配置: https://mp.baomidou.com/config/#automappingbehavior
 *
 * @author dimdark
 */
public class MybatisPlusCodeGenerator {


    public static void main(String[] args) {
        // 自动代码生成器的实现类
        // 其需要六大方面的配置（详细信息请看源码）
        // DataSourceConfig数据源配置 StrategyConfig数据表配置 PackageConfig包配置
        // TemplateConfig模板配置 GlobalConfig全局配置 InjectionConfig自定义注入配置
        AutoGenerator mpg = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(CodeGeneratorConfiguration.URL);
        dataSourceConfig.setDriverName(CodeGeneratorConfiguration.DRIVER_NAME);
        dataSourceConfig.setUsername(CodeGeneratorConfiguration.USERNAME);
        dataSourceConfig.setPassword(CodeGeneratorConfiguration.PASSWORD);
        // 以下四个选项基本很少用到
        // 针对 Postgre SQL, 暂时并不清楚该字段的作用
        //dataSourceConfig.setSchemaName("public");
        // 设置数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL);
        // 数据库详细信息，详细情况参考IDbQuery接口及其实现类
        dataSourceConfig.setDbQuery(new MySqlQuery());
        // 应用层类型到数据库类型的转换，详细情况参考ITypeConvert接口及其实现类
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        mpg.setDataSource(dataSourceConfig);

        // 数据表配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 跳过视图
        strategyConfig.setSkipView(true);
        // 表名 到 实体类名 的转换规则
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 可能用于去掉前缀，猜测的，需要验证
        //strategyConfig.setTablePrefix();
        //strategyConfig.setFieldPrefix();
        // 最主要的功能应该是代码复用
        //strategyConfig.setSuperEntityClass();
        //strategyConfig.setSuperEntityColumns();
        //strategyConfig.setSuperControllerClass();
        // 以下三个选项均有默认值，一般不需要更改
        //strategyConfig.setSuperServiceClass();
        //strategyConfig.setSuperServiceImplClass();
        //strategyConfig.setSuperMapperClass();
        // 需要（或不需要）生成实体类的表的集合
        // 一般来说只会出现任一项
        strategyConfig.setInclude(CodeGeneratorConfiguration.INCLUDE_TABLE_NAMES);
        //strategyConfig.setExclude();
        strategyConfig.setEntityLombokModel(CodeGeneratorConfiguration.LOMBOK_USE);
        // todo dimdark StrategyConfig剩余两个属性还没使用
        mpg.setStrategy(strategyConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(CodeGeneratorConfiguration.COMMON_PACKAGE_NAME);
        // 一般不设置模块名
        //packageConfig.setModuleName("");
        // 以下这些选项均有默认值，不需要设置
        //packageConfig.setEntity();
        //packageConfig.setMapper();
        //packageConfig.setXml();
        //packageConfig.setService();
        //packageConfig.setServiceImpl();
        //packageConfig.setController();
        mpg.setPackageInfo(packageConfig);

        // 模板配置
        // 不需要生成的代码就在这里配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setController(null);
        // 一般保持默认配置即可
        mpg.setTemplate(templateConfig);


        // 自定义注入配置
        // 很少需要使用自定义注入配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        // 将Mapper的xml文件放在resources目录下
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return System.getProperty("user.dir") + "/src/main/resources/mapper/" +
                        tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        // 自动覆盖旧文件
        globalConfig.setFileOverride(true);
        globalConfig.setOpen(true);
        // 是否开启mybatis的二级缓存
        globalConfig.setEnableCache(false);
        globalConfig.setAuthor("dimdark");
        // 剩下的一些选项很少用到, 需要使用时看看GlobalConfig的源代码即可
        mpg.setGlobalConfig(globalConfig);

        // 开始生成代码
        mpg.execute();
    }


}














