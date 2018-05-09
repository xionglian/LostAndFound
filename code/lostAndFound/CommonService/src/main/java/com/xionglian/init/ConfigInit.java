package com.xionglian.init;

import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.servlet.MultipartConfigElement;
import java.util.Properties;

@Configuration
@Slf4j
public class ConfigInit
{
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void sqlSessionFactoryBean(){
        PageInterceptor interceptor = new PageInterceptor();
        Properties props = new Properties();
        props.setProperty("reasonable", "true");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("offsetAsPageNum","true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        props.setProperty("rowBoundsWithCount","true");
        interceptor.setProperties(props);
        //添加分页拦截器
        sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public MultipartConfigElement multipartConfigElement()
    {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大设置KB，MB
        factory.setMaxFileSize("3MB");
        //设置上传数据总大小
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }

}
