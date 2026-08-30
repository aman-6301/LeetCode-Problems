/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }

        return root.val + ","
                + serialize(root.left)
                + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");
        index =0;
        
        return deserializeTree(values);
    }

    
    public TreeNode deserializeTree(String[] values) {

        if (values[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[index]));

        index++;

        root.left = deserializeTree(values);

        root.right = deserializeTree(values);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));