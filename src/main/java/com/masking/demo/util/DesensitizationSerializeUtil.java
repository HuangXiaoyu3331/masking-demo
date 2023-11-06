package com.masking.demo.util;

import cn.hutool.core.text.CharSequenceUtil;

public class DesensitizationSerializeUtil {

    public static String desMobile(String mobile) {
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static String desIdCard(String idCard){
        return idCard.replaceAll("(\\d{3})\\d{13}(\\d{2})", "$1*************$2");
    }

    public static String hide(String str, int start, int end) {
        return CharSequenceUtil.hide(str, start, end);
    }

}
