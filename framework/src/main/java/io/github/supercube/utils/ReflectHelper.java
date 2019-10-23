package io.github.supercube.utils;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;


public final class ReflectHelper {

    public static Field getFieldByFieldName(Object obj, String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException localNoSuchFieldException) {
            }
        }
        return null;
    }

    public static Field getFieldByFieldName(Class<?> clazz, String fieldName) {
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException localNoSuchFieldException) {
            }
        }
        return null;
    }

    public static Object getValueByFieldName(Object obj, String fieldName) throws SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null) {
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        if (field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }
    }

    public static final void getDeclaredFields(Class<?> clazz, List<Field> list) {
        Field[] declaredFields = clazz.getDeclaredFields();
        Field[] arrayOfField1;
        int j = (arrayOfField1 = declaredFields).length;
        for (int i = 0; i < j; i++) {
            Field field = arrayOfField1[i];
            list.add(field);
        }
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            getDeclaredFields(superclass, list);
        }
    }

    public static final String toString(Object entity) {
        return ReflectionToStringBuilder.toString(entity);
    }

    public static Method getAccessibleMethod(Object obj, String methodName, Class<?>... parameterTypes) {
        Assert.notNull(obj, "object can't be null");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
                .getSuperclass()) {
            try {
                Method method = superClass.getDeclaredMethod(methodName, parameterTypes);
                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException localNoSuchMethodException) {
            }
        }
        return null;
    }
}
