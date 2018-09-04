package Prim;

import java.util.Arrays;
import java.util.Scanner;

public class Graphs {
	
	public static void prims(int [][] edges, int n) {
		
		boolean visited[] = new boolean[n];
		Arrays.fill(visited, false);
		int weights[] = new int[n];
		Arrays.fill(weights, Integer.MAX_VALUE);
		int parent[] = new int[n];
		Arrays.fill(parent, -1);
		
		int index = -1;
		
		for(int i =0;i<n-1;i++) {
			int minValue = Integer.MAX_VALUE;
			
			for(int j =0;j<n;j++) {
				if(weights[j]<minValue && visited[j]==false) {
					index = j;
					minValue = weights[j];
				}
			}
			//System.out.println("min value "+ minValue+" index "+ index);
			
			if(index==-1) {
				index =0;
			}
			
			visited[index] = true;
//			for(int j =0;j<n;j++) {
//				System.out.println("visited "+j+"=" +visited[j]+" parent "+ parent[j] + " weight "+weights[j]);
//			}
			
			if(parent[index] == -1) {
				weights[index] = 0;
			}
			
			for(int j =0;j<n;j++) {
				if(edges[index][j]!=0 && edges[index][j]< weights[j] && visited[j]==false) {
					weights[j] = edges[index][j];
					parent[j] = index;
				}
			}
			
		}
		
		for(int i =0;i<n;i++) {
			if(parent[i]==-1) {
				continue;
			}
			
			if(parent[i]>i) {
				System.out.println(i+" "+parent[i]+" "+weights[i]);
			}
			else {
				System.out.println(parent[i]+" "+i+" "+weights[i]);
			}
		}
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int E = s.nextInt();
		
		int edges[][] = new int[n][n];
		
		for(int i =0;i<E;i++) {
			int source = s.nextInt();
			int des = s.nextInt();
			int weight = s.nextInt();
			edges[source][des] = weight;
			edges[des][source] = weight;
		}
		
		prims(edges,n);
		
	}

}
