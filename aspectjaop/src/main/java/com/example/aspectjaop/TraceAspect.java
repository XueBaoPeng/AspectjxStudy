package com.example.aspectjaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @des:
 * 1、我们声明了两个作为 pointcuts 的 public 方法，筛选出所有通过 “org.android10.gintonic.annotation.DebugTrace” 注解的方法和构造函数。
2、我们使用 “@Around” 注解定义了“weaveJointPoint(ProceedingJoinPoint joinPoint)”方法,使我们的代码注入在使用”@DebugTrace”注解的地方生效。
3、“Object result = joinPoint.proceed();”这行代码是被注解的方法执行的地方，相当于onMeasure执行的地方。因此，在此之前，我们启动我们的计时类计时，在这之后，停止计时。
4、最后，我们构造日志信息，用 Android Log 输出。
 * @date: 2018/4/21 17:37
 */
public class TraceAspect {
    private static final String POINTCUT_METHOD =
            "execution(@org.android10.gintonic.annotation.DebugTrace * *(..))";

    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@org.android10.gintonic.annotation.DebugTrace *.new(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {}

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedDebugTrace() {}

    @Around("methodAnnotatedWithDebugTrace() || constructorAnnotatedDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法信息对象
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取当前对象
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        //获取当前对象，通过反射获取类别详细信息
        //String className2 = joinPoint.getThis().getClass().getName();

        //初始化计时器
        final StopWatch stopWatch = new StopWatch();
        //开始监听
        stopWatch.start();
        //调用原方法的执行。
        Object result = joinPoint.proceed();
        //监听结束
        stopWatch.stop();

        DebugLog.log(className, buildLogMessage(methodName, stopWatch.getTotalTimeMillis()));

        return result;
    }

    /**
     * Create a log message.
     *
     * @param methodName A string with the method name.
     * @param methodDuration Duration of the method in milliseconds.
     * @return A string representing message.
     */
    private static String buildLogMessage(String methodName, long methodDuration) {
        StringBuilder message = new StringBuilder();
        message.append("Gintonic --> ");
        message.append(methodName);
        message.append(" --> ");
        message.append("[");
        message.append(methodDuration);
        message.append("ms");
        message.append("]");

        return message.toString();
    }
}
