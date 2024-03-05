package pizza;

/**
 * {@code AbstractMenuItem} provides a single place for implementing the
 * compareTo() method for all classes that have to implement MenuItem
 */
public abstract class AbstractMenuItem implements MenuItem, Comparable<MenuItem> {
	public abstract Double getPrice();

	/**
	 * implements compareTo() for all MenuItems
	 * @param m the item being compared against us
	 * @returns 1 if this > m, 0 if this == m, -1 if this < m
	 */
	public int compareTo(MenuItem m) {
		return (this.getPrice() > m.getPrice()) ? 1 : (this.getPrice() < m.getPrice()) ? -1 : 0;
	}
}
