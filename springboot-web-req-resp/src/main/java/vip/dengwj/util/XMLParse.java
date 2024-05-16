package vip.dengwj.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class XMLParse {
    public static <T> List<T> xmlParse(String fileUrl, Class<T> clazz) throws Exception {
        List<T> list = new ArrayList<>();

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();

        List<Class> list1 = new ArrayList<>();
        for (Constructor<?> constructor : declaredConstructors) {
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                Class<?> type = parameter.getType();
                list1.add(type);
            }
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            String fieldName = declaredField.getName();
        }

        Constructor<T> con = clazz.getDeclaredConstructor(list1.toArray(new Class[0]));

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(fileUrl);

        Element rootElement = document.getRootElement();
        // 根所有的子孩子
        List<Element> elements = rootElement.elements();

        // emp
        for (Element element : elements) {
            List<Element> elements1 = element.elements();

            // 传递的数据
            Object[] objects = new Object[list1.size()];
            for (int i = 0; i < elements1.size(); i++) {
                String text = elements1.get(i).getText();
                String simpleName = list1.get(i).getSimpleName();

                Object data;
                // 可以使用 map 方式，Map<String, Function<String, ...>>
                if ("int".equals(simpleName)) {
                    data = Integer.parseInt(text);
                } else if ("Integer".equals(simpleName)) {
                    data = Integer.parseInt(text);
                    // TODO 小数的情况
                } else {
                    data = text;
                }
                objects[i] = data;
            }
            T t = con.newInstance(objects);
            list.add(t);
        }

        return list;
    }
}
