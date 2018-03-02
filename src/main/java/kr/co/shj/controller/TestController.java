package kr.co.shj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.shj.service.TestService;
import kr.co.shj.service2.TestService2;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private TestService2 testService2;
	
	@RequestMapping(value="/doA", method=RequestMethod.GET)
	public String doA(Model model) {
		System.out.println("doA 호출)");
		//메소드 이름과 jsp 이름이 같으면, return 안해주어도 내부적으로 doA.jsp를 출력함.
		String serviceResult=testService.testService1();
		model.addAttribute("msg", serviceResult);
		
		return "doA";
	}
	
	@RequestMapping(value="/doB", method=RequestMethod.GET)
	public String doB(Model model) {
		String serviceResult=testService.doBService();
		model.addAttribute("msg", serviceResult);
		
		return "doB";
	}
	
	@RequestMapping(value="/doD", method=RequestMethod.GET)
	public void doD(Model model) {
		testService2.doDGoo();
		testService2.myCfoo();
		
	}
}
