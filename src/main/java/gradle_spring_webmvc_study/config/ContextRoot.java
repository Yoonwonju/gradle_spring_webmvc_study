package gradle_spring_webmvc_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class})
@ComponentScan(basePackages = {"gradle_spring_webmvc_study.controller",
								"gradle_spring_webmvc_study.service",
								"gradle_spring_webmvc_study.spring"})
public class ContextRoot {

}
