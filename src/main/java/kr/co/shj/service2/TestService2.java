package kr.co.shj.service2;

import org.springframework.stereotype.Service;

@Service
public class TestService2 {
	
	public void myCfoo() {
		System.out.println("myCService 호출함 ---> joinPoint");
	}
	
	public void doDGoo() {
		System.out.println("doDService 호출함 ---> joinPoint");
	}
}
