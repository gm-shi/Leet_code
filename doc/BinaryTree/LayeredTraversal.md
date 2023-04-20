---
title: "Binary Tree Layered Traversal Template"
parent: BinaryTree
layout: default
---

# Binary Tree Layered Traversal Template

![Example](../../assets/layered.gif)

**Solution:**

### 1. Template->Recursion

```java

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        if(root == null) return res;
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode node, Integer depth) {

        if(node == null) return;
        if(res.size() == depth) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(node.val);
        dfs(res, node.left, depth + 1);
        dfs(res, node.right, depth + 1);
    }
}

```

### 2. Template->Iterative

```java

class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<Integer> item = new ArrayList();
            int len = queue.size();

            while(len > 0) {
                TreeNode tmp = queue.poll();
                item.add(tmp.val);
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
                len--;
            }
            res.add(item);
        }
        return res;

    }
}

```
