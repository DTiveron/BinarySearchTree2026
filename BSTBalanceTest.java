import java.util.*;

/**
 * This BSTBalanceTest object represents a tester class for testing
 * the balance method in a binary search tree
 * 
 * @author  Tom Bredemeier
 * @version January 31, 2013
 */

public class BSTBalanceTest
{
    private static boolean failed = false;
    private static String str;
    private static BSTInterface<Integer> tree;

    public static void main(String[] args)
    {
        System.out.println("Now testing your BinarySearchTree class: \n");

        try
        {
            tree = new BinarySearchTree<Integer>();
        }
        catch (NoClassDefFoundError e)
        {
            failure("Epic Failure: missing BinarySearchTree class");
        }
        catch (NoSuchMethodError e)
        {
            failure("Failed: missing constructor BinarySearchTree<T>()");
        }

        if(!failed)
            if(!(tree instanceof BSTInterface))
                failure("Failed: BinarySearchTree does not implement BSTInterface");

        if(!failed)
        {
            System.out.println("Now adding the numbers 10 11 12 13 14 15 9 8 7 6 5 4 3 2 1 to the tree\n");
            try
            {
                tree.add(10);
                tree.add(11);
                tree.add(12);
                tree.add(13);
                tree.add(14);
                tree.add(15);
                tree.add(9);
                tree.add(8);
                tree.add(7);
                tree.add(6);
                tree.add(5);
                tree.add(4);
                tree.add(3);
                tree.add(2);
                tree.add(1);
            }
            catch (NoSuchMethodError e)
            {
                failure("Failed: missing add(T element) method");
            }
        }

        if(!failed)
        {
            str = "| | | 15\n| | 14\n| | | 13\n| 12\n| | | 11\n| | 10\n| | | 9\n8\n";
            str += "| | | 7\n| | 6\n| | | 5\n| 4\n| | | 3\n| | 2\n| | | 1\n";
            System.out.println("Now testing BST Balance method on the following tree:\n");
            System.out.println(tree);
            tree.balance();
            System.out.println("Now displaying the balanced tree:\n");
            System.out.println(tree);
            if(! str.equals(tree.toString()))
                failure("Failed: balance method does not work properly");
        }

        if (failed)
            System.out.println("\n\nBummer, try again");
        if (!failed)
            System.out.println("\n\nCongratulations, your BST Balance test was successful");
    }

    private static void failure(String str)
    {
        System.out.println("*** " + str);
        failed = true;
    }

}
