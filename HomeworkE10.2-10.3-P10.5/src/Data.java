public class Data {
	public static double average(Measurable[] objects) {
		double sum = 0;
		for (Measurable m : objects)
			sum += m.getMeasure();
		if (objects.length > 0)
			return sum / objects.length;
		return 0;
	}
	public static double average(Measurable[] objects, Filter filter) {
		double sum = 0;
		int count = 0;
		for (Measurable m : objects) {
			if (filter.accept(m)) {
				sum += m.getMeasure();
				count++;
			}
		}
		if (count > 0)
			return sum / count;
		return 0;
	}
	
	
	public static Measurable max(Measurable[] objects) {
		Measurable mmax = objects[0];
		double max = objects[0].getMeasure();
		for (Measurable m : objects) {
			if (m.getMeasure() > max) {
				max = m.getMeasure();
				mmax = m;
			}
		}
		return mmax;
	}
	public static Measurable max(Measurable[] objects, Filter filter) {
		Measurable mmax = null;
		double max = -1;
		for (Measurable m : objects) {
			if (filter.accept(m) && (max == -1 || m.getMeasure() > max)) {
				max = m.getMeasure();
				mmax = m;
			}
		}
		return mmax;
	}
}
