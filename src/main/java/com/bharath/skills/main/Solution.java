package com.bharath.skills.main;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class AmountOfTime {

    int start = 0;
    TreeNode node = null;

    private void populateParents(TreeNode root, HashMap<TreeNode,TreeNode> parents){

        if(root == null) return;

        if(root.val == start) node = root;

        if(root.left != null) {
            parents.put(root.left,root);
            populateParents(root.left,parents);
        }
        if(root.right != null) {
            parents.put(root.right,root);
            populateParents(root.right,parents);
        }
    }

    public int amountOfTime(TreeNode root, int start) {

        this.start = start;
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        parents.put(root,null);
        populateParents(root,parents);


        LinkedList<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> seen = new HashSet<>();
        seen.add(node);
        int t = -1;
        q.add(node);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                TreeNode next = q.poll();
                TreeNode parent = parents.get(next);
                if(parent != null && !seen.contains(parent)){
                    q.add(parent);
                    seen.add(parent);
                }

                if(next.left != null && !seen.contains(next.left)){
                    q.add(next.left);
                    seen.add(next.left);
                }

                if(next.right != null && !seen.contains(next.right)){
                    q.add(next.right);
                    seen.add(next.right);
                }


            }
            t++;
        }

        return t;
        
    }

    public static void main(String[] args) {

        AmountOfTime sol = new AmountOfTime();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        System.out.println(sol.amountOfTime(root,1));

    }
}