package lab2_3.dubler;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Dubler {

	private static DoublerInvocationHandler lastDoublerInvocationHandler;
	private static List<DoublerInvocationHandler> invocationHanders = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public static <T> T dubler(Class<T> clazz) {
		DoublerInvocationHandler invocationHandler = new DoublerInvocationHandler();
		T proxy = (T) Proxy.newProxyInstance(Dubler.class.getClassLoader(), new Class[] { clazz }, invocationHandler);
		return proxy;
	}

	public static <T> When<T> when(T obj) {
		lastDoublerInvocationHandler.setCountTimes(false);
		return new When<>();
	}

	public static class When<T> {

		public void thenReturn(T retObj) {
			lastDoublerInvocationHandler.setReturnObj(retObj);
			lastDoublerInvocationHandler.setCountTimes(true);
		}

	}

	static void setLastInvocationHanlder(DoublerInvocationHandler lastDoublerInvocationHandler) {
		Dubler.lastDoublerInvocationHandler = lastDoublerInvocationHandler;
		invocationHanders.add(lastDoublerInvocationHandler);
	}

	public static boolean verifyTimes(Object obj, int times) {
		DublerData data = lastDoublerInvocationHandler.getLastDoublerData();
		if (data == null) {
			return times == 0;
		}
		// Remove last call in verify
		data.decrementTimesCalled();
		return times == data.getTimesCalled();
	}
}
