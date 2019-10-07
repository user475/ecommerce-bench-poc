package com.virtusa.ecommerce;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class ApplicationInitializerImpl extends AbstractAnnotationConfigDispatcherServletInitializer  {

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebSecurityConfiguration.class, AppConfig.class };
	}//

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { WebAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
