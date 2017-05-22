
/********************************************************************************
*  深圳新荷科技有限公司
*  此代码未经允许，任何私人及企业不得进行使用
*  2017 新荷科技
* ******************************************************************************/
package com.spring.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * 
 * SpringBootStartApplication
 *
 * @author zhouqiang
 * @date 2017年5月15日
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Application.class);
    }
}