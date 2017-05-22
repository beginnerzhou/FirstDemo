package com.spring.demo;

import java.util.ResourceBundle;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.param.ParamQuery;
import com.spring.demo.redis.IRedisDemoService;

@RestController
public class HelloWorldController {
	
	@Value("${spring.profiles.active}")
	private String named ;
	
	
	@Autowired
	private IRedisDemoService redisDemoService;
	
	@ApiOperation(value="测试获得", notes="测试方式")
	@RequestMapping(value="/index/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String index(@PathVariable String name,HttpServletRequest request) {
		 //ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
	      //  String host = resourceBundle.getString("redis.hostname");//redis服务器host
	        System.out.println("hosr::"+this.named);
		if (null == name) {
			name = "boy";
		}
		System.out.println(redisDemoService.getData(name));
		return "hello world " + name;
	}
	
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public String index(ParamQuery query) {

		return "hello world " + query.getName();
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	@ApiOperation(value="测试获得", notes="测试方式")
	@RequestMapping(value="/index1/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String indexupdate(@PathVariable String name){
		if (null == name) {
			name = "boy";
		}
		
		return redisDemoService.updateDefault(name);
	}
	
	@ApiOperation(value="测试获得", notes="测试方式")
	@RequestMapping(value="/index2/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String indexupdate1(@PathVariable String name){
		if (null == name) {
			name = "boy";
		}
		
		return redisDemoService.updateDefault1(name);
	}

	@ApiResponses({ @ApiResponse(code = 200, message = "很好"),
		@ApiResponse(code = 400, message = "Invalid ID supplied"),
	      @ApiResponse(code = 404, message = "Pet not found可以是") })
	@ApiImplicitParam(name = "age", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value="/tsession/{age}",method=RequestMethod.GET)
	@ResponseBody
	public String TestSession(HttpServletRequest req, HttpServletResponse resp,@PathVariable String age){
		req.getSession().setAttribute("age", age);
		String a = (String) req.getSession().getAttribute("age");
		return a;
	}

	/*@ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
	
	
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = new User();
        u.setId(id.toString());
        u.setName(user.getName());
        u.setAge(user.getAge());
        
        return "success";
    }*/
	
}
