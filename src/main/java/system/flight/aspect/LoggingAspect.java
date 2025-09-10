package system.flight.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("within(system.flight.controller..*)")
	public void controllerMethods() {
	}

	@Around("controllerMethods()")
	public Object logMethodParametersAndReturn(ProceedingJoinPoint joinPoint) throws Throwable {

		// Log method name and parameters
		Object[] args = joinPoint.getArgs();
		logger.info("Entering: {} with arguments: {}", joinPoint.getSignature().toShortString(), Arrays.toString(args));

		// Proceed with method execution
		Object result = joinPoint.proceed();

		// Log method name and return value
		logger.info("Exiting: {} with return value: {}", joinPoint.getSignature().toShortString(), result);

		return result;
	}
}
