package w4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class Opgave2
{
	public static void main (String[] arg)
	{
		new Opgave2().writeFile("numbers.txt");
	}
	
	public void writeFile(String file)
	{
		String text = "";
		Set<Integer> set = new HashSet<Integer>();
		while(set.size() < 1000)
		{
			double rndm2 = Math.random()*5000;
			int nmbr2 = (int)(rndm2);
			set.add(nmbr2);
		}
		for(Integer i : set)
		{
			text += "\n "+i;
		}
		try
		{
			FileWriter fstream = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(text);
			out.close();
		}
		catch (Exception e)
		{
			System.out.println("Output Error: " + e.getMessage());
		}
	}
}
