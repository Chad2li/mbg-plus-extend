package io.github.chad2li.mbg.plugin;

import io.github.chad2li.mbg.plugin.dao.EmpDo;
import io.github.chad2li.mbg.plugin.mapper.EmpMapper;
import org.junit.Test;
import org.mybatis.generator.api.ShellRunner;
import tk.mybatis.mapper.entity.Example;

/**
 * @author chad
 * @since 1 create by chad at 2022/6/8 00:51
 */
public class PropsPluginTest {

    @Test
    public void addProps() {
        // 生成dao文件
        String[] args = new String[]{"-configfile", "src/test/resources/generatorConfig.xml", "-overwrite"};
        ShellRunner.main(args);
    }

    public void test() {
        EmpMapper empMapper = null;

        Example ex = new Example(EmpDo.class);
        ex.createCriteria()
        .andEqualTo(EmpDo.Props.NAME, "ZhangSan");

        EmpDo emp = empMapper.selectOneByExample(ex);
    }
}