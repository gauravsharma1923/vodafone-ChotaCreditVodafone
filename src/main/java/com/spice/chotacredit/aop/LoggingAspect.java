package com.spice.chotacredit.aop;
/*
 * package com.spice.lastthreedetails.aop;
 * 
 * import org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.Logger; import org.aspectj.lang.ProceedingJoinPoint;
 * import org.aspectj.lang.annotation.Around; import
 * org.aspectj.lang.annotation.Aspect; import
 * org.springframework.stereotype.Component; import
 * org.springframework.util.StopWatch; import java.util.Arrays;
 * 
 * @Aspect
 * 
 * @Component public class LoggingAspect { //private static final Logger LOGGER
 * = LogManager.getLogger(LoggingAspect.class); private static final Logger
 * logger = LogManager.getLogger("request");
 * 
 * @Around("execution(* com.spice.lastthreedetails.controller.*.*(..))") public
 * Object logAround(ProceedingJoinPoint joinPoint) throws Throwable { Object
 * className = joinPoint.getTarget().getClass().getName(); long uniqueId =
 * System.currentTimeMillis();
 * logger.info("|Request|{}|{}",uniqueId,Arrays.toString(joinPoint.getArgs()));
 * try { final StopWatch stopWatch = new StopWatch(); stopWatch.start(); Object
 * result = joinPoint.proceed(); stopWatch.stop();
 * logger.info("|Response|{}|{}|",uniqueId,result + ",Execution time: " +
 * stopWatch.getTotalTimeSeconds() + " seconds"); return result; } catch
 * (IllegalArgumentException e) { logger.error("|Exception|{}|{}",uniqueId,
 * Arrays.toString(joinPoint.getArgs()) + " in :" +
 * joinPoint.getSignature().getName() + "()"); throw e; } } }
 */