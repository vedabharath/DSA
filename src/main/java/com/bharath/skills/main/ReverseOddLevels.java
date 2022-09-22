package com.bharath.skills.main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class ReverseOddLevels {
    
    public TreeNode reverseOddLevels(TreeNode root) {
              
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<Integer> list;
        
        q.add(root);
        
        int level = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            list = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                
                TreeNode node = q.poll();
                
                if(node.left != null) {
                    q.add(node.left);
                    list.add(node.left.val);
                }
                if(node.right != null){
                    q.add(node.right);
                    list.add(node.right.val);
                }
                
            }
            
            if(level%2 == 0){
                
                Iterator<TreeNode> itr = q.iterator();
                
                int index = q.size()-1;
                
                while(itr.hasNext()){
                    TreeNode node = itr.next();
                    node.val = list.get(index--);
                }
            }
            
            level++;
        }
        
        return root;
        
    }
}