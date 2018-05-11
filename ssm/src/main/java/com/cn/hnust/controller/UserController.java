package com.cn.hnust.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cn.hnust.pojo.UserT;
import com.cn.hnust.service.UserTService;




@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserTService userTService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        UserT user=null;
        if (userId==1) {
        	 user = new UserT();  
        	 user.setAge(11);
        	 user.setId(1);
        	 user.setPassword("123");
        	 user.setUserName("javen");
		}
       
        logger.debug(user.toString());
        model.addAttribute("user", user);  
        return "index";
	}
	//看到页面，以及某个字段
	@RequestMapping(value="/showUser",method=RequestMethod.GET)
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        UserT user = this.userTService.getUserById(userId);  
        logger.debug(user.toString());
        model.addAttribute("user", user);  
        return "showUser";
	}
	
	//能直接看到返回的json
	@RequestMapping(value="/jsontype/{id}",method=RequestMethod.GET)  
    public ResponseEntity<UserT>  getUserInJson2(@PathVariable String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        UserT user = this.userTService.getUserById(userId);  
        logger.info(user.toString());
        return new ResponseEntity<UserT>(user,HttpStatus.OK);  
    } 
	
	//文件上传、
    @RequestMapping(value="/upload")
    public String showUploadPage(){
    	return "user_admin/file";
    }
    
    @RequestMapping(value="/doUpload",method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file")MultipartFile file) throws IOException{
    	if (!file.isEmpty()) {
			logger.info("Process file:{}",file.getOriginalFilename());
		}
    	FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\",System.currentTimeMillis()+file.getOriginalFilename()));
    	return "succes";
    }
}
