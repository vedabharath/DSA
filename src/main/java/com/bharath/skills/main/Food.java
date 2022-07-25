package com.bharath.skills.main;

import java.util.HashMap;
import java.util.TreeSet;

class Food implements Comparable<Food> {
    
    String food;
    String cuisine;
    int rating;


    @Override
    public int compareTo(Food o) {

        return this.rating == o.rating?o.food.compareTo(this.food):this.rating - o.rating;
    }

    public Food(String food, String cuisine,int rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    
    HashMap<String,Food> foodMap = new HashMap<>();
    HashMap<String, TreeSet<Food>> cuisineMap= new HashMap<>();
    int n;
    

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        n = foods.length;
        
        for(int i=0;i<n;i++){

            Food food = new Food(foods[i],cuisines[i],ratings[i]);
            
            foodMap.put(foods[i],food);
            
            if(!cuisineMap.containsKey(cuisines[i])) cuisineMap.put(cuisines[i], new TreeSet<>());
            
            TreeSet<Food> set = cuisineMap.get(cuisines[i]);
            
            set.add(food);
            
        }
        
    }
    
    public void changeRating(String food, int newRating) {

        Food old = foodMap.get(food);

        Food fresh = new Food(food,old.cuisine,newRating);

        TreeSet<Food> set = cuisineMap.get(foodMap.get(food).cuisine);
        
        set.remove(old);

        foodMap.remove(food);

        set.add(fresh);

        foodMap.put(food, fresh);
        
    }
    
    public String highestRated(String cuisine) {

        TreeSet<Food> set = cuisineMap.get(cuisine);

        return set.last().food;
        
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */