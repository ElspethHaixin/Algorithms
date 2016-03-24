package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public BreadthFirstPaths(Graph G, int s)
	{
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		marked[s] = true;
		while (!q.isEmpty())
		{
			int v = q.remove();
			for (int w : G.adj(v))
			{
				if (!marked[w])
				{
					q.add(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}
	
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	public Iterable<Integer> PathTo(int v)
	{
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}
