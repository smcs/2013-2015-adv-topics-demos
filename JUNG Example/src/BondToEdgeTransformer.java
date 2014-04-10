import org.apache.commons.collections15.Transformer;

public class BondToEdgeTransformer implements Transformer<Bond, Integer> {
	@Override
	public Integer transform(Bond b) {
		return (int) b.getWeight();
	}
}
