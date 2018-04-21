package com.example.aspectjaop;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @des:
 * @author: 薛宝鹏
 * @date: 2018/4/21 16:39
 */

@Aspect
public class TestAspectj {
    private static final String METHOD_EXECUTION = "execution(* *..MainActivity+.onCreate(..))";

    private static final String METHOD_CALL = "call(* *..MainActivity+.test(..)) && args(name)";

    private String TAG = "TestAspectj";

    @Pointcut(METHOD_EXECUTION)
    public void methodExecution() {
    }

    @Pointcut(METHOD_CALL)
    public void methodCall(String name) {

    }

    @Around("methodExecution()")
    public void aroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
        String result = "-----------------------------MethodExecution";
        Log.e(TAG, result);
    }

    @Around("methodCall(String)")
    public Object arouneMethodCall(ProceedingJoinPoint joinPoint){
        String name = (String) joinPoint.getArgs()[0];
        Log.e(TAG,name);
        return name;
    }

    @Before("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable{
        String key =joinPoint.getSignature().toString();
        Log.e(TAG,"onActivityMethodBefore"+key);

    }

    @After("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodAfter(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodAfter: " + key);
    }

}
