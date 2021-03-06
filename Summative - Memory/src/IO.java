import java.io.*;

/**
 *	The static methods in this class allow text  
 *	to be written to OR read from a file.
 *
 *	@author  Ms Cianci
 *	@since	 November 2006
 */
public class IO
{
	
	/* VARIABLE AND METHODS NEEDED FOR WRITING TO A FILE */
	
	private static PrintWriter fileOut;
	
	
	/**
	 * Creates a new file (fileName) in the current
	 * folder and places a reference to it in fileOut
	 * @param fileName Represents the name of the file
	 */	
	public static void createOutputFile(String fileName)
	{
		createOutputFile(fileName, false);
		
//		try
//		{
//			fileOut = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
//		}
//		catch(IOException e)
//		{
//			System.out.println("*** Cannot create file: " + fileName + " ***");
//		}
	} // end createOutputFile method
	
	/**
	 * Creates a new file (fileName) in the current
	 * folder and places a reference to it in fileOut
	 * @param fileName Represents the name of the file
	 * @param append   True if you want to add to the existing information,
	 * 				   false if you want to re-write the entire file
	 */	
	public static void createOutputFile(String fileName, boolean append)
	{
		try
		{
			fileOut = new PrintWriter(new BufferedWriter(new FileWriter(fileName, append)));
		} // end try
		catch(IOException e)
		{
			System.out.println("*** Cannot create file: " + fileName + " ***");
		} // end catch
	} // end createOutputFile
	
	/**
	 * Text is added to the current file
	 * @param text The characters that will be added to the file
	 */
	public static void print(String text)
	{
		fileOut.print(text);
	} // end print method


	/**
	 * Text is added to the current file and a new line
	 * is inserted at the end of the characters
	 * @param text The characters that will be added to the file
	 */
	public static void println(String text)
	{
		fileOut.println(text);
	} // end println method

	
	/**
	 * Close the file that is currently being written to
	 * NOTE: This method MUST be called when you are finished
	 * writing to a file in order to have your changes saved
	 */
	public static void closeOutputFile()
	{
		fileOut.close();
	} // end closeOutputFile
	
	
	/* VARIABLE AND METHODS NEEDED FOR READING FROM A FILE */
	
	private static BufferedReader fileIn;
	
	
	/**
	 * Opens a file called fileName (that must be
	 * stored in the current folder) and places a
	 * reference to it in fileIn
	 * @param fileName The name of a file that already exists
	 */
	public static void openInputFile(String fileName)
	{
		try
		{
			fileIn = new BufferedReader(new FileReader(fileName));
		} // end try
		catch(FileNotFoundException e)
		{
			System.out.println("***Cannot open " + fileName + "***");
		} // end catch
	} // enc openInputFile
	
	
	/**
	 * Read the next line from the file and return it
	 */
	public static String readLine() 
	{
		try
		{
			return fileIn.readLine();
		} // end try
		catch(IOException e){}
		
		return null;
	} // end readLine
	
	
	/**
	 * Close the file that is currently being read from
	 */
	public static void closeInputFile() // throws IOException
	{
		try
		{
			fileIn.close();
		} // end try
		catch(IOException e){}
	} // end closeInputFile
	
} // end class