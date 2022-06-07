package io.github.chad2li.mbg.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * TODO-类描述
 *
 * @author chad
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

            Field fieldProp = new Field(fieldName, new FullyQualifiedJavaType("java.lang.String"));

            fieldProp.setVisibility(JavaVisibility.PUBLIC);
            fieldProp.setFinal(true);
            fieldProp.setStatic(true);
            fieldProp.setInitializationString("\"" + fieldName + "\"");

            innerClass.addField(fieldProp);
        });

        topLevelClass.addInnerClass(innerClass);
    }
}
