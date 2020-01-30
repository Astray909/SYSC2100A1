/**
 * 
 */
package pkj;

/**
 * @author Jia Chen Huang
 * @version January 24, 2020
 *
 */
public class Submit {

	/**
	 * main class, empty main class
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//question 1
		System.out.println("Question 1\n");
		c(2, 1);
		c(2, 3);
		c(3, 2);
		
		//question 2
		System.out.println("\nQuestion 2\n");
		System.out.println("there are " + p(2) + " ways to organise this parade of " + 2 + ".");
		System.out.println("there are " + p(3) + " ways to organise this parade of " + 3 + ".");
		System.out.println("there are " + p(20) + " ways to organise this parade of " + 20 + ".");
		//System.out.println(p(20));
		
		//question 3
		System.out.println("\nQuestion 3\n");
		writeLine('*', 4);
		System.out.print("\n");
		
		//question 3.2
		System.out.println("\nQuestion 3.2\n");
		writeBlock('*', 5, 3);
		
		//question 4
		System.out.println("\nQuestion 4\n");
		reverseDigits(123);
		
		//question 5
		System.out.println("\nQuestion 5\n");
		String[] str = new String[5];
		str[0] = "a";
		str[1] = "ab";
		str[2] = "abc";
		str[3] = "abcd";
		str[4] = "abcde";
		System.out.print("The entry you are looking for is in index ");
		int fiveAns = myBinarySearch(str, 0, 4, "abcd");
		if (fiveAns == -1)
		{
			System.out.println("The string you are looking for does not exist within the boundaries");
		}
		else
		{
			System.out.println(fiveAns);
		}
	}
	
	/**
	 * problem 1, Spock
	 * Write a Java method for the Spock problem c(n, k) seen in class. 
	 * Include output code that shows the actual sequence of calls that are made and the value 
	 * that they will return when the method is executed.
	 * @param n a number
	 * @param k another number
	 * @return answer to Spock
	 */
	public static int c(int n, int k)
	{
		int ret;
		
		
		if(k == 0)
		{
			ret = 1;
			System.out.printf("c(%d,0)=" + ret + "\n", n);
			return ret;
		}
		else if(k == 1)
		{
			ret = 2;
			System.out.printf("c(%d,%d)=" + ret + "\n", n, k, ret);
			return ret;
		}
		else if(k == n)
		{
			ret = 1;
			System.out.printf("c(%d,%d)=" + ret + "\n", n, k, ret);
			return ret;
		}
		else if(k > n)
		{
			ret = 0;
			System.out.printf("c(%d,%d)=" + ret + "\n", n, k);
			return ret;
		}
		else
		{
			System.out.printf("c(%d,%d)=c(%d,%d)+c(%d,%d)\n",n,k,n-1,k-1,n-1,k);
			return c(n-1, k-1) + c(n-1, k);
		}
	}
	
	/**
	 * Problem 2
	 * Write a Java method for the problem of Organizing a Parade as presented in class. 
	 * Name your method P
	 * @param n a random number
	 * @return number of ways the parade can be arranged
	 */
	public static int p(int n)
	{
		int ret;
		int ans;
		
		if(n>0)
		{
			if(n == 1)
			{
				ret =  2;
				//System.out.printf("p(%d) = 2\n", n);
				return ret;
			}
			else if(n == 2)
			{
				ret =  3;
				//System.out.printf("p(%d) = 3\n", n);
				return ret;
			}
			else
			{
				//System.out.printf("p(%d) = p(%d)+p(%d)\n", n, n-1, n-2);
				ans =  p(n - 1) + p(n - 2);
			}
		}
		else
		{
			System.out.println("n can't be smaller than 0, please choose another number");
			return 0;
		}
		//System.out.println("there are " + ans + " ways to organise this parade.");
		return ans;
	}
	
	/**
	 * Problem 3
	 * Write a recursive Java method writeLine that writes a character repeatedly to form 
	 * a line of n characters. 
	 * For example, writeLine(‘*’,5) produces the line *****.
	 * @param ch the char you want to be repeated
	 * @param n the times you want the char to be repeated
	 */
	public static void writeLine(char ch, int n)
	{
		if(n != 0)
		{
			System.out.print(ch);
			writeLine(ch, n-1);
		}
	}
	
	/**
	 * Problem 3.2
	 * Then write a recursive method writeBlock that uses writeLine to write m lines of 
	 * n characters each. 
	 * For example, writeBlock(‘*’, 5, 3) produces the output
	 * @param ch the char you want to be repeated
	 * @param n the times you want it to be repeated
	 * @param m how many lines you want it to be repeated
	 */
	public static void writeBlock(char ch, int n, int m)
	{
		if (m != 0)
		{
			writeLine(ch, n);
			System.out.print("\n");
			writeBlock(ch, n, m-1);
		}
	}
	
	/**
	 * Problem 4
	 * Write a recursive Java method that writes the digits of a 
	 * positive decimal integer in reverse order. 
	 * Name your method reverseDigits.
	 * @param number the number you want to be reversed
	 */
	public static void reverseDigits(int number)
	{
		if(number<10)
		{
            System.out.print(number + "\n");
        }
        else
        {
            System.out.print(number % 10);
            reverseDigits(number / 10);
        }
	}
	
	/**
	 * Problem 5
	 * Implement the recursive binary search algorithm presented in class for an array of
	 * strings. Name your method myBinarySearch.
	 * @param anArray the array of strings
	 * @param first first index
	 * @param last last index
	 * @param value the string you are looking for
	 * @return
	 */
	public static int myBinarySearch(String [] anArray, int first, int last, String value)
	{
		int index;
		if (first > last)
		{
			return -1;
		}
		else
		{
			int mid = (first + last) / 2;
			if(value.equals(anArray[mid]))
			{
				return mid;
			}
			else if(value.compareTo(anArray[mid]) < 0)
			{
				index = myBinarySearch(anArray, first, mid-1, value);
			}
			else
			{
				index = myBinarySearch(anArray, mid+1, last, value);
			}
		}
		return index;
	}
}
