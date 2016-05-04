package radixSorts;

import java.util.Arrays;

public class SuffixArray {
	
	private String[] suffixes;
	
	private void init(String s)
	{
		int N = s.length();
		suffixes = new String[N];
		for (int i = 0; i < N; i++)
			suffixes[i] = s.substring(i, N);
	}
	
	private int lcp(String s, String t)
	{
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++)
			if (s.charAt(i) != t.charAt(i))
				return i;
		return N;
	}
	
	public String lrs(String s)
	{
		init(s);
		
		Arrays.sort(suffixes);
		
		int N = s.length();
		String lrs = "";
		for (int i = 0; i < N - 1; i++)
		{
			int len = lcp(suffixes[i], suffixes[i + 1]);
			if (len > lrs.length())
				lrs = suffixes[i].substring(0, len);
		}
		return lrs;
	}
	
}
