package com.yanqingshan.admin.common.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yanqs
 * @date 2023年04月21日 18:24
 */
public class SetUtils {
    @SafeVarargs
    public static <T> Set<T> asSet(T... objs) {
        return new HashSet<>(Arrays.asList(objs));
    }
}
