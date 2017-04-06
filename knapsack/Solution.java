package knapsack;

/**
 * An Solution is a solution to a knapsack Problem.
 * It is a knapsack which includes items selected to maximize the value.
 * Note that there may be more than one possible solution to each knapsack problem.
 * @author Sophie Quigley
 * @author Mitchell Mohorovich
 */
public class Solution {
    /**
     * Total capacity of knapsack when empty
     */
    int totalCapacity;
    /**
     * Remaining capacity with current contents
     */
    int remainingCapacity;
    /**
     * Number of possible Items which may be added to knapsack
     */
    int maxItems;
    /**
     * Actual total number of Items in knapsack
     */
    int totalItems = 0;
    /**
     * Set of items:
     * <ul>
     * <li>when ith possible Item is not included, items[i]=null;
     * <li>otherwise items[i] is an Item
     * </ul>
     */
    Item[] items;

    /**
     *  Instance variable that dynamically keeps the total worth of the items.
     */
    int totalWorth;

    /**
     * Returns a new Solution representing an empty knapsack
     * @param totalcapacity Capacity of knapsack when empty
     * @param totalitems Number of possible items which may be added to knapsack
     */
    Solution(int totalcapacity, int totalitems) {
        totalCapacity = totalcapacity;
        remainingCapacity = totalcapacity;
        this.maxItems = totalitems;
        items = new Item[totalitems];
    }

    /**
     * Returns a string describing the Solution to the knapsack Problem
     * @return String description of knapsack Solution
     */
    @Override
    public String toString() {
        String result = "Solution: knapsack of capacity " + totalCapacity + " contains:\n";
        for (int i = 0; i < maxItems; i++)
            if (items[i] != null)
                result += "- " + items[i] + "\n";
        result += "with a total value of " + getWorth();
        return result;
    }

    /**
     * Adds the ith Item to the knapsack, and adjusts remaining capacity accordingly
     * @param i index of new Item to be added
     * @param item Item added
     * @return The updated knapsack
     */
    public Solution add(int i, Item item) {
    	this.totalWorth += item.getValue();
        items[i] = item;
        remainingCapacity -= item.getWeight();
        totalItems++;
        return this;
    }

    /**
     * Removes the ith Item from the knapsack, and adjusts remaining capacity accordingly
     * @param i index of new Item to be removed
     * @return The updated knapsack
 */
    public Solution remove(int i) {
    	this.totalWorth -= items[i].getValue();
        remainingCapacity += items[i].getWeight();
        items[i] = null;
        totalItems--;
        return this;
    }

    /**
     * Getter for an Item in the knapsack
     * @param i index of Item to be returned.
     * @return ith Item in knapsack
     */
    public Item getItem(int i) {
        return items[i];
    }

    /**
     * Getter for the total value of the current knapsack contents
     * @return the total value of the current contents of the knapsack
     */
    public int getWorth() {
    	return this.totalWorth;
    }

    public Solution clone() {
		Solution solution = new Solution(this.totalCapacity, this.totalItems);
		solution.totalCapacity = this.totalCapacity;
		solution.remainingCapacity = this.remainingCapacity;
		solution.maxItems = this.maxItems;
		solution.totalItems = this.maxItems;
		//the Item objects themselves aren't modified so a shallow copy is sufficient
		solution.items = this.items.clone();
		return solution;
	}


}
