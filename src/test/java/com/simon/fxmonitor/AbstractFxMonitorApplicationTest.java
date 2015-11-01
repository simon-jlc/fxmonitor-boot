/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.simon.fxmonitor;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.simon.fxmonitor.AbstractFxMonitorApplicationTest.TestConfig;
import com.simon.fxmonitor.test.ExcludedFromITests;

/**
 * @author Oliver Gierke
 */
@SpringApplicationConfiguration(classes = TestConfig.class)
@Transactional
public abstract class AbstractFxMonitorApplicationTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Configuration
	@EnableAutoConfiguration
	@ComponentScan(basePackages="com.simon.fxmonitor", 
	excludeFilters={
		@ComponentScan.Filter(value=FxmonitorApplication.class, type=FilterType.ASSIGNABLE_TYPE),
		@ComponentScan.Filter(value=ExcludedFromITests.class, type=FilterType.ANNOTATION)
	})
	static class TestConfig {

	}

//	@BeforeTransaction
//	public void setupData() throws Exception {
//		deleteFromTables("job_message", "job", "job_error", "process_categories", 
//				"process", "team", "job_status", "job_filter", "category", "project");
//		executeSqlScript("classpath:sql/data.sql", false);
//	}
}
