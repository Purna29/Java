import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class PostfixExpression
{	
	public static boolean isOperator(char s)
	{
		if(s == '+' || s == '-' || s == '/' || s == '*' || s == '_' || s == '#' || s== '^' )
		{
			return true;	
		}
		else
		{
			return false;
		}
	}
	 
	public static void main(String[] args)
	{
		System.out.println("Hello! This is a Postfix Expression Calculator");
		Stack<Double> numbers = new Stack<Double>();
		Scanner inputStream = null;
		try
		{
		File file = new File("Add Link here to Open File From Your Local Computer");
		inputStream = new Scanner(file);
		}
		catch(FileNotFoundException e)
	      {
	         System.out.println("Error opening the file");
	         System.exit(0);
	      }
		while(inputStream.hasNextLine())
		{
			String currentExpression = inputStream.nextLine();
			String[] expression = currentExpression.split(" ");
			for(int i = 0; i < expression.length; i++)
			 {
				char s = expression[i].trim().charAt(0);
					if(isOperator(s))
			         {
			        	String operator = expression[i].trim();
						double operand2 = numbers.pop();
						double operand1 = 0.0;
						
						if(operator.equals("+"))
						{
							operand1 = numbers.pop();
							numbers.push(operand1 + operand2);
						}
						else if(operator.equals("-"))
						{
							operand1 = numbers.pop();
							numbers.push(operand1 - operand2);
						}
						else if(operator.equals("*"))
						{
							operand1 = numbers.pop();
							numbers.push(operand1 * operand2);
						}
						else if(operator.equals("/"))
						{
							operand1 = numbers.pop();
							numbers.push(operand1 / operand2);
						}
						else if(operator.equals("#"))
						{
							numbers.push(Math.sqrt(operand2));
						}
						else if(operator.equals("^"))
						{
							operand1 = numbers.pop();
							numbers.push(Math.pow(operand1, operand2));
						}
						else if(operator.equals("_"))
						{
							numbers.push(-1 * operand2);
						}
					}
					else{
						numbers.push(Double.parseDouble(expression[i]));
					}
				}
				 System.out.println("The value of " +currentExpression+"\""+" is " +numbers.pop());
			 }
		System.out.println("Bye-Bye!");
		inputStream.close();
		
	    }
}