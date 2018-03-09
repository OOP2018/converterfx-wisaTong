package converter;

/**
 * Enumeration of various length unit in meter
 * @author Wisa Powthongchin
 *
 */
public enum Length {

	Meter(1.0), //Standard unit
	Kilometer(1000.0), Mile(1609.344), Foot(0.3048),
	Centimeter(0.01), Wa(2.0), AU(149597870700.0);
	
	/** Length in meter */
	private double value;

	private Length(double value) { this.value = value; }
	
	/** Accessor method for length */
	public double getValue() { return value; }
	
}
