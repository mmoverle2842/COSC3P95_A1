import java.util.*;
// this class tests the Sorter.java bubble sort algorithm
public class Tester
{
    int passes; // num of tests
    Random rand = new Random();
    public Tester() {
        passes = rand.nextInt(500) + 1;
        generateLists();
    }

    // test the results of the sort
    public List<Integer> testSorter(int[] list)
    {
        List<Integer> errors = new ArrayList<Integer>();
        for(int i=1;i<list.length;i++)
        {
            if(list[i] < list[i-1]) // if previous number is greater than current number
            {
                errors.add(i);
            }
        }
        return errors;
    }
    public void generateLists()
    {
        int totalFails = 0;
        List<Integer> failedIndx = new ArrayList<Integer>();
        for(int i=0;i<passes;i++)
        {
            // generate a list of a random length with random integers
            int[] list = new int[rand.nextInt(100) + 1];
            for(int j=0;j<list.length;j++)
            {
                list[j] = rand.nextInt(1000) + 1;
            }

            Sorter sorter = new Sorter(list);
            System.out.println("\nPass: " + i + " | Length of Array: "+list.length+"\nBefore Sort:");
            sorter.printTheNumbers();
            sorter.sortTheNumbers();
            System.out.println("After Sort:");
            sorter.printTheNumbers();

            List<Integer> testOutput = testSorter(list);

            // prints the failures for this pass if it failed
            if(testOutput.size() > 0)
            {
                failedIndx.add(i);
                System.out.print("Status: FAIL\nFailed At Index: ");
                for(int k=0;k<testOutput.size();k++)
                {
                    totalFails++;
                    System.out.print(testOutput.get(k)+", ");
                }
                System.out.println();
            }
            else
            {
                System.out.println("Status: PASS");
            }
        }
        // shows total fails and what passes failed
        // important to note that number of fails != number of failed passes, as a pass could fail multiple times
        System.out.println("\nTotal Fails: "+totalFails);
        System.out.print("Failed Passes: ");
        for(int x=0;x<failedIndx.size();x++)
        {
            System.out.print(failedIndx.get(x)+", ");
        }
    }
    public static void main(String[] args)
    {
        Tester test = new Tester();
    }
}
