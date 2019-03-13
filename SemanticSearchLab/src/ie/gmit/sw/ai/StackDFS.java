package ie.gmit.sw.ai;

import java.util.*;

public class StackDFS {
	// using as stack
	private LinkedList<Node> queue = new LinkedList<Node>();

	public StackDFS(Maze maze) {
		Node start = maze.getStartNode();
		start.setVisited(true);
		queue.addFirst(start); // Add to linked list
		search(start);
	}

	public void search(Node node) {
		while (!queue.isEmpty()) {
			System.out.println("[NODE]:" + node);
			if (node.isGoalNode()) {
				System.out.println("Reached goal node " + node.getNodeName());
				System.exit(0);
			} else {
				// get children of current node
				Node[] children = node.children();
				for (int i = 0; i < children.length; i++) { // better than below (By chance).
					// for (int i = children.length - 1; i >= 0; i--) {
					// if not visited add to stack
					if (!children[i].isVisited()) {
						 queue.addFirst(children[i]);
						//queue.addLast(children[i]);
					}
				}
			}
			node = queue.poll();
			//node.setVisited(true);
			// queue.removeFirst();
		}

	}

	public static void main(String[] args) {
		Maze maze = Maze.getInstance();
		StackDFS search = new StackDFS(maze);
	}
}
