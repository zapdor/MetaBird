package MetaAgent;

import java.util.HashMap;

public class Distribution {
	public HashMap<Integer, Integer> mTally = new HashMap<>();
	private int mTotalTally = 0;

	public void addTally(Integer pVal) {
		if (!mTally.containsKey(pVal)) {
			mTally.put(pVal, new Integer(0));
		}
		mTally.put(pVal, mTally.get(pVal) + 1);
		mTotalTally++;
	}

	public double getLikelihood(Integer pVal) {
		if (mTally.containsKey(pVal)) {
			return ((double) mTally.get(pVal)) / mTotalTally;
		} else {
			return 0;
		}
	}

	public int getTotalTally() {
		return mTotalTally;
	}

	public double getExpectation() {
		double[] sum = { 0 };
		mTally.forEach((k, v) -> {
			sum[0] += k * v;
		});
		return sum[0] / getTotalTally();
	}
	
	public double getExpectation(long pSubstract) {
		double[] sum = { 0 };
		mTally.forEach((k, v) -> {
			sum[0] += k * Math.max(0, v - pSubstract);
		});
		return sum[0] / getTotalTally();
	}
}
