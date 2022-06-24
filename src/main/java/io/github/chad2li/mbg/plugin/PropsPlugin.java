package io.github.chad2li.mbg.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 生成 Do 对象静态内部类 Props，减少硬编码
 *
 * @author chad
 * @
 * @since 1 create by chad at 2022/6/8 00:18
 */
public class PropsPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addProps(topLevelClass);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addProps(topLevelClass);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addProps(topLevelClass);
        return true;
    }

    /**
     * 给 {@code topLevelClass} 增加 Props 静态内部类，并映射所有属性名，忽略以下类型属性
     * <p>
     * 1. serialVersionUID <br/>
     * 2. 被 transient 标记的  <br/>
     * 3. final 标记的  <br/>
     * 4. static 标记的  <br/>
     * </p>
     *
     * @param topLevelClass
     * @date 2022/6/9 08:22
     * @author chad
     * @since 1 by chad at 2022/6/7
     * @since 2 by chad at 2002/6/9: 跳过 {@link Transient}，增加注释
     */
    protected void addProps(TopLevelClass topLevelClass) {
        InnerClass innerClass = new InnerClass("Props");
        innerClass.setVisibility(JavaVisibility.PUBLIC);
        innerClass.setStatic(true);
        List<Field> fields = topLevelClass.getFields();
        fields.forEach(field -> {
            String fieldName = field.getName();

            if ("serialVersionUID".equalsIgnoreCase(fieldName)) {
                return;
            }
            if (field.isTransient()) {
                return;
            }
            if (field.isFinal()) {
                return;
            }
            if (field.isStatic()) {
                return;
            }
            if (field.getAnnotations().contains(Transient.class)) {
                return;
            }
            if (field.getAnnotations().contains(java.beans.Transient.class)) {
                return;
            }

            Field fieldProp = new Field(fieldName, new FullyQualifiedJavaType("java.lang.String"));

            fieldProp.setVisibility(JavaVisibility.PUBLIC);
            fieldProp.setFinal(true);
            fieldProp.setStatic(true);
            fieldProp.setInitializationString("\"" + fieldName + "\"");
            // 注释
            for (String javaDocLine : field.getJavaDocLines()) {
                fieldProp.addJavaDocLine(javaDocLine);
            }

            innerClass.addField(fieldProp);
        });

        topLevelClass.addInnerClass(innerClass);

        // topLevelClass 增加类注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @author mbg plus extend");
        topLevelClass.addJavaDocLine(" * @since 1 at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        topLevelClass.addJavaDocLine(" */");

        // Props 增加类注释
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * @author mbg plus extend");
        innerClass.addJavaDocLine(" * @since 1 at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        innerClass.addJavaDocLine(" */");
    }
}
