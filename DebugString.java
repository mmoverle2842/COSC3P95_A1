import java.util.*;
public class DebugString
{
    String input;     // string we're debugging
    List<Character> problems; // char list of problematic characters
    public DebugString(String inString)
    {
        this.problems = new ArrayList<Character>();
        this.input = inString;
        deltaDebug(inString); // starts the debugging process
    }

    // original method from the assignment (modified for Java)
    public String processString(String inputStr) {
        String outputStr = "";
        for (char c : inputStr.toCharArray()) {
            if (Character.isUpperCase(c)) {
                outputStr += Character.toLowerCase(c);
            } else if (Character.isDigit(c)) {
                outputStr += c * 2; // this is where the bug occurs
            } else {
                outputStr += Character.toUpperCase(c);
            }
        }
        return outputStr;
    }

    // version of the assignment method with the bug removed
    public String properProcessString(String inputStr)
    {
        String outputStr = "";
        for (char c : inputStr.toCharArray()) {
            if (Character.isUpperCase(c)) {
                outputStr += Character.toLowerCase(c);
            } else if (Character.isDigit(c)) {
                outputStr += c; // the bug is fixed here
            } else {
                outputStr += Character.toUpperCase(c);
            }
        }
        return outputStr;
    }

    // recursive method to delta debug the string with binary search
    private void deltaDebug(String inputStr)
    {
        // splits the string in half
        int mid = inputStr.length() / 2;
        String left = inputStr.substring(0, mid);
        String right = inputStr.substring(mid);

        if(!answerIsCorrect(left))
        {
            // sends left side for further debugging if it's greater than one char, adds the problematic char to a list if otherwise
            if(left.length() > 1)
            {
                deltaDebug(left);
            }
            else {
                problems.add(left.charAt(0));
            }
        }
        if(!answerIsCorrect(right))
        {
            // sends right side for further debugging if it's greater than one char, adds the problematic char to a list if otherwise
            if(right.length() > 1)
            {
                deltaDebug(right);
            }
            else {
                problems.add(right.charAt(0));
            }
        }
    }

    // checks if the actual output matches the desired output
    public boolean answerIsCorrect(String inputStr)
    {
        return processString(inputStr).equals(properProcessString(inputStr));
    }

    // prints out the list of problematic chars
    public void printProblems()
    {
        System.out.println("Input: " + input +"\nExpected output: "+properProcessString(input)+"\nActual Output: "+processString(input));
        if(problems.size() > 0) {
            for (Character problem : problems) {
                System.out.println("'" + problem + "' is causing a bug.");
            }
        }
        else {
            System.out.println("No bugs found.");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        DebugString ds1 = new DebugString("abcdefG1");
        DebugString ds2 = new DebugString("CCDDEExy");
        DebugString ds3 = new DebugString("1234567b");
        DebugString ds4 = new DebugString("8665");

        ds1.printProblems();
        ds2.printProblems();
        ds3.printProblems();
        ds4.printProblems();
    }
}
