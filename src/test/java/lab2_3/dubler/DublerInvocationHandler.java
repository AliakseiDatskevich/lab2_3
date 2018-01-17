package lab2_3.dubler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DoublerInvocationHandler implements InvocationHandler {

	private Method lastMethod;
	private Object[] lastArgs;
	private List<DublerData> dataHolders = new ArrayList<>();

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Dubler.lastDoublerInvocationHandler = this;
		lastMethod = method;
		lastArgs = args;

		for (DublerData dublerData : dataHolders) {
			if (dublerData.getMethod().equals(method) && Arrays.deepEquals(dublerData.getArgs(), args)) {
				return dublerData.getRetObj();
			}
		}

		// return null if object and false for boolean
		if (method.getReturnType() == boolean.class) {
			return false;
		}
		return null;
	}

	public void setReturnObj(Object retObj) {
		dataHolders.add(new DublerData(lastMethod, lastArgs, retObj));
	}

	private class DublerData {
		private final Object[] args;
		private final Method method;
		private final Object retObj;

		private DublerData(Method method, Object[] args, Object retObj) {
			this.args = args;
			this.method = method;
			this.retObj = retObj;
		}

		private Object[] getArgs() {
			return args;
		}

		private Method getMethod() {
			return method;
		}

		private Object getRetObj() {
			return retObj;
		}
	}

}