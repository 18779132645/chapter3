package org.smart.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.smart.framework.HelperLoader;

public class testDispatcherServlet {

	@Test
	public void init(){
		HelperLoader.init();
	}
}
