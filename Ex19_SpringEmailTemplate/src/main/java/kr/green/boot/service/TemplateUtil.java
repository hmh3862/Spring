package kr.green.boot.service;

import java.util.Map;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.spring.VelocityEngineUtils;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

public class TemplateUtil {
    public static String getVelocityTemplateContent(Map<String, Object> model, String viewName){
    	Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        VelocityEngine engine = new VelocityEngine(props);
        
        StringBuffer content = new StringBuffer();
        try{
            content.append(VelocityEngineUtils.mergeTemplateIntoString(engine, "/vetemplates/"+viewName,"UTF-8", model));
        }catch(Exception e){
            System.out.println("Exception occured while processing velocity template:"+e.getMessage());
        }
        return content.toString();
    }
 
    public static String getFreeMarkerTemplateContent(Map<String, Object> model, String viewName){
    	FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("/fmtemplates/");
        StringBuffer content = new StringBuffer();
        try{
         content.append(FreeMarkerTemplateUtils.processTemplateIntoString(bean.createConfiguration().getTemplate(viewName,"UTF-8"), model));
        }catch(Exception e){
            System.out.println("Exception occured while processing fmtemplate:"+e.getMessage());
        }
        return content.toString();
    }

}
