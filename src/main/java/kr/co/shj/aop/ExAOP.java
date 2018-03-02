package kr.co.shj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//AOP 클래스 생성 시
@Component //Component-scan에 의해 만들어진  Bean설정을 위한 어노테이션 
@Aspect //ExAOP 클래스에 'Advice가 들어 있다' 라는 것을 알려줌.
//Aspect : JoinPoint + PointCut (JoinPoint와 PointCut을 묶어서 Aspect로 관리)
public class ExAOP {
	//Advice : 실제 실행 할 수 있는 부가적인 작업(메소드)
	
	@Around("execution(* kr.co.shj.service..test*(..))") //pointcut 만들기(joinPoint가 적용되는 대상을 설정해줌)
	//*은 모든 것을 의미, 그 다음 내가 만든 패키지, ..은 모든 하위 패키지를 의미, test*은 test로 시작하는 모든 메소드를 의미, ..은 0개 이상인 메소드를 의미
	//pointcut 설정이 제대로 되어있는지 확인하기 위한 작업(메소드 앞에 주황색 화살표가 생겨남)
	//around 포인트컷을 활용 할 때는 항상매개변수에 ProceedingJoinPoint가 있어야 한다.
	public Object testAOP1(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("testAOP1 --- Advice 실행함. JoinPoint 실행 직전(아직 안함)");
		
		Object obj=null;
		
		try {
			obj=joinPoint.proceed(); //testService1() 호출
		}finally {
			System.out.println("testAOP1 --- Advice 실행함. joinPoint 실행 이후");
		}
		
		return obj;
	}
	//@Around로 service패키지의 test*메소드에 pointcut 설정해줌으로써 testService1()메소드가 실행될 시 testAOP1이 실행되도록 설정해주었고, 
	//joinPoint 실행인 joinPoint.proceed()(testService1()메소드)의 앞 뒤로 작업을 수행해줌.
	//JoinPoint : 어떤 시점(진입전, 진입후, 예외를 던진 뒤, 결과를 던진 뒤 등)에 해야 할 일을 지정
	
	@Around("execution(* kr.co.shj.service..*BService(..))") //메소드 이름 설정을 이렇게도 표현가능
	public Object doBAOP(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("testdoB --- Advice 실행함. JoinPoint 실행 직전(아직 안함)");
		
		Object obj=null;
		
		try {
			obj=joinPoint.proceed(); //doBService() 호출
		}finally {
			System.out.println("testdoB --- Advice 실행함. joinPoint 실행 이후");
		}
		
		return obj;
	}
	
	//execution은 메소드 이름을 직접 지정해주어야 하지만 within은 패키지 안의 모든 메소드를 지정함.
	@Around("within(kr.co.shj.service2..*)") //service2패키지 안에 있는 모든(*) 메소드를 의미
	public void withInAOP(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("doD --- Advice 실행함. JoinPoint 실행 직전(아직 안함)");
		
		Object obj=null;
		
		try {
			obj=joinPoint.proceed(); //doBService() 호출
		}finally {
			System.out.println("doD --- Advice 실행함. joinPoint 실행 이후");
		}
		
	}
}
