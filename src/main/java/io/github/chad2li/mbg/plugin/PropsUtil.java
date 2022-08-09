package io.github.chad2li.mbg.plugin;

import cn.hutool.core.util.StrUtil;

/**
 * Props工具类
 *
 * @author chad
 * @since 1 create by chad at 2022/8/9 16:05
 */
public class PropsUtil {
    /**
     * 按Java规范大写字符串
     * <p>
     * 以大定字母分割并用“_”拼接，将所有字母转大写，使期符合Java常量规范，
     * 如果有连续多个字母大小，仅第1个分割，如 URL -> URL, picURL -> PIC_URL
     * </p>
     *
     * @param str 字符串
     * @return 以大写字母分割，将所有字母转大写
     * @date 2022/8/9 16:05
     * @author chad
     * @since 1 by chad at 2022/8/9
     */
    public static String upperCase(String str) {
        if (StrUtil.isBlank(str)) {
            return "";
        }

        char[] chars = str.toCharArray();
        int len = chars.length;
        // 标志是否需要拆分
        boolean isCanSplit = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c >= 97 && c <= 122) {
                // 小写转大写
                // 只有遇到一个小写字母后，才可以分割
                isCanSplit = true;
                sb.append((char) (c - 32));
                continue;
            }

            if (c < 65 || c > 90) {
                // 即不是大写也不是小写=不是字母
                sb.append(c);
            }

            // 大写
            else if (!isCanSplit) {
                // 不可以分割
                sb.append(c);
            } else if (0 != i) {
                // 不是第1个
                sb.append("_").append(c);
            }
            // 其他情况不允许分割
            isCanSplit = false;
        }

        return sb.toString();
    }
}
