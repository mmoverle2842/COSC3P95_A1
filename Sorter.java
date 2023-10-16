// simple bubble sorting algorithm
public class Sorter
{
    public int[] numbers; // numbers we're sorting
    public Sorter(int[] unsortedList)
    {
        this.numbers = unsortedList;
    }
    public void sortTheNumbers()
    {
        boolean sorted = false;
        while(!sorted)
        {
            boolean swapped = false; // if a number is swapped this will be turned true so the algorithm knows to check the list afterwards
            for(int i=1;i<numbers.length;i++)
            {
                int temp;
                // swaps two numbers if the proceeding number is greater than the succeeding one. I put an artificial bug here, so it won't swap any multiple of 111
                if(numbers[i-1] > numbers[i] && numbers[i] % 111 != 0)
                {
                    temp = numbers[i-1];
                    numbers[i-1] = numbers[i];
                    numbers[i] = temp;
                    swapped = true;
                }
            }
            if(!swapped) // if a pass occurred without a swap, the list is sorted
            {
                sorted = true;
            }
        }
    }

    // prints the numbers
    public void printTheNumbers()
    {
        for(int n : numbers)
        {
            System.out.print(n + ", ");
        }
        System.out.println();
    }
}

