import java.awt.Point;

import javax.swing.JFrame;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * An example using the JUNG (Java Universal Network Graphs) library. The Grotto
 * tutorials come highly recommended
 * {@link http://www.grotto-networking.com/JUNG/JUNG2-Tutorial.pdf}.
 * 
 * @author SethBattis@stmarksschool.org
 */

public class JUNGExample {
	public static void main(String[] args) {
		/* define our basic graph made of Atoms and Bonds */
		Graph<Atom, Bond> carbonDioxide = new SparseGraph<Atom, Bond>();
		
		/* define a few handy atoms */
		Atom carbon = new Atom("Carbon", "C", 12.0107);
		Atom oxygen1 = new Atom("Oxygen", "O", 15.9994);
		Atom oxygen2 = new Atom(oxygen1);
		
		/* add the atoms (and dynamically created bonds) to the graph */
		carbonDioxide.addEdge(new Bond(carbon, oxygen1, 1), carbon, oxygen1, EdgeType.DIRECTED);
		carbonDioxide.addEdge(new Bond(oxygen1, carbon, 1), oxygen1, carbon, EdgeType.DIRECTED);
		carbonDioxide.addEdge(new Bond(carbon, oxygen2, 100), carbon, oxygen2, EdgeType.DIRECTED);
		carbonDioxide.addEdge(new Bond(oxygen2, carbon, 100), oxygen2, carbon, EdgeType.DIRECTED);

		/* choose a basic layout for our graph */
		SpringLayout<Atom, Bond> layout = new SpringLayout<Atom, Bond>(carbonDioxide, new BondToEdgeTransformer());
		layout.setLocation(carbon, 100, 100);
		
		/* connect the layout to a visualization engine */
		BasicVisualizationServer<Atom, Bond> bvs = new BasicVisualizationServer<Atom, Bond>(layout);
		
		/* set up some labeling for convenience */
		bvs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Atom>());
		bvs.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		bvs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Bond>());
		
		/* set up a Swing JFrame to present the viewer */
		JFrame frame = new JFrame("Spring Layout View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(bvs);
		frame.pack();
		frame.setVisible(true);
	}
}
