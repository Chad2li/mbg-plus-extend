package io.github.chad2li.mbg.plugin;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * PropsUtilTest
 *
 * @author chad
 * @since 1 create by chad at 2022/8/9 16:29
 */
public class PropsUtilTest extends TestCase {

    public void testUpperCase() {
        String origin = null;
        String result = null;

        // 1. null
        origin = null;
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("", result);

        // 1.2 blank
        origin = " ";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("", result);

        // 2.1 none upper
        origin = "abc";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("ABC", result);

        // 3.1 upper first
        origin = "Abc";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("ABC", result);
        // 3.2 首部连续
        origin = "ABc";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("ABC", result);

        // 4.1 upper last
        origin = "abC";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("AB_C", result);
        // 4.2 upper last
        origin = "aBC";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("A_BC", result);

        // 5.1 middle upper
        origin = "aBc";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("A_BC", result);

        // 5.2 中间连续
        origin = "aBCd";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("A_BCD", result);

        // 6.1 特殊字符-连续大写的中间
        origin = "aB-Cd";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("A_B-CD", result);

        // 6.2 特殊字符-连续小写的中间
        origin = "Ab-cD";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("AB-C_D", result);

        // 6.3 特殊字符-前大写后小写
        origin = "aB-cD";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("A_B-C_D", result);

        // 6.4 特殊字符-前小写后大写
        origin = "aBc-DeF";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("A_BC-DE_F", result);

        // 7.1 中文
        origin = "aBc中文";
        result = PropsUtil.upperCase(origin);
        Assert.assertEquals("A_BC中文", result);
    }
}