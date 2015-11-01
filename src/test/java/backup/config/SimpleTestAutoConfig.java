package backup.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
		@ComponentScan.Filter(value=FxmonitorApplication.class, type=FilterType.ASSIGNABLE_TYPE),
		@ComponentScan.Filter(value=ExcludedFromITests.class, type=FilterType.ANNOTATION)
	})
@EnableAutoConfiguration
//@EnableJpaRepositories(="com.simon.fxmonitor.domain")
public class SimpleTestAutoConfig {

}
