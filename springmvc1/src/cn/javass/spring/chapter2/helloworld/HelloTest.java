package cn.javass.spring.chapter2.helloworld;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter3.bean.ListTestBean;

public class HelloTest {
	@Test
	public void testHelloWorld() {
		// 1、读取配置文件实例化一个IoC容器

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		// 3、执行业务逻辑
		helloApi.sayHello();
	}

	@Test
	public void testInstantiatingBeanByConstructor() {
		// 使用构造器
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
	}

	@Test
	public void testInstantiatingBeanByStaticFactory() {
		// 使用静态工厂方法
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
		bean3.sayHello();
	}

	@Test
	public void testInstantiatingBeanByInstanceFactory() {
		// 使用实例工厂方法
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		HelloApi bean4 = beanFactory.getBean("bean4", HelloApi.class);
		bean4.sayHello();
	}

	@Test
	public void testConstructorDependencyInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		// 获取根据参数索引依赖注入的Bean
		HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
		// 获取根据参数类型依赖注入的Bean
		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
		byType.sayHello();
		// 获取根据参数名字依赖注入的Bean
		HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
		byName.sayHello();
	}

	@Test
	public void testConstructorinstanceFactoryDependencyInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/instanceFactoryDependencyInject.xml");
		// 获取根据参数索引依赖注入的Bean
		HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
		// 获取根据参数类型依赖注入的Bean
		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
		byType.sayHello();
		// 获取根据参数名字依赖注入的Bean
		HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
		byName.sayHello();
	}

	@Test
	public void testConstructorinstancestaticFactoryDependencyInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/staticFactoryDependencyInject.xml");
		// 获取根据参数索引依赖注入的Bean
		HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
		// 获取根据参数类型依赖注入的Bean
		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
		byType.sayHello();
		// 获取根据参数名字依赖注入的Bean
		HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
		byName.sayHello();
	}

	@Test
	public void testbooleanInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/booleanInject.xml");
		// 获取根据参数索引依赖注入的Bean
		HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
	}

	@Test
	public void testListInject() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/listInject.xml");
		ListTestBean listBean = beanFactory.getBean("listBean",
				ListTestBean.class);
		System.out.println(listBean.getValues().size());
		Assert.assertEquals(3, listBean.getValues().size());
	}

}