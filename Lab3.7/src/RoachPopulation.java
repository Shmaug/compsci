
public class RoachPopulation {
	private int population = 0;
	
	public RoachPopulation(int initial){
		population = initial;
	}
	
	public void breed(){
		population *= 2;
	}
	
	public void spray(double percent){
		population = (int)(population * (1 - percent));
	}
	
	public int getRoaches(){
		return population;
	}
}
