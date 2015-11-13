package container;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectsLogger {

	@Pointcut("execution(* *.getAllNews(..))")
	private void readerLogger() {
	}

	@Before("readerLogger()")
	public void logBeforeReader(JoinPoint joinPoint) {
		System.out.println("It began the process of reading a file");
	}
	
	@Before("execution(* *addAndViewFolders(..))")
	public void logBeforeAddAndViewFolders(JoinPoint joinPoint) {
		System.out.println("It began the process of adding Folder");
	}
	
	@AfterReturning("execution(* *addAndViewFolders(..))")
	public void logAfterReturningAddAndViewFolders(JoinPoint joinPoint) {
		System.out.println("The folder is added");
	}
	
	@After("readerLogger()")
	public void logAfterReader(JoinPoint joinPoint) {
		System.out.println("Formed and returned an object News");
	}
	
	@AfterThrowing("readerLogger()")
	public void logAfterReaderThrowing(JoinPoint joinPoint) {
		System.out.println("Error reading from file");
	}
	
}

