package cn.javass.spring.chapter3.bean;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class HelloApiDecorator implements HelloApi {
	private HelloApi helloApi;

	// �ղι�����
	public HelloApiDecorator() {
	}

	// �вι�����
	public HelloApiDecorator(HelloApi helloApi) {
		this.helloApi = helloApi;
	}

	public void setHelloApi(HelloApi helloApi) {
		this.helloApi = helloApi;
	}

	@Override
	public void sayHello() {
		System.out.println("==========װ��һ��===========");
		helloApi.sayHello();
		System.out.println("==========װ��һ��===========");
	}
}