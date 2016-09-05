package org.smart.framework;

import org.smart.framework.helper.AopHelper;
import org.smart.framework.helper.BeanHelper;
import org.smart.framework.helper.ClassHelper;
import org.smart.framework.helper.ControllerHelper;
import org.smart.framework.helper.IocHelper;
import org.smart.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 * @author HP
 *
 */
public final class HelperLoader {

	public static void init(){
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHelper.class,
				AopHelper.class,
				IocHelper.class,
				ControllerHelper.class
		};
		for(Class<?> cls : classList){
			ClassUtil.loadClass(cls.getName(), true);
		}
	}
}
