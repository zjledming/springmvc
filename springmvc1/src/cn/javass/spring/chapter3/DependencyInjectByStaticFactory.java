//æ≤Ã¨π§≥ß¿‡
package cn.javass.spring.chapter3;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import cn.javass.spring.chapter3.helloworld.HelloImpl3;

public class DependencyInjectByStaticFactory {
	public static HelloApi newInstance(String message, int index) {
		return new HelloImpl3(message, index);
	}
}