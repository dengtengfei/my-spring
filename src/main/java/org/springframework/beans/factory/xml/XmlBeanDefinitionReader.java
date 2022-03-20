package org.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/19 16:26
 * 4
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    protected XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinition(inputStream);
            }
        } catch (IOException e) {
            throw new BeansException("IOException throw in parsing XML document from " + resource, e);
        }
    }

    protected void doLoadBeanDefinition(InputStream inputStream) {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                if (BEAN_ELEMENT.equals(node.getNodeName())) {
                    Element bean = (Element) node;
                    String id = bean.getAttribute(ID_ATTRIBUTE);
                    String name = bean.getAttribute(NAME_ATTRIBUTE);
                    String className = bean.getAttribute(CLASS_ATTRIBUTE);

                    Class<?> clazz;
                    try {
                        clazz = Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        throw new BeansException("Can not find class [" + className + "]");
                    }

                    String beanName = StrUtil.isBlank(id) ? name : id;
                    if (StrUtil.isBlank(beanName)) {
                        beanName = StrUtil.lowerFirst(clazz.getSimpleName());
                    }
                    BeanDefinition beanDefinition = new BeanDefinition(clazz);

                    for (int j = 0; j < bean.getChildNodes().getLength(); ++j) {
                        Node propertyNode = bean.getChildNodes().item(j);
                        if (propertyNode instanceof Element) {
                             if (PROPERTY_ELEMENT.equals(propertyNode.getNodeName())) {
                                 Element property = (Element) propertyNode;
                                 String nameAtt = property.getAttribute(NAME_ATTRIBUTE);
                                 String valueAtt = property.getAttribute(VALUE_ATTRIBUTE);
                                 String refAtt = property.getAttribute(REF_ATTRIBUTE);

                                 if(StrUtil.isBlank(nameAtt)) {
                                     throw new BeansException("The name attribute can not be blank");
                                 }

                                 Object value = StrUtil.isNotBlank(refAtt) ? new BeanReference(refAtt) : valueAtt;
                                 beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(nameAtt, value));
                             }
                        }
                    }
                    if (getRegistry().containsBeanDefinition(beanName)) {
                        throw new BeansException("Duplication beanName [" + beanName + "] is not allowed!");
                    }

                    getRegistry().registerBeanDefinition(beanName, beanDefinition);
                }
            }
        }
    }

    @Override
    public void loadBeanDefinitions(String location) {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }
}
