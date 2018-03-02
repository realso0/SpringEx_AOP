package kr.co.shj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.shj.dao.TestDao;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	//reflection 공부
	//실제 사용자가 호출하려고 했었던 joinpoint가 된다. testService1 이 joinpoint
	//AOP를 사용함에 따라서 프록시에 의해 대신 호출된다.(proceed() 메소드로 호출 시 testService1이 호출 됨.)
	public String testService1() {
		System.out.println("Service 실행 ---> joinpoint");
		
		return "Hello";
	}
	
	public String doBService() { //pointcut으로 설정됨.
		System.out.println("Service 실행---> joinpoint");
		
		return "Hello";
	}
}
