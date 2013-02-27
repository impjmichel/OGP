package w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Opgave3
{
	public Opgave3(String inputFile, String outputFile, boolean keyWord)
	{
		Map<String, Collection<Integer>> map = new TreeMap<String, Collection<Integer>>();
		Reader r;
		try
		{
			r = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			StreamTokenizer st = new StreamTokenizer(r);
			
			while (st.ttype != StreamTokenizer.TT_EOF)
			{
				if(keyWord)
				{
					try
					{
						ArrayList<String> mod = new ArrayList<String>(); 
						File keyFile = new File("src/w4/sleutelwoorden.txt");
						Scanner keyScanner = new Scanner(keyFile);
						while (keyScanner.hasNext())
						{
							mod.add(keyScanner.next());
						}
						keyScanner.close();
						
						st.nextToken();
						if(st.ttype == StreamTokenizer.TT_WORD)
						{
							if (map.containsKey(st.sval) && !mod.contains(st.sval))
							{
								Collection<Integer> col = map.get(st.sval);
								col.add(st.lineno());
								map.put(st.sval.toLowerCase(), col);
							}
							else
							{
								Collection<Integer> col = new ArrayList<Integer>();
								col.add(st.lineno());
								map.put(st.sval.toLowerCase(),col);
							}
						}
						else if (st.ttype == StreamTokenizer.TT_NUMBER && !mod.contains(st.sval))
						{
							if (map.containsKey(st.nval))
							{
								Collection<Integer> col = map.get(st.nval);
								col.add(st.lineno());
								map.put(""+st.nval, col);
							}
							else
							{
								Collection<Integer> col = new ArrayList<Integer>();
								col.add(st.lineno());
								map.put(""+st.nval,col);
							}
						}
					} 
					catch (IOException ioE)
					{
						ioE.printStackTrace();
					}
				}
				else
				{
					try
					{
						st.nextToken();
						if(st.ttype == StreamTokenizer.TT_WORD)
						{
							if (map.containsKey(st.sval))
							{
								Collection<Integer> col = map.get(st.sval);
								col.add(st.lineno());
								map.put(st.sval.toLowerCase(), col);
							}
							else
							{
								Collection<Integer> col = new ArrayList<Integer>();
								col.add(st.lineno());
								map.put(st.sval.toLowerCase(),col);
							}
						}
						else if (st.ttype == StreamTokenizer.TT_NUMBER)
						{
							if (map.containsKey(st.nval))
							{
								Collection<Integer> col = map.get(st.nval);
								col.add(st.lineno());
								map.put(""+st.nval, col);
							}
							else
							{
								Collection<Integer> col = new ArrayList<Integer>();
								col.add(st.lineno());
								map.put(""+st.nval,col);
							}
						}
					} 
					catch (IOException ioE)
					{
						ioE.printStackTrace();
					}
				}
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		String text = "";
		for(String str : map.keySet())
		{
			text += str + " : " + map.get(str) + "\n";
		}
		try
		{
			FileWriter fstream = new FileWriter(outputFile);
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
