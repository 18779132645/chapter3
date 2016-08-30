package org.smart.chapter3.service;

import org.smart.chapter3.service.impl.BookServiceImpl;
import org.smart.framework.annotation.Impl;

@Impl(value = BookServiceImpl.class)
public interface BookService {

	public void test();
}
