### 说明
日常开发中，使用 `Example`时，常常出现硬编码属性名称，如下：
```java
Example ex = new Example(EmpDo.class);
ex.createCriteria()
.andEqualTo("name", "ZhangSan");

EmpDo emp = empMapper.selectOneByExample(ex);
```
上面代码，需要硬编码`name`到代码中，如果发生字段调整，会造成不必要的麻烦。    
`MBG`提供了 `MyBatis3DynamicSql` 的targetRuntime，然而它太复杂了，而又不常使用该功能。    
`PropsPlugin`会在`Do`对象中生成静态类，并生成该对象所有属性，利用 `PropsPlugin`，上面代码就会变成：
```java
Example ex = new Example(EmpDo.class);
ex.createCriteria()
.andEqualTo(EmpDo.Props.name, "ZhangSan");

EmpDo emp = empMapper.selectOneByExample(ex);
```
`Props`解决了硬编码问题，而且它特别小巧，也不需要利用 `LambdaQueryWrapper` 动态获取。


### 使用
- 参考    
`src/test/java` : `io.github.chad2li.mbg.plugin.PropsPluginTest` 的 `addProps()` 方法
- `generatorConfig.xml` 19 行    
使用 `PropsPlugin` 插件生成 `Props`    
`<plugin type="io.github.chad2li.mbg.plugin.PropsPlugin"/>`


关于 `MBG` 如何使用，请自行参考 `PropsPluginTest`，网上也有很多教程