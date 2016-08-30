package org.smart.chapter3.service.impl;

import org.smart.chapter3.service.BookService;
import org.smart.framework.annotation.Service;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public void test() {
		System.err.println("BookServiceImpl implements BookService test");
	}

}
