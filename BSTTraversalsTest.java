import java.util.*;

/**
 * This BSTTraversalsTest object represents a traversal tester class
 * for testing a binary search tree (testing the preorderTransversal,
 * inorderTransversal, and postorderTransversal methods)
 * 
 * @author  Tom Bredemeier
 * @version January 31, 2013
 */


public class BSTTraversalsTest
{
    private static boolean failed = false;
    private static String str;
    private static BSTInterface<String> tree;
    private static List<String> list;

    public static void main(String[] args)
    {
        System.out.println("Now testing your BinarySearchTree class: \n");

        try
        {
            tree = new BinarySearchTree<String>();
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
            System.out.println("Now adding the letters D B A C F E G to the tree");
            try
            {
                tree.add("D");
                tree.add("B");
                tree.add("A");
                tree.add("C");
                tree.add("F");
                tree.add("E");
                tree.add("G");
            }
            catch (NoSuchMethodError e)
            {
                failure("Failed: missing add(T element) method");
            }
        }

        if(!failed)
        {
            String test = "| | G\n| F\n| | E\nD\n| | C\n| B\n| | A\n";
            System.out.println("\nTree diagram (sideways):\n" + tree);
            if(! test.equals(tree.toString()))
            {
                failure("Correct tree diagram:\n" + test);
            }
        }

        if(!failed)
        {
            System.out.println("Now testing BST Traversals:");
            System.out.print("\nPreorder traversal:  ");
            try
            {
                list = tree.preorderTraverse();
                printList(list);
                System.out.print(str + "      ");
                if (str.equals("D B A C F E G "))
                    System.out.print("Correct");
                else
                    failure("Incorrect");
            }
            catch (NoSuchMethodError e)
            {
                failure("Failed: missing method");
            }
            catch (NullPointerException e)
            {
                failure("Failed: method returns null");
            }
        }

        if(!failed)
        {
            System.out.print("\nInorder traversal:   ");
            try
            {
                list = tree.inorderTraverse();
                printList(list);
                System.out.print(str + "      ");
                if (str.equals("A B C D E F G "))
                    System.out.print("Correct");
                else
                    failure("Incorrect");
            }
            catch (NoSuchMethodError e)
            {
                failure("Failed: missing method");
            }
            catch (NullPointerException e)
            {
                failure("Failed: method returns null");
            }

        }

        if(!failed)
        {
            System.out.print("\nPostorder traversal: ");
            try
            {
                list = tree.postorderTraverse();
                printList(list);
                System.out.print(str + "      ");
                if (str.equals("A C B E G F D "))
                    System.out.print("Correct");
                else
                    failure("Incorrect");
            }
            catch (NoSuchMethodError e)
            {
                failure("Failed: missing method");
            }
            catch (NullPointerException e)
            {
                failure("Failed: method returns null");
            }

        }

        if (failed)
            System.out.println("\n\nBummer, try again");
        if (!failed)
            System.out.println("\n\nCongratulations, your BST Traversals test was successful");
    }

    private static void failure(String str)
    {
        System.out.println("*** " + str);
        failed = true;
    }

    private static <E> void printList(List<E> list)
    {
        str = "";
        for (E element : list)
            str += (element + " ");
    }
}
