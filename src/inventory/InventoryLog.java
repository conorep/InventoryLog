package inventory;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;

public class InventoryLog implements Inventory
{
    // instance field
    private ArrayList<Character> letters;

    // default constructor
    // create empty arraylist
    public InventoryLog()
    {
        letters = new ArrayList<>();
    }

    /**
     * increments the count of the character c in the inventory
     * error checks to see if c is a letter
     * @param c character to add to inventory
     */
    @Override
    public void add(char c)
    {
        if (Character.isLetter(c))
        {
            c = Character.toLowerCase(c);
            letters.add(c);
        }
    }

    /**
     * removes all instances of the character c in the inventory
     * error checks to see if c is a letter
     * @param c character to remove from inventory
     */
    @Override
    public void subtract(char c)
    {
        if (Character.isLetter(c))
        {
            c = Character.toLowerCase(c);
            letters.removeAll(Collections.singleton(c));
        }
    }

    /**
     * returns a count of the letter in the inventory, zero otherwise
     * error checks to see if c is a letter
     * @param c character in inventory
     * @return a count of the character in the inventory, returns -1 if c is not a letter
     */
    @Override
    public int get(char c)
    {
        if (Character.isLetter(c))
        {
            int totalVal = 0;
            c = Character.toLowerCase(c);
            for (Character letter : letters)
            {
                if (letter == c)
                {
                    totalVal++;
                }
            }
            return totalVal;
        }
        return -1;
    }

    /**
     * updates the count of the character c in the inventory (if count is zero or greater)
     * appends character c 'count' number of times minus the number of times c exists in
     * letters already
     *
     * @param c     character to update in inventory, throws IllegalArgumentException if character not in inventory
     * @param count number to update count with, throws IllegalArgumentException if negative
     */
    @Override
    public void set(char c, int count)
    {
        if (count < 0)
            throw new IllegalArgumentException(count + " is < zero.");
        if (get(c) == -1)
            throw new IllegalArgumentException(c + " is not in the inventory.");

        if (Character.isLetter(c))
        {
            c = Character.toLowerCase(c);
            System.out.println("HOW MANY: " + this.get(c));
            System.out.println("ADDING: " + (count - this.get(c)));

            for (int i = 0; i < (count - this.get(c)); i++)
            {
                letters.add(c);
            }
        }
    }

    /**
     * returns true if character is contained in the inventory
     *
     * @param c character
     * @return true if character in inventory, false otherwise
     */
    @Override
    public boolean contains(char c)
    {
        return letters.contains(c);
    }

    /**
     * returns the total number of letters in the inventory
     *
     * @return the total count
     */
    @Override
    public int size()
    {
        return letters.size();
    }

    /**
     * Returns true if this inventory is empty (all counts are 0)
     *
     * @return true if all counts are 0, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return letters.isEmpty();
    }

    /**
     * Returns a String representation of the inventory with the letters all in lowercase
     * surrounded by square brackets. The number of occurrences of each letter matches
     * its count in the inventory.
     * For example, an inventory of 4 a’s, 1 b, 1 k and 1 m would be represented as “[aaaabkm]”.
     *
     * @return a bracketed string representation of the letters contained in the inventory
     */
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder("[");

        for (Character letter : letters)
        {
            toReturn.append(letter);
        }
        return toReturn.append("]").toString();
    }
}
