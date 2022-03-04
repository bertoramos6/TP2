package simulator.model;

import java.util.List;
import simulator.misc.Pair;

public class SetContClassEvent extends Event {
	private int time;
	private List<Pair<String, Integer>> cs;

	public SetContClassEvent(int time, List<Pair<String,Integer>> cs) {
		super(time);
		
		if (cs == null) {
			throw new IllegalArgumentException("contamination-road list cannot be null");
		}
		
		this.cs = cs;
	}

	@Override
	void execute(RoadMap map) {
		for (Pair<String, Integer> c : cs) {
			Vehicle v = map.getVehicle(c.getFirst());
			
			if (v == null) {
				throw new IllegalArgumentException("Vehicle does not exist in map");
			}
		
			v.setContClass(c.getSecond());
		}
	}

}