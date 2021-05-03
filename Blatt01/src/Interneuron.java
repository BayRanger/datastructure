import java.util.ArrayList;

/**
 * The class Neuron implents a interneuron for the class Network.
 * 
 * @author Vera Röhr
 * @version 1.0
 * @since 2019-01-11
 */
public class Interneuron extends Neuron {
	/**
	 * {@inheritDoc}
	 */
	public Interneuron(int index) {
		// TODO
		super(index);
		this.outgoingsynapses = new ArrayList<Synapse>();


		//return this;

	}

	/**
	 * Divides incoming signal into equal parts for all the outgoing synapses
	 * Transmits the parts via Synapse.transmit(Double[]);
	 * 
	 * @param signal 3 dimensional signal from another neuron
	 * @return 3 dimensional neural signal, which got transmitted to the synapses (for testing.)
	 */
	@Override
	public double[] integrateSignal(double[] signal) {
		// TODO
		double[] output = signal.clone();
		int synap_num = this.outgoingsynapses.size();
		for (int i =0; i<output.length;i++)//3
		{
			output[i] = output[i]/synap_num;


		}
		for (Synapse s:this.outgoingsynapses)
		{
			s.transmit(output);
		}


		return output;
	}
}


