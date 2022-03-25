package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {

    private String currencyCode;

    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            int c = denominations.get(denomination);
            denominations.put(denomination, c + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {

        Map<Integer, Integer> total = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> tempTotal = new TreeMap<>(Collections.reverseOrder());
        ArrayList<Integer> arrayList = new ArrayList<Integer>(denominations.keySet());
        Map<Integer, Integer> copyDenomination = new TreeMap<>(denominations);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        Integer[] nominals = arrayList.toArray(new Integer[0]);
        int change = expectedAmount;
        for (int i = 0; i < nominals.length; ) {
            int d = nominals[i];
            if((change >= d) && (copyDenomination.get(d) > 0)){
                int c = change / d;
                int r = copyDenomination.get(d);
                if (c < r){
//                    if(tempTotal.containsKey(d)){
//                        tempTotal.put(d, tempTotal.get(d) + c);
//                    }else {
                        tempTotal.put(d, c);
//                    }
                    copyDenomination.put(d, copyDenomination.get(d) - c);
                    change -= (d * c);
                }else if(r <= c){
//                    if(tempTotal.containsKey(d)){
//                        tempTotal.put(d, tempTotal.get(d) + r);
//                    }else {
                        tempTotal.put(d, r);
//                    }
                    copyDenomination.put(d, copyDenomination.get(d) - r);
                    change -= (d * r);
                }
                if (change > 0){
                    i++;
                    continue;
                }
                if(change == 0){
                    break;
                }
            }else {
                i++;
            }
        }
        if (change > 0){
            throw new NotEnoughMoneyException();
        }
        if (change == 0){
            denominations = copyDenomination;
            total = tempTotal;
        }




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        Map<Integer, Integer> total = new TreeMap<>();
//        ArrayList<Integer> nomin = new ArrayList<>(denominations.keySet());
//        Collections.sort(nomin);
//        Collections.reverse(nomin);
//        int num = 0;
//        for (Integer coin: nomin) {
//            if(expectedAmount >= coin){
//                if(denominations.containsKey(coin)){
//                    int count = denominations.get(coin);
//                    num = coin;
//                    double r = expectedAmount % coin;
//                    double del = expectedAmount / (double)coin;
//                    if ((r == 0)&&(count >= del)){
//                        total.put(coin, count);
//                        denominations.put(coin, count - (int) del);
//                    }
//
//
//
////                    if (count > 1){
////
////                    }
//                }
//            }
//        }
//        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
//
//        Map<Integer, Integer> mapStore = new TreeMap<>(Collections.reverseOrder());
//        mapStore.putAll(denominations);
//        Map<Integer, Integer> map2 = new TreeMap<>(denominations);
////       Map<Integer, Integer> mapStore2 = new TreeMap<>(denominations);
//        Map<Integer, Integer> mapStore2 = new TreeMap<>();
//        Map<Integer, Integer> total = new HashMap<>();
//        int summ = 0;
//        int num = 0;
//        int val = 0;
//        int add = 0;
//        int val2 = 0;
//        int flag = 0;
//        int flag2 = 0;
//        boolean b = true;
//        for (Map.Entry<Integer, Integer> entry : mapStore.entrySet()) {
//            total.clear();
//            map.clear();
//            map.putAll(denominations);
//            map2.clear();
//            if (expectedAmount == summ) {
//                break;
//            }
//            summ = 0;
//            num = 0;
//            if (entry.getValue() > 0) {
//                num = entry.getKey();
//                flag2 = num;
//                if (expectedAmount > summ + num) {
//                    val = entry.getValue();
//                    if (val > 1) {
//                        map.put(num, val - 1);
////                        map2.put(num, val - 1);
////                            if(total.containsKey(num)) {
////                                int t = total.get(num);
////                                total.put(num, t + 1);
////                            }else {
//                        total.put(num, 1);
////                            }
//                        summ += num;
//                    } else {
//                        map.remove(num);
////                        map2.remove(num);
////                            if(total.containsKey(num)) {
////                                int t = total.get(num);
////                                total.put(num, t + 1);
////                            }else {
//                        total.put(num, 1);
////                            }
//                        summ += num;
//                    }
//                }
//                if (expectedAmount == summ) {
////                    total.put(num, 1);
//                    break;
//                }
//
//            }
//            map2.putAll(map);
//
//            while (b) {
//                mapStore2.clear();
//                mapStore.putAll(map2);
//                for (Map.Entry<Integer, Integer> entry2 : mapStore2.entrySet()) {
//                    b = false;
//                    if (flag2 <= entry2.getKey()) {
//                        if (entry2.getValue() > 0) {
//                            add = entry2.getKey();
//                            if (expectedAmount >= (summ + add)) {
//                                flag = add;
//                                b = true;
//                            }
//                        }
//                    }
//                }
//
//                if (!b) {
//                    break;
//                }
//                val2 = map2.get(flag);
//                if (val > 1) {
//                    if (total.containsKey(flag)) {
//                        int t = total.get(flag);
//                        total.put(flag, t + 1);
//
//                    } else {
//                        total.put(flag, 1);
//                    }
//                    map.put(flag, val2 - 1);
//                    map2.put(flag, val2 - 1);
//                    summ += flag;
//                } else {
//                    if (total.containsKey(flag)) {
//                        int t = total.get(flag);
//                        total.put(flag, t + 1);
//
//                    } else {
//                        total.put(flag, 1);
//                    }
//                    map.remove(flag);
//                    map2.remove(flag);
//                    summ += flag;
//                }
//
//            }
//            if (expectedAmount == summ) {
//                break;
//            }
////                if(expectedAmount >= entry.getKey()) {
////                    int s = sum / entry.getKey();
////                    if(s <= entry.getValue()){
////                        total.put(entry.getKey(), s);
////                        sum -= s * entry.getKey();
////                    }
////                }
//        }
//
//
//        if (expectedAmount == summ) {
//            for (Map.Entry<Integer, Integer> e : total.entrySet()) {
//                int n = denominations.get(e.getKey());
//                denominations.put(e.getKey(), n - e.getValue());
//            }
//            return total;
//        } else {
//            throw new NotEnoughMoneyException();
//        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        int sum = 0;
//        TreeMap<Integer, Integer> copyDenominations = new TreeMap<>(denominations);
//        ArrayList<Integer> keys = new ArrayList<>(this.denominations.keySet());
//        Collections.sort(keys);
//        Collections.reverse(keys);
//        ArrayList<Integer> keys2 = new ArrayList<>(this.denominations.keySet());
//        Collections.sort(keys2);
//        TreeMap<Integer, Integer> total = new TreeMap<>();
//        TreeMap<Integer, Integer> temp = new TreeMap<>();
//        int size = 0;
//        int flag = 0;
//        for (Integer integer: keys) {
//            sum = expectedAmount;
//            copyDenominations.clear();
//            copyDenominations.putAll(denominations);
//            if(sum >= integer) {
//                int count = copyDenominations.get(integer);
//                if (count > 0) {
//                    flag = integer;
//                    boolean b = true;
//                    int addCoin = 0;
//                    int tempSize = 0;
//                    temp.clear();
//                    while (b) {
//                        b = false;
//                        for (Integer integer2 : keys2) {
//                            if ((integer2 <= sum)&&(integer2 <= flag)){
//                                if(copyDenominations.get(integer2) > 0) {
//                                    addCoin = integer2;
//                                    b = true;
//                                }
//                            }
//                        }
//                        if(b) {
//                            sum = sum - addCoin;
//                            if (sum == 0) {
//                                if(temp.containsKey(addCoin)){
//                                    int t = temp.get(addCoin);
//                                        temp.put(addCoin, t+1);
//                                }else {
//                                    temp.put(addCoin, 1);
//                                }
//                                copyDenominations.put(addCoin, copyDenominations.get(addCoin) - 1);
//                                tempSize++;
//                                if (tempSize < size) {
//                                    total = temp;
//                                    size = tempSize;
//                                }
//                                break;
//                            }
//
//                            if (sum > 0) {
//                                if(temp.containsKey(addCoin)){
//                                    int t = temp.get(addCoin);
//                                    temp.put(addCoin, t+1);
//                                }else {
//                                    temp.put(addCoin, 1);
//                                }
//                                copyDenominations.put(addCoin, copyDenominations.get(addCoin) - 1);
//                                tempSize++;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//
//
//        if (total.isEmpty())
//            throw new NotEnoughMoneyException();
//        else {
////            this.denominations.clear();
////            this.denominations.putAll(total);
//            for (Map.Entry<Integer, Integer> e : total.entrySet()) {
//                int n = denominations.get(e.getKey());
//                denominations.put(e.getKey(), n - e.getValue());
//            }
//        }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        int sum = expectedAmount;
//        HashMap<Integer, Integer> copyDenominations = new HashMap<>(denominations);
//
//        ArrayList<Integer> keys = new ArrayList<>(this.denominations.keySet());
//
//        Collections.sort(keys);
//        Collections.reverse(keys);
//
//        TreeMap<Integer, Integer> resultMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        for (Integer denomination : keys) {
//            final int key = denomination;
//            int value = copyDenominations.get(key);
//            while (true) {
//                if (sum < key || value == 0) {
//                    copyDenominations.put(key, value);
//                    break;
//                }
//                sum -= key;
//                value--;
//
//                if (resultMap.containsKey(key))
//                    resultMap.put(key, resultMap.get(key) + 1);
//                else
//                    resultMap.put(key, 1);
//            }
//        }
//
//        if (sum > 0)
//            throw new NotEnoughMoneyException();
//        else {
//            this.denominations.clear();
//            this.denominations.putAll(copyDenominations);
//        }
//        return resultMap;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        return total;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

}
