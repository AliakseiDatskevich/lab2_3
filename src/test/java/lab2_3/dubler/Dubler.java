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
		return new When<>();
	}

	public static class When<T> {

		public void thenReturn(T retObj) {
			lastDoublerInvocationHandler.setReturnObj(retObj);
		}

	}

}
