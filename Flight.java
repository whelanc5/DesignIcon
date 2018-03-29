

import java.awt.Color;
import java.util.ArrayList;

public class Flight {
	private String name;
	private FlightIcon icon;
	private String dest;
	private String dFix;
	ArrayList<String> acids;
	ArrayList<String> airlines;

	public Flight() {
		icon = new FlightIcon(Color.green);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FlightIcon getIcon() {
		return icon;
	}

	public void setIcon(FlightIcon icon) {
		this.icon = icon;
	}
}
