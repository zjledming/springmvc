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
		// 1����ȡ�����ļ�ʵ����һ��IoC����

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		// 2���������л�ȡBean��ע��˴���ȫ������ӿڱ�̣�����������ʵ�֡�
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		// 3��ִ��ҵ���߼�
		helloApi.sayHello();
	}

	@Test
	public void testInstantiatingBeanByConstructor() {
		// ʹ�ù�����
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
	}

	@Test
	public void testInstantiatingBeanByStaticFactory() {
		// ʹ�þ�̬��������
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
		bean3.sayHello();
	}

	@Test
	public void testInstantiatingBeanByInstanceFactory() {
		// ʹ��ʵ����������
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		HelloApi bean4 = beanFactory.getBean("bean4", HelloApi.class);
		bean4.sayHello();
	}

	@Test
	public void testConstructorDependencyInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/helloworld.xml");
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
		byType.sayHello();
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
		byName.sayHello();
	}

	@Test
	public void testConstructorinstanceFactoryDependencyInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/instanceFactoryDependencyInject.xml");
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
		byType.sayHello();
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
		byName.sayHello();
	}

	@Test
	public void testConstructorinstancestaticFactoryDependencyInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/staticFactoryDependencyInject.xml");
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
		byType.sayHello();
		// ��ȡ���ݲ�����������ע���Bean
		HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
		byName.sayHello();
	}

	@Test
	public void testbooleanInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/booleanInject.xml");
		// ��ȡ���ݲ�����������ע���Bean
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