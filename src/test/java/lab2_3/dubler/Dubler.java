package lab2_3.dubler;

import java.lang.reflect.Proxy;

public class Dubler {

	static DoublerInvocationHandler lastDoublerInvocationHandler;

	@SuppressWarnings("unchecked")
	public static <T> T dubler(Class<T> clazz) {
		DoublerInvocationHandler invocationHandler = new DoublerInvocationHandler();
		T proxy = (T) Proxy.newProxyInstance(Dubler.class.getClassLoader(), new Class[] { clazz }, invocationHandler);
		return proxy;
	}

	public static <T> When<T> when(T obj) {
	    lastDoublerInvocationHandler.shouldContTimes = false;
		return new When<>();
	}

	public static class When<T> {

		public void thenReturn(T retObj) {
			lastDoublerInvocationHandler.setReturnObj(retObj);
			lastDoublerInvocationHandler.shouldContTimes = true;
		}

	}

	public static <T> boolean verifyTimes(T obj, int times) {
	    DoublerInvocationHandler.DublerData data = lastDoublerInvocationHandler.getLastDoublerData();
        if (data == null) {
            return times == 0;
        }
        // Remove last call in verify
        data.decrementTimesCalled();
        return times == data.getTimesCalled();
	}
	
	public static <T> boolean verifyArgs(T obj, int times) {
	    DoublerInvocationHandler.DublerData data = lastDoublerInvocationHandler.getLastDoublerData();
        if (data == null) {
            return times == 0;
        }
        // Remove last call in verify
        data.decrementTimesCalled();
        return times == data.getTimesCalled();
	}

}
