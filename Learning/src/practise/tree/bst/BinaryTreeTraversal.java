package practise.tree.bst;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeTraversal {

	/**
	 * Time complexity = O(n)
	 * Space complexity
	 *      Best Case - Skewed binary tree = O(1) because at any given point of time only one node will present in Queue
	 *      Worst/Average case - Perfect binary tree = O(n)
	 */
	@SuppressWarnings("all")
	private void levelOrderTraversalIterative(BSTNode root) {
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
	
	/**
	 * Time complexity  = O(n2)
	 * Space complexity = O(n)
	 */ 
	private void levelOrderTraversalRecursive(BSTNode root) {
	    int h = height(root);
	    for (int i = 1; i <= h; i++) {
	        printGivenLevel(root, i);
	        System.out.println();
	    }
	}

	private void printGivenLevel(BSTNode root, int level) {
	    if (root == null) {
	    	return;
	    }
	        
	    if (level == 1) {
	        System.out.print(root.data + " ");
	    } else if (level > 1){
	        printGivenLevel(root.left, level - 1);
	        printGivenLevel(root.right, level - 1);
	    }
	}
	
	/**
	 * This method returns height of the BST and this is not correct approach.
	 * For correct approach of finding height of BST refer {@link BinarySearchTree#getHeight(BSTNode) getHeight}.
	 */
	int height(BSTNode root){
        if (root == null) {
            return 0;
        } else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

	public static void main(String[] args) {
		BSTNode root = null;

		BinarySearchTree bst = new BinarySearchTree();
		root = bst.insert(root, 6);
		root = bst.insert(root, 4);
		root = bst.insert(root, 10);
		root = bst.insert(root, 8);
		root = bst.insert(root, 19);
		root = bst.insert(root, 5);
		root = bst.insert(root, 3);

		BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
		System.out.println("\nLevel Order Traversal Recursive approach: " );
		binaryTreeTraversal.levelOrderTraversalRecursive(root);
		System.out.println("\nLevel Order Traversal Iterative approach: " );
		binaryTreeTraversal.levelOrderTraversalIterative(root);

		System.out.println("\nHeight of the BST(not correct approach): " + binaryTreeTraversal.height(root));
		System.out.println("\nHeight of the BST(correct approach): " + bst.getHeight(root));

		System.out.print("\nPre Order Traversal (DLR): " );
		binaryTreeTraversal.preOrderTraversal(root);
		System.out.print("\nIn Order Traversal (LDR): " );
		binaryTreeTraversal.inOrderTraversal(root);
		System.out.print("\nPost Order Traversal (LRD): ");
		binaryTreeTraversal.postOrderTraversal(root);
	}

	private void postOrderTraversal(BSTNode root) {
		if(root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	private void inOrderTraversal(BSTNode root) {
		if(root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	private void preOrderTraversal(BSTNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

}