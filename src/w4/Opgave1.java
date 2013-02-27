package w4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Opgave1 
{
	private String text;
	private Collection<String> mod;
	
	public Opgave1(String inputURI, String outputURI)
	{
		try
		{
			mod = new ArrayList<String>(); 
			File keyFile = new File("src/w4/sleutelwoorden.txt");
			Scanner keyScanner = new Scanner(keyFile);
			while (keyScanner.hasNext())
			{
				mod.add(keyScanner.next());
			}
			keyScanner.close();
			readJAVAwriteHTML(inputURI,outputURI);
		}
		catch (Exception noSuchFile)
		{
			System.err.println(noSuchFile.toString());
		}
	}
	
	private void readJAVAwriteHTML(String inputURI, String outputURI)
	{
		text = "<html>\n<body>\n<pre>\n";
		try 
		{
			File file = new File(inputURI);
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				
				text += readLine(line)+"\n";
			}
			scanner.close();
			text += "</pre>\n</body>\n</html>";
			try
			{
				FileWriter fstream = new FileWriter(outputURI);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write(text);
				out.close();
			}
			catch (Exception e)
			{
				System.out.println("Output Error: " + e.getMessage());
			}
		} 
		catch (NoSuchElementException nsee)
		{
			System.err.println(nsee.toString());
		}
		catch (Exception e) 
		{
			System.out.println("Input Error: "+e.toString());
		}
	}
	
	private String readLine(String line)
	{
		String l = "";
		Set<String> modSet = new HashSet<String>();
		modSet.addAll(mod);
		Scanner lineScanner = new Scanner(line);
		
		
		
		while (lineScanner.hasNext())
		{
			String word = lineScanner.next();
			if (modSet.contains(word))
			{
				l += "<b>" + word + "</b> ";
			}
			else
			{
				l += word+" ";
			}
		}
		lineScanner.close();
		return l;
	}
}
