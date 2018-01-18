package lab2_3.dubler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DoublerInvocationHandler implements InvocationHandler {

	private boolean countTimes = true;
	private Method lastMethod;
	private Object[] lastArgs;
	private List<DublerData> dataHolders = new ArrayList<>();

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Dubler.setLastInvocationHanlder(this);
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

	void setReturnObj(Object retObj) {
		dataHolders.add(new DublerData(this, lastMethod, lastArgs, retObj));
	}

	DublerData getLastDoublerData() {
		for (DublerData dublerData : dataHolders) {
			if (dublerData.getMethod().equals(lastMethod) && Arrays.deepEquals(dublerData.getArgs(), lastArgs)) {
				return dublerData;
			}
		}
		return null;
	}
	
	boolean countTimes() {
		return countTimes;
	}
	
	void setCountTimes(boolean value) {
		countTimes = value;
	}

}