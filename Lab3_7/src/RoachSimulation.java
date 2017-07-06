
public class RoachSimulation {
	public static void main(String[] args){
		RoachPopulation rp = new RoachPopulation(10);
		
		for (int i = 0; i < 3; i++){
			rp.breed();
			rp.spray(.1);
			System.out.println(rp.getRoaches() + " roaches");
		}
	}
}
