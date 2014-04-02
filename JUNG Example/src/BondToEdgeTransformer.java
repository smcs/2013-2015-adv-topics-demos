import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout3d.SpringLayout.LengthFunction;

public class BondToEdgeTransformer implements Transformer<Bond, Integer>, LengthFunction<Bond> {
	@Override
	public Integer transform(Bond b) {
		return (int) b.getWeight();
	}

	@Override
	public double getLength(Bond b) {
		// TODO Auto-generated method stub
		return b.getWeight();
	}
}
