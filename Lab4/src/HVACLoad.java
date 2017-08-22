import java.util.Scanner;

public class HVACLoad {
	private double roofArea;
	private double perimeter;
	private double height;
	private double windowArea;
	private double westWindowArea;
	private double roofU;
	private double wallU;
	private double windowU;
	private double winterOutdoorTemperature;
	private double summerOutdoorTemperature;
	private double summerOutdoorHumidity;
	private double infiltration;
	private double people;
	private double electrical;

	public void getInputs() {
		Scanner in = new Scanner(System.in);
		System.out.println("HVAC Load Calculation:\n");
		
		System.out.print("Enter total roof area in square ft: ");
		roofArea = in.nextDouble();
		
		System.out.print("Enter building perimeter in ft: ");
		perimeter = in.nextDouble();

		System.out.print("Enter building height in ft: ");
		height = in.nextDouble();

		System.out.print("Enter total window area in square ft: ");
		windowArea = in.nextDouble();

		System.out.print("Enter west window area area in square ft: ");
		westWindowArea = in.nextDouble();

		System.out.print("Enter roof U-value: ");
		roofU = in.nextDouble();

		System.out.print("Enter wall U-value: ");
		wallU = in.nextDouble();

		System.out.print("Enter window U-value: ");
		windowU = in.nextDouble();

		System.out.print("Enter winter outdoor temperature in deg F: ");
		winterOutdoorTemperature = in.nextDouble();
		
		System.out.print("Enter summer outdoor temperature in deg F: ");
		summerOutdoorTemperature = in.nextDouble();

		System.out.print("Enter summer outdoor humidity ratio: ");
		summerOutdoorHumidity = in.nextDouble();
		
		System.out.print("Enter infiltration in CFM: ");
		infiltration = in.nextDouble();

		System.out.print("Enter number of people present: ");
		people = in.nextDouble();

		System.out.print("Enter electrical use in Watts: ");
		electrical = in.nextDouble();

		System.out.println();
		
		in.close();
	}

	public double netWallArea() {
		return perimeter * height - windowArea;
	}
	
	public double findHeatingLoad() {
		final double winterIndoorTemperature = 72;
		double tempDiff = winterIndoorTemperature - winterOutdoorTemperature;
		
		double roofLoad = roofArea * roofU * tempDiff;
		double windowLoad = windowArea * windowU * tempDiff;
		double wallLoad = netWallArea() * wallU * tempDiff;
		double infil = infiltration * 1.08 * tempDiff;
		
		double load = roofLoad + windowLoad + wallLoad + infil;
		return load;
	}
	public double findCoolingLatentLoad() {
		final double summerIndoorHumidity = .01;
		double humidDiff = summerOutdoorHumidity - summerIndoorHumidity;
		
		double infil = infiltration * 4675 * humidDiff;
		double p = 200 * people;
		
		return infil + p;
	}
	public double findCoolingSensibleLoad() {
		final double summerIndoorTemperature = 76;
		final double solarGain = 193;
		double tempDiff = summerOutdoorTemperature - summerIndoorTemperature;
		
		double roofLoad = roofArea * roofU * tempDiff;
		double windowLoad = windowArea * windowU * tempDiff;
		double wallLoad = netWallArea() * wallU * tempDiff;
		double infil = infiltration * 1.08 * tempDiff;
		double solar = solarGain * westWindowArea;
		double elec = electrical * 3.416;
		double p = 250 * people;
		
		double load = solar + roofLoad + windowLoad + wallLoad + infil + elec + p;
		return load;
	}
	public double findCoolingLoad() {
		double sensible = findCoolingSensibleLoad();
		double latent =  findCoolingLatentLoad();
		
		double load = sensible + latent;
		return load;
	}
	
	public void printCapacities(double heating, double cooling) {
		heating *= 1.3;
		cooling *= 1.1;
		
		int ctons = (int)(cooling / 12000 + .5);
		
		System.out.println(String.format("Heating Load = %.1f BTU per hour", heating));
		System.out.println(String.format("Cooling Load = %.1f BTU per hour\n\tor approximately %d tons", cooling, ctons));
	}
}
