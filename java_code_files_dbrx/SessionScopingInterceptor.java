package com.mycompany.interceptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.DefaultActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SessionScopingInterceptor extends AbstractInterceptor implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private List<String> beans;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

        if (!(applicationContext instanceof ConfigurableApplicationContext)) {
            throw new IllegalArgumentException("'applicationContext' must be ConfigurableApplicationContext");
        }

        ConfigurableApplicationContext configurableContext = (ConfigurableApplicationContext) applicationContext;
        ConfigurableListableBeanFactory beanFactory = configurableContext.getBeanFactory();

        // Collect session-scoped beans
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        this.beans = new ArrayList<>();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if ("session".equals(beanDefinition.getScope())) {
                beans.add(beanName);
            }
        }

        if (beans.isEmpty()) {
            throw new BeanCreationException("No session-scoped beans found.");
        }
    }

    @Override
    public String intercept(final ActionInvocation actionInvocation) throws Exception {

        final DefaultActionInvocation invocation = (DefaultActionInvocation) actionInvocation;

        for (String sessionScopedBeanName : beans) {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                HttpSession session = ((ServletRequestAttributes) requestAttributes).getRequest().getSession();
                ActionProxy actionProxy = invocation.getProxy();
                Object bean = applicationContext.getBean(sessionScopedBeanName);
                session.setAttribute(sessionScopedBeanName, bean);
            }
        }

        return invocation.invoke();
    }

    public static void main(String[] args) {
    }
}