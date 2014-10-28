import java.util.*;

public class OTOS {

	private Vector<OTOS> everyoneElse;
	
	public OTOS(Vector<OTOS> everyoneElse) {
		this.everyoneElse = everyoneElse;
		everyoneElse.add(this);
		
		for(int i = 0; i < everyoneElse.size(); i++) {
			System.out.println(everyoneElse.get(i));
		}
	}
}
