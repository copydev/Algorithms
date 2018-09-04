package Kruskal;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int source;
	int destination;
	int weight;
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
	public String toString() {
		// TODO Auto-generated method stub
		if(source<destination) {
			return source + " " + destination + " " + weight;
		}
		else {
			return destination + " " + source + " " + weight;
		}
	}
}

public class Graphs {
	
	public static int findParent(int v ,int parentArray[]) {
		if(parentArray[v]==v) {
			return v;
		}
		
		return findParent(parentArray[v], parentArray);
		
		
	}
	
	public static void kruskals(Edge input[], int n) {
		Arrays.sort(input);
		
		
		Edge output[] = new Edge[n-1];
		
		int parent[] = new int[n];
		for(int i =0;i<n;i++) {
			parent[i] = i;
		}
		
		int count = 0;
		int i =0;
		while(count!= n-1) {
			Edge currentEdge = input[i];
			
			int sourceParent = findParent(currentEdge.source, parent);
			int destinationParent = findParent(currentEdge.destination, parent);
			
			if(sourceParent!=destinationParent) {
				output[count] = currentEdge;
				count++;
				parent[sourceParent] = destinationParent;
				
			}
			i++;
			
		}
		
		for(int j =0;j<n-1;j++) {
			System.out.println(output[j].source + " " + output[j].destination + " " + output[j].weight);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int E = s.nextInt();
		
		Edge input[] = new Edge[E];
		for(int i =0;i<E;i++) {
			input[i] = new Edge();
			input[i].source = s.nextInt();
			input[i].destination = s.nextInt();
			input[i].weight = s.nextInt();
		}
		
		kruskals(input, n);
		
	}

}

//end
