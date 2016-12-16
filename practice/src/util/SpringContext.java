package util;
/**   
* @Title: SpringContext.java 
* @Package com.lc.acct.util 
* @Description: ApplicationContext对象共通操作类
* @author kouken   
* @date 2015-12-24
* @version V1.0   
*/ 

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/** 
* @ClassName: SpringContext
* @Description: ApplicationContext对象共通操作类
* 
*/
public class SpringContext {

	/**
	 * WebApplicationContext
	 */
	private static WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
	
	/**
	 * beanName取得
	 * @param beanName
	 * @return Object
	 */
	public static Object getBean(String beanName) {
		return wac.getBean(beanName);
	}
}
