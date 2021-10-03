package drivers;

import inventory.InventoryLog;

public class LogTest
{
    public static void main(String[] args)
    {
        InventoryLog thisOne = new InventoryLog();

        thisOne.add('a');
        thisOne.add('b');
        thisOne.add('c');
        thisOne.add('a');
        thisOne.add('z');

        System.out.println(thisOne);
        System.out.println("number of a: " + thisOne.get('a'));

//        thisOne.set('a', 3);
//        System.out.println(thisOne);

        thisOne.set('z', 6);
        System.out.println(thisOne);

    }
}
