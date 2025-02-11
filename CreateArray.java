import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateArray 
{
    public static void main(String[] args) 
    {
        Example example = new Example();
        FillArray fillArray = new FillArray(example);
        
        Scanner astr = new Scanner(System.in);
        System.out.println("1 - fill in the array manually");
        System.out.println("2 - fill in the array from file");
        String input = astr.nextLine();
        
        if(input.equalsIgnoreCase("1"))
        {
        	fillArray.fill();
        }
        else
        {
        	fillArray.fillFromFile();
        }
        

        System.out.println("Current array:");
        for (String element : example.getArray()) 
        {
            System.out.print(element + " ");
        }
    }
}

class Example 
{
    private String[] str = new String[0];

    public String[] getArray() 
    {
        return str;
    }

    protected void setArray(String[] newArray) 
    {
        this.str = newArray;
    }
}

class FillArray 
{
    private Example example;

    public FillArray(Example example) 
    {
        this.example = example;
    }

	private String[] readFromFile(String fileName) 
	{
    try 
    {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        StringBuilder data = new StringBuilder();
        
        while (scanner.hasNextLine()) {
            data.append(scanner.nextLine()).append(" ");
        }
        scanner.close();

        return data.toString().split(";");
    } 
    catch (FileNotFoundException e) 
    {
        System.out.println("File not found: " + fileName);
        return new String[0];
    }
}

    void fill() 
    {
        Scanner s = new Scanner(System.in);

        while (true) 
        {
            System.out.print("Input array elemebts (or 'kill' to exit): ");
            String inputInArr = s.nextLine();
            String exitFromWhile = "kill";
            
            if (inputInArr.equalsIgnoreCase(exitFromWhile)) 
            {
                System.out.println("You kill process.");
                break;
            }
            
            addToArray(inputInArr);

            System.out.println("Current array: ");
            for (String element : example.getArray()) 
            {
                System.out.print(element + " ");
            }
            System.out.println("\n----------------");
        }
    }
    
    void fillFromFile() 
    {
    	
	    String[] fileData = readFromFile("input.txt");
	    if (fileData.length > 0) 
	    {
	        example.setArray(fileData);
	    	System.out.println("Array successfully filled from file.");
	    } 
	    else 
	    {
	        System.out.println("Failed to read data from file.");
	    }
    
	}

    private void addToArray(String element) 
    {
        String[] currentArray = example.getArray();
        String[] newArray = new String[currentArray.length + 1];
        for (int i = 0; i < currentArray.length; i++) 
        {
            newArray[i] = currentArray[i];
        }

        newArray[currentArray.length] = element;
        example.setArray(newArray);
    }
}