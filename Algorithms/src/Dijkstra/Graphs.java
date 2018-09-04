package Dijkstra;

import java.util.Arrays;
import java.util.Scanner;

public class Graphs {
	
	public static void dijkstra(int edges[][], int n) {
		boolean visited[] = new boolean[n];
		Arrays.fill(visited, false);
		int weight[] = new int[n];
		Arrays.fill(weight, Integer.MAX_VALUE);
		weight[0] = 0;
		for(int i =0;i<n;i++) {
			int index = minIndex(weight,visited);
			visited[index] = true;
			for(int j =0;j<n;j++) {
				if(edges[index][j]!=0 && edges[index][j]+weight[index]<weight[j] && visited[j]==false) {
					weight[j] = edges[index][j]+weight[index];
				}
			}
			
		}
		
		for(int i =0;i<n;i++) {
			System.out.println(i+" "+weight[i]);
		}
	}
	
	public static int minIndex(int weight[], boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i =0;i<weight.length;i++) {
			if(min>weight[i]&& visited[i]==false) {
				min = weight[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
		int E;
		n = s.nextInt();
		E = s.nextInt();
				
		int edges[][] = new int[n][n];
		for(int i =0;i<E;i++) {
			int source = s.nextInt();
			int des = s.nextInt();
			int weight = s.nextInt();
			edges[source][des] = weight;
			edges[des][source] = weight;
		}
		
		dijkstra(edges,n);
		
	}

}

// end
