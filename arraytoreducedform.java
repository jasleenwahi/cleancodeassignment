import java.util.*;
class ArrayToReducedForm
{
		
	public static void SortCopyOfArrayToBeReduced(int CopyOfArrayToBeReduced[])
	{
		int LengthOfCopyOfArrayToBeReduced = CopyOfArrayToBeReduced.length;
		for(int index = 1; index < LengthOfCopyOfArrayToBeReduced; index++)
		{
			int CurrentElement = CopyOfArrayToBeReduced[index];
			int PreviousIndex = index-1;
			while(PreviousIndex > -1 && CopyOfArrayToBeReduced[PreviousIndex] > CurrentElement)
			{
				CopyOfArrayToBeReduced[PreviousIndex+1] = CopyOfArrayToBeReduced[PreviousIndex];
				PreviousIndex--;
			}
			CopyOfArrayToBeReduced[PreviousIndex+1] = CurrentElement;
		}
	}
	
	public static void ConvertToReducedForm(int ArrayToBeReduced[], int LengthOfArrayToBeReduced)
	{
		int CopyOfArrayToBeReduced[] = ArrayToBeReduced.clone();
		SortCopyOfArrayToBeReduced(CopyOfArrayToBeReduced);
		HashMap<Integer, Integer> ReducedElements = new HashMap<>();
		int ReducedValue = 0;
		for(int index = 0; index < LengthOfArrayToBeReduced; index++)
		{
			ReducedElements.put(CopyOfArrayToBeReduced[index], ReducedValue++);
		}
		
		for(int index = 0; index < LengthOfArrayToBeReduced; index++)
		{
			ArrayToBeReduced[index] = ReducedElements.get(ArrayToBeReduced[index]);
		}
	}
	
	public static void PrintArray(int ReducedArray[], int LengthOfReducedArray)
    	{	
        	for (int index = 0; index < LengthOfReducedArray; index++)
        	{
            		System.out.print(ReducedArray[index] + " ");
            	}
    	}
	
	public static void main(String args[])
	{
		Scanner TakeInput = new Scanner(System.in);
		System.out.print("Enter the length of array to be reduced: ");
		int LengthOfArrayToBeReduced = TakeInput.nextInt();
		int ArrayToBeReduced[] = new int[LengthOfArrayToBeReduced];
		System.out.println("Enter the array elements");
		for(int index=0; index < LengthOfArrayToBeReduced; index++)
		{
			ArrayToBeReduced[index] = TakeInput.nextInt();
		}
		System.out.println("Given Array is ");
        	PrintArray(ArrayToBeReduced, LengthOfArrayToBeReduced);
        	ConvertToReducedForm(ArrayToBeReduced, LengthOfArrayToBeReduced);
        	System.out.println();
        	System.out.println("Reduced Array is ");
        	PrintArray(ArrayToBeReduced, LengthOfArrayToBeReduced);
	}
}
