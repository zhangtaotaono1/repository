package util;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;

public class SystemConfig {

	private static Logger logger = Logger.getLogger(SystemConfig.class
			.getName());

	private static PropertiesConfiguration config;
	static {

		// 实例化一个PropertiesConfiguration

		try {
			config = new PropertiesConfiguration("ins.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 设置reload策略，这里用当文件被修改之后reload（默认5s中检测一次）
		FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();

		strategy.setRefreshDelay(20000);
		config.setReloadingStrategy(strategy);

	}

	public static synchronized String getProperty(String key) {
		return (String) config.getProperty(key);
	}

	public static void main(String[] args) throws InterruptedException {
		for (;;) {
			logger.info(SystemConfig.getProperty("key"));
			Thread.sleep(2000);

		}
	}

}
