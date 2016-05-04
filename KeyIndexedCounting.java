package radixSorts;

public class KeyIndexedCounting {
	
	public static void sort(int[] a, int R)
	{
		int N = a.length;
		int[] aux = new int[N];
		int[] count = new int[R + 1];
		
		for (int i = 0; i < N; i++)
			count[a[i] + 1]++;
		
		for (int i = 0; i < R; i++)
			count[i + 1] += count[i];
		
		for (int i = 0; i < N; i++)
			aux[count[a[i]]++] = a[i];
		
		for (int i = 0; i < N; i++)
			a[i] = aux[i];
	}
	
}
