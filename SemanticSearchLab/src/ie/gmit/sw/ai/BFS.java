package ie.gmit.sw.ai;
import java.util.*;

public class BFS {
	private LinkedList<Node> queue = new LinkedList<Node>();
	
	public BFS(Maze maze) {
		Node start = maze.getStartNode();
		start.colour(Colour.Black);
		queue.addLast(start);
		search(start);
	}
	
	public void search(Node node){
		while(!queue.isEmpty()){
			if (node.isGoalNode()){
				System.out.println("Reached goal node " + node.getNodeName());
				System.exit(0);
			}else{
				Node[] children = node.children();
				queue.removeFirst();
				for (int i = 0; i < children.length; i++) {
				//for (int i = children.length - 1; i >= 0; i--) {
					if (children[i].getColour() == Colour.White){
						queue.addLast(children[i]);
						children[i].colour(Colour.Grey);
					}
				}
			}
			node = queue.getFirst();
			node.colour(Colour.Black);
		}
	}

	public static void main(String[] args) {
		Maze maze = Maze.getInstance();
		BFS search = new BFS(maze);
	}
}
