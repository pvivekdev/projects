/*
 * Author: Vivekananthan Pasupathi
 * pvivekdev@gmail.com
 * For Zoho SoftwareTrainer Application
 */

package sample;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String wishOption = "Y";
		boolean restartFromBegning; 
		try 
		{

			while (wishOption.equalsIgnoreCase("Y")) {

				helpFunction();
				restartFromBegning = false;

				int operation;
				operation= sc.nextInt();

				if (operation < 0 || operation > 8)
				{
					System.out.println("Invalid Operation" + "Enter Valid menu from 1 to 8");
					helpFunction();
					operation = sc.nextInt();
				}   

				//Why numember1 and number2 are initialized to -1 and not 0, Because default value of integer is 0
				int number1 = -1 ,number2 = -1;

				System.out.println("Enter First Number Say X");

				//To Check if given input is valid number > 0
				number1 = ParseStringToInteger(sc.next());

				while(number1 < 0)
				{
					System.out.println("Invalid Input" + "ReEnter Valid Input Number > 0 or press Y to Restart from the begining"
							+ " Or E to exit");
					String input = (sc.next());

					if(input.equalsIgnoreCase("Y"))
					{
						wishOption = "Y";
						restartFromBegning =true;
						break;

					}
					else if(input.equalsIgnoreCase("E"))
					{
						System.exit(0);
					}
					else 
					{
						number1 = ParseStringToInteger(input);
					}

				}

				if(restartFromBegning ==true)
				{
					continue;
				}

				System.out.println("Enter Second Number Say Y");
				number2 =  ParseStringToInteger(sc.next());

				while(number2 < 0)
				{
					System.out.println("Invalid Input" + "ReEnter Valid Input Number > 0 or press Y to Restart from the begining"
							+ " Or E to exit");
					String input = (sc.next());

					if(input.equalsIgnoreCase("Y"))
					{
						wishOption = "Y";
						restartFromBegning =true;
						break;
					}
					else if(input.equalsIgnoreCase("E"))
					{
						System.exit(0);
					}
					else 
					{
						number2 = ParseStringToInteger(input);
					}

				}

				if(restartFromBegning ==true)
				{
					continue;
				}

				if(!restartFromBegning) 
				{
					switch (operation) {
					case 1:
						int additionResult = Add(number1, number2);
						System.out.println(number1 + " + " + number2 + " = " + additionResult);
						break;
					case 2:
						int subtractionResult = Sub(number1, number2);
						System.out.println(number1 + " - " + number2 + " = " + subtractionResult);
						break;
					case 3:
						int multiplicationResult = Multiply(number1, number2);
						System.out.println(number1 + " * " + number2 + " = " + multiplicationResult);
						break;
					case 4:
						int divisionResult = Divison(number1, number2);
						System.out.println(number1 + " / " + number2 + " = " + divisionResult);
						break;
					case 5:
						int XPercentageOfY = CalculateXPercentageOfY(number1, number2);
						System.out.println("X: " + number1 + " % of Y: " + number2 + "= " + XPercentageOfY);
						break;

					case 6:
						int WhatPercentageofYisX= CalculateWhatPercentageOfYisX(number1, number2);
						System.out.println(WhatPercentageofYisX +" Percentage of Y:" + number2 + " is X: " + number1);
						break;
					case 7:
                         Map<String, Integer> resultMap = FindPercentageIncreaseDescreaseOfXToY(number1, number2);
                         
                         if(resultMap.containsKey("Decrease"))
                         {
                        	 System.out.println("X:" + number1 + " is "+ resultMap.get("Decrease").toString() +" % decrease to " + " Y: " + number2);
                         }
                         else if(resultMap.containsKey("Increase"))
                         {
                        	 System.out.println("X:" + number1 + " is "+ resultMap.get("Increase").toString() +" % increase to " + " Y: " + number2);
                         }
                         
						break;
					case 8:
						System.exit(0);
						break;


					}

					System.out.println("Wish to continue(Y/N)");
					wishOption = sc.next();

					if(wishOption.equalsIgnoreCase("N"))
						System.exit(0);

					if(!wishOption.equalsIgnoreCase("Y"))
					{
						System.out.println("Invalid Input" + "press Y to Restart from the begining"
								+ " Or E to exit");
						wishOption = sc.next();
						if(wishOption.equalsIgnoreCase("Y"))
							continue;
						else
						{
							while(!wishOption.equalsIgnoreCase("Y"))
							{
								
								if(wishOption.equalsIgnoreCase("E"))
								{
									System.exit(0);
									
								}
								else
								{
									System.out.println("Invalid Input" + "press Y to Restart from the begining"
											+ " Or E to exit");
									wishOption = sc.next();
									continue;
								}
							}
						}
					}

				}
			}

		}

		catch(Exception ex)
		{
			System.out.println(String.format("Runtime exception occured", ex));
		}

	}


	static void helpFunction()
	{
		//TODO:- externalize this to config file
		System.out.println("--------Enter one of the input in number between 1 to 8 from given menu--------------");
		System.out.println("1 To Add Two Numbers ");
		System.out.println("2 To Subtract Two Numbers");
		System.out.println("3 To Multiply Two Numbers");
		System.out.println("4 To Divide Two Numbers");
		System.out.println("5 To calculate X% of Y");
		System.out.println("6 To Find What Percentage of Y is X");
		System.out.println("7 To Find % of increase or descrease from X to Y");
		System.out.println("8 Exit");
	}
	

	//Parse the input string into integer. If not parsed successful returns negative number 
	public static int ParseStringToInteger(String input)
	{
		try
		{
			return Integer.parseInt(input);
		}
		catch(Exception ex)
		{
			return -1;
		}
	}

	static int Add(int number1, int number2)
	{
		return number1 + number2;
	}

	static int Sub(int number1, int number2)
	{
		return number1 - number2;
	}
	static int Multiply(int number1, int number2)
	{
		return number1*number2;
	}

	static int Divison(int number1, int number2)
	{
		return number1/number2;
	}
   
	static int CalculateXPercentageOfY(int number1, int number2)
	{
	 	int temp =  (number1 %100);
	 	return temp * number2 /100;
	}
	
	static int CalculateWhatPercentageOfYisX(int number1, int number2)
	{
		int temp = number1 * 100;
		return (temp / number2);
	}
	
	static Map<String, Integer> FindPercentageIncreaseDescreaseOfXToY(int number1, int number2)
	{
		boolean isDecrease =false;
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		
		if(number1 < number2)
		{
			isDecrease = true;
		}
		
		if(isDecrease)
		{			
			int temp = number2 - number1;
			int decrease = temp *100 /number1;
			resultMap.put("Decrease", decrease);
     	}
		else
		{
			int temp = number1 - number2;
			int increase = temp *100 /number2;
			resultMap.put("Increase",increase);
    	}
		return resultMap;
		
	}


}
