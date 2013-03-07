package w5;

import java.util.Stack;

public class Opgave4H25
{
	private Stack<Integer> primes;
	
	public Opgave4H25(int limit)
	{
		int nmbr = 2;
		primes = new Stack<Integer>();
		while(primes.size() < limit)
		{
			if(isAPrime(nmbr))
			{
				primes.push(nmbr);
			}
			nmbr++;
		}
		
		System.out.println("# of primes : "+ primes.size());
		while(!primes.empty())
		{
			System.out.println("this prime : "+primes.pop());
		}
	}
	
	private boolean isAPrime(int a)
	{
		for(int i = 2; i <= a; i++)
		{
			if(a%i == 0 && a != i )
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] arg)
	{
		new Opgave4H25(50);
	}
}
