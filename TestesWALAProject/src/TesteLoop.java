import java.util.ArrayList;
import java.util.List;


public class TesteLoop {
	
	public static void main(String[] args) {
		
		List<Integer> teste = new ArrayList<Integer>();
		
		for (int i = 0; i < 50; i++) {
			teste.add(i);
		}
		
		for (Integer integer : teste) {
			System.out.println(integer);
		}
		
		
	}

}
