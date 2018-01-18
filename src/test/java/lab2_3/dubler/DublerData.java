package lab2_3.dubler;

import java.lang.reflect.Method;

class DublerData {

	private final DoublerInvocationHandler handler;
	private int timesCalled = 0;
	private final Object[] args;
	private final Method method;
	private final Object retObj;

	DublerData(DoublerInvocationHandler handler, Method method, Object[] args, Object retObj) {
		this.handler = handler;
		this.args = args;
		this.method = method;
		this.retObj = retObj;
	}

	Object[] getArgs() {
		return args;
	}

	Method getMethod() {
		return method;
	}

	Object getRetObj() {
		if (handler.countTimes()) {
			timesCalled++;
		}
		handler.setCountTimes(true);
		return retObj;
	}

	int getTimesCalled() {
		return timesCalled;
	}

	void decrementTimesCalled() {
		timesCalled--;
	}
}