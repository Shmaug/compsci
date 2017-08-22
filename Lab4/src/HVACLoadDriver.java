public class HVACLoadDriver {
	public static void main(String[] args) {
		HVACLoad load = new HVACLoad();
		load.getInputs();
		double heat = load.findHeatingLoad();
		double cool = load.findCoolingLoad();
		load.printCapacities(heat, cool);
	}
}
