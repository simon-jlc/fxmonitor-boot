package backup.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.simon.fxmonitor.FxmonitorApplication;
import com.simon.fxmonitor.test.ExcludedFromITests;

/**
 * 
 * @since 26 août 2015
 * @author simon 
 */
@ExcludedFromITests
@Configuration
@ComponentScan(basePackages="com.simon.fxmonitor", 
	excludeFilters={
		@ComponentScan.Filter(value=FxmonitorApplication.class, type=FilterType.ASSIGNABLE_TYPE)
	})
@PropertySource(
		value={
			"classpath:/config/application.properties"
		})
@Import(value=SimpleJpaTestConfig.class)
public class SimpleTestConfig {
	
}
