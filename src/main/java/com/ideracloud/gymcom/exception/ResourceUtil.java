package com.ideracloud.gymcom.exception;


import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ResourceUtil {

    public static String getMessage(String msg) {
        Locale locale = LocaleContextHolder.getLocale();
        return "";
    }

    public static String getMessage(String msg, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return "";
    }
}

