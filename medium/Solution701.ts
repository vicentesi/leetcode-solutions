// Definition for a binary tree node.
class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}

function insertIntoBST(root: TreeNode | null, val: number): TreeNode | null {
    let node: TreeNode = new TreeNode(val);

    if (root == null) {
        root = node;
        return root;
    } else if (val < root.val) {
        root.left = insertIntoBST(root.left, val);
    } else {
        root.right = insertIntoBST(root.right, val);
    }

    return root;
};

/*
    701. Insert into a Binary Search Tree

    You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

    Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

    Example 1:
    Input: root = [4,2,7,1,3], val = 5
    Output: [4,2,7,1,3,5]

    Example 2:
    Input: root = [40,20,60,10,30,50,70], val = 25
    Output: [40,20,60,10,30,50,70,null,null,25]

    Example 3:
    Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
    Output: [4,2,7,1,3,5]

    Constraints:

    * The number of nodes in the tree will be in the range [0, 10^4].
    * -10^8 <= Node.val <= 10^8
    * All the values Node.val are unique.
    * -10^8 <= val <= 10^8
    * It's guaranteed that val does not exist in the original BST.
 */