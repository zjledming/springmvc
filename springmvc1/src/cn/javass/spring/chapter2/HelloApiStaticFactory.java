package cn.javass.spring.chapter2;

import cn.javass.spring.chapter2.HelloImpl2;
import cn.javass.spring.chapter2.helloworld.HelloApi;

public class HelloApiStaticFactory {
	// ��������
	public static HelloApi newInstance(String message) {
		// ������Ҫ��Beanʵ��
		return new HelloImpl2(message);
	}
}