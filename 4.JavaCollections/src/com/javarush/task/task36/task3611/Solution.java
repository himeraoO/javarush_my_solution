package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.Set;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.add(i);
                if (deep > 1){
                        set.addAll(getAllFriendsAndPotentialFriends(i , deep - 1));
                }
            } else if ((i > index) && humanRelationships[i][index]) {
                set.add(i);
                if (deep > 1){
                    set.addAll(getAllFriendsAndPotentialFriends(i , deep - 1));
                }
            }
//            if (deep > 1){
//                for (Integer integer:set) {
//                    set.addAll(getAllFriendsAndPotentialFriends(i , deep - 1));
//                }
//            }
        }
        set.remove(index);
        return set;
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        //Expected: [0, 1, 2, 3, 5, 7]   4
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        /*
        По главной диагонали все элементы true, так как это один и тот же человек.
        Пересечение строки и столбца указывает, добавлены ли люди друг у друга в друзья
        (если true - то люди есть друг у друга в друзьях).
        Если человек с индексом k добавлен в друзья к человеку с индексом p,
        это означает, что у человека с индексом p в друзьях есть человек с индексом k.
        */
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}

//012357   013 257

// Expected: [0, 1, 2, 3, 5, 7]
// Expected: [2, 5, 7]