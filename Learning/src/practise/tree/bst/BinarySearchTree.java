package practise.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {

    public BSTNode insert(BSTNode root, int data) {
        if(root == null) {
            root = new BSTNode(data);
        } else if(data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public boolean search(BSTNode root, int data) {
        if(root == null) {
            return false;
        } else if(root.data == data) {
            return true;
        } else if(data <= root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    public int findMinIterative(BSTNode root) {
        if(root == null) {
            return -1;
        }
        BSTNode temp = root;
        while(temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    public int findMinRecursion(BSTNode root) {
        if(root == null) {
            return -1;
        }
        if(root.left == null){
            return root.data;
        }
        return findMinRecursion(root.left);
    }

    public int findMaxIterative(BSTNode root) {
        if(root == null) {
            return -1;
        }
        BSTNode temp = root;
        while(temp.right != null) {
            temp = temp.right;
        }
        return temp.data;
    }

    public int findMaxRecursion(BSTNode root) {
        if(root == null) {
            return -1;
        }
        if(root.right == null){
            return root.data;
        }
        return findMaxRecursion(root.right);
    }

    @SuppressWarnings("all")
    public void print(BSTNode root) {
		if (root == null) {
			return;
		}
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int numberOfNodeInQueue = queue.size();

			while (numberOfNodeInQueue > 0) {
				BSTNode node = queue.poll();
				System.out.print(node.data + " ");
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				numberOfNodeInQueue--;
			}
			System.out.println();
		}
	}

    public int getHeight(BSTNode root) {
    	if(root == null) {
    		return -1;
    	}
    	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] ags) {
    	BinarySearchTree bst = new BinarySearchTree();
        BSTNode root = null;
        root = bst.insert(root, 15);
        root = bst.insert(root, 10);
        root = bst.insert(root, 20);
        root = bst.insert(root, 25);
        root = bst.insert(root, 8);
        root = bst.insert(root, 12);

        System.out.println("Enter a to be searched: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();

        boolean found = bst.search(root, input);
        if(found) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }

        System.out.println("Minimum element in BST: " + bst.findMinIterative(root) + ":" + bst.findMinRecursion(root));
        System.out.println("Maximum element in BST: " + bst.findMaxIterative(root) + ":" + bst.findMaxRecursion(root));

        System.out.println("Printing BST: ");
        bst.print(root);
        System.out.println("Height of BST: " + bst.getHeight(root));
    }
}