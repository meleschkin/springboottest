package org.meleschkin.utils;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class CommonsLangUtils {

    private CommonsLangUtils() {
    }

    public static ToStringStyle getToStringStyle() {
        final StandardToStringStyle tss = new StandardToStringStyle();
        tss.setContentStart(" [");
        tss.setFieldSeparator(System.lineSeparator() + "  ");
        tss.setFieldSeparatorAtStart(true);
        tss.setContentEnd(System.lineSeparator() + "]");
        tss.setUseShortClassName(false);
        tss.setUseIdentityHashCode(false);
        return tss;
    }

    public static String baseToString(final Object obj) {
        final ReflectionToStringBuilder tsb = new ReflectionToStringBuilder(obj, CommonsLangUtils.getToStringStyle());
        tsb.setAppendStatics(false);
        tsb.setAppendTransients(false);
        return tsb.toString();
    }

    public static String baseToString(final Object obj, final String[] excludeFieldNames) {
        final ReflectionToStringBuilder tsb = new ReflectionToStringBuilder(obj, CommonsLangUtils.getToStringStyle());
        tsb.setAppendStatics(false);
        tsb.setAppendTransients(false);
        return tsb.setExcludeFieldNames(excludeFieldNames).toString();
    }
}
