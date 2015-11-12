package container;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectsLogger {

//	@Pointcut("execution(* *getdataReader(..)")
//	private void readerLogger() {
//	}

	@Before("execution(* *getdataReader(..))")
	public void logBeforeReader(JoinPoint joinPoint) {
		System.out.println("It began the process of reading a file");
	}
	
	@Before("execution(* *addAndViewFolders(..))")
	public void logBeforeAddAndViewFolders(JoinPoint joinPoint) {
		System.out.println("It began the process of adding Folder");
	}
	
	@After("execution(* *getdataReader(..))")
	public void logAfterReader(JoinPoint joinPoint) {
		System.out.println("The reading process is successful");
	}
	
	@AfterThrowing("execution(* *getdataReader(..))")
	public void logAfterReaderThrowing(JoinPoint joinPoint) {
		System.out.println("Error reading from file");
	}
	
	@AfterReturning("execution(* *getNewsStorage(..))")
	public void logAfterReturningNewsObject(JoinPoint joinPoint) {
		System.out.println("Formed and returned an object News");
	}
}

