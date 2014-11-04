package com.mirroredlineprops.alex.rebelliondice;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by AJ on 10/19/2014.
 */
public class OddsAnalysis {

    Map<String, Integer[][]> possibleDice;
    Integer[][] green = {{0,0,0,0},{1,0,0,0},{1,0,0,0},{2,0,0,0},
            {0,1,0,0},{0,1,0,0},{1,1,0,0},{0,2,0,0}};
    Integer[][] yellow = {{0,0,0,0},{1,0,0,0},{1,0,0,0},{2,0,0,0},
            {2,0,0,0},{0,1,0,0},{1,1,0,0},{1,1,0,0},
            {1,1,0,0},{0,2,0,0},{0,2,0,0},{0,0,1,0}};
    Integer[][] purple = {{0,0,0,0},{-1,0,0,0},{0,-2,0,0},{0,-1,0,0},
            {0,-1,0,0},{0,-1,0,0},{0,-2,0,0},{-1,-1,0,0}};
    Integer[][] red = {{0,0,0,0},{-1,0,0,0},{-1,0,0,0},{-2,0,0,0},
            {-2,0,0,0},{0,-1,0,0},{0,-1,0,0},{-1,-1,0,0},
            {-1,-1,0,0},{0,-2,0,0},{0,-2,0,0},{0,0,0,1}};
    Integer[][] white = {{0,0,0,0},{0,0,0,0},{1,0,0,0},
            {1,1,0,0},{0,2,0,0},{0,1,0,0}};
    Integer[][] black = {{0,0,0,0},{0,0,0,0},{-1,0,0,0},
            {-1,0,0,0},{0,-1,0,0},{0,-1,0,0}};
    /*
    int[][] force = {{1,0},{1,0},{1,0},{1,0},
            {1,0},{1,0},{2,0},{0,1},
            {0,1},{0,2},{0,2},{0,2}};
    int[][] test1 = {{1,0,0,0},{0,1,0,0}};
    int[][] test2 = {{0,0,1,0},{0,0,0,1}};
    */

    private List<Integer> matrixAdd(List<Integer> list1, List<Integer> list2) {
        if (list2.size() == 0){
            return list1;
        }
        List<Integer> total = new ArrayList<Integer>(Arrays.asList(0,0,0,0));

        for (int i=0; i< list1.size(); i++) {
            Integer j = list1.get(i) + list2.get(i);
            total.set(i, j);
        }
        return total;
    }

    private Map<List<Integer>, Double> enumerateCombinations(List<Integer[][]> dicePool){
        Map<List<Integer>, Double> combinations = new HashMap<List<Integer>, Double>();
        for (Integer[][] die: dicePool){
            combinations = addDieToMap(die, combinations);
        }
        return combinations;
    }

    private Map<List<Integer>, Double> addDieToMap(Integer[][] die, Map<List<Integer>, Double> combinations){
        if (combinations.size() == 0){
            for (Integer[] side:die){
                List<Integer> key = new ArrayList(Arrays.asList(side));
                double totalHits = 1;
                if (combinations.containsKey(key)){
                    totalHits += combinations.get(key);
                }
                combinations.put(key, totalHits);
            }
        }
        else {
            Map<List<Integer>, Double> tempMap = new HashMap<List<Integer>, Double>();

            for (Integer[] side: die) {
                for (List<Integer> combo: combinations.keySet()){
                    double totalHits = combinations.get(combo);
                    List<Integer> matrix = matrixAdd(new ArrayList(Arrays.asList(side)), combo);
                    if (tempMap.containsKey(matrix)){
                        totalHits += tempMap.get(matrix);
                    }
                    tempMap.put(matrix, totalHits);
                }
            }
            return tempMap;
        }
        return combinations;
    }

    private String outcomeString(List<Integer> result) {
        String outcome = "";
        int success = result.get(0) + result.get(2) - result.get(3);
        int advantage = result.get(1);
        int triumph = result.get(2);
        int despair = result.get(3);
        if (success > 0) {
            outcome += "Success";
        }
        else {
            outcome += "Failure";
        }
        if (advantage > 1) {
            outcome += " with 2+ Advantage";
        }
        else if (advantage==1) {
            outcome += " with 1 Advantage";
        }
        else if (advantage==-1) {
            outcome += " with 1 Threat";
        }
        else if (advantage<-1) {
            outcome += " with 2+ Threat";
        }
        if (triumph > 0) {
            outcome += " with 1+ Triumph";
        }
        if (despair > 0) {
            outcome += " with 1+ Despair";
        }
        return outcome;
    }

    private Map<String, Double> calculateSuccessRate(Map<List<Integer>, Double> totalList, double numResults) {
        Map<String, Double> outcomeMap = new HashMap<String, Double>();
        outcomeMap.put("Total Success", 0.0);
        outcomeMap.put("Total Failure", 0.0);

        for (List<Integer> result: totalList.keySet()) {
            String outStr = outcomeString(result);
            if (outStr.startsWith("Success")) {
                outcomeMap.put("Total Success", outcomeMap.get("Total Success") + totalList.get(result));
            }
            else {
                outcomeMap.put("Total Failure", outcomeMap.get("Total Failure") + totalList.get(result));
            }
            if (!outcomeMap.containsKey(outStr)){
                outcomeMap.put(outStr, totalList.get(result));
            }
            else {
                outcomeMap.put(outStr, outcomeMap.get(outStr) + totalList.get(result) );
            }
        }

        return outcomeMap;
    }

    public List<String> runOdds(String diceToAnalyze){
        List<String> retStr = new ArrayList<String>();

        Map<List<Integer>, Double> totalList = new HashMap<List<Integer>, Double>();
        List<Integer[][]> dicePool = new ArrayList<Integer[][]>();
        for (String die:diceToAnalyze.split(", ")){
            if (possibleDice.containsKey(die.toLowerCase())){
                dicePool.add(possibleDice.get(die.toLowerCase()));
            }
            else {
                Log.e("E", "Cannot find die " + die);
            }
        }
        if(dicePool.size() == 0){
            retStr.add("No dice selected");
            return retStr;
        }
        totalList = enumerateCombinations(dicePool);

        double numResults = 0;
        for(Double each:totalList.values()) {
            numResults += each;
        }
        //retStr += numResults + " possible combinations" + "\n";

        Map<String, Double> outcomeMap = calculateSuccessRate(totalList, numResults);

        double successTotal = outcomeMap.get("Total Success");
        double successPercent = ((float)successTotal /(float)numResults)*100.00000;
        if (successPercent >= 1){
            retStr.add("Total Success" + ": " + String.format("%.2f",successPercent) +"%");
        }
        else {
            retStr.add("Total Success" + ": " + "<1%");
        }

        double failureTotal = outcomeMap.get("Total Failure");
        double failurePercent = ((float)failureTotal /(float)numResults)*100.00000;
        if (failureTotal >= 1){
            retStr.add("Total Failure" + ": " + String.format("%.2f",failurePercent) +"%");
        }
        else {
            retStr.add("Total Failure" + ": " +"<1%");
        }


        outcomeMap.remove("Total Success");
        outcomeMap.remove("Total Failure");

        List<String> outcomeList = new ArrayList<String>(outcomeMap.keySet());
        Collections.sort(outcomeList);
        for (String outcome: outcomeList) {
            double outcomeTotal = outcomeMap.get(outcome);
            double percentage = ((float)outcomeTotal /(float)numResults)*100.00000;
            if (percentage >= 1) {
                retStr.add(outcome + ": " + String.format("%.2f", percentage) + "%");
            }
            else {
                retStr.add(outcome + ": " + "<1%");
            }
        }

        return retStr;
    }

    public List<String> rollDice(String diceToRoll){
        List<String> retStr = new ArrayList<String>();
        List<Integer[][]> dicePool = new ArrayList<Integer[][]>();
        for (String die:diceToRoll.split(", ")){
            if (possibleDice.containsKey(die.toLowerCase())){
                dicePool.add(possibleDice.get(die.toLowerCase()));
            }
            else {
                Log.e("E", "Cannot find die " + die);
            }
        }
        List<List<Integer>> results = decideRolls(dicePool);
        List<Integer> tally = tallyRolls(results);
        retStr.add(rollString(tally, true));
        for (List<Integer> roll:results){
            retStr.add(rollString(roll, false));
        }
        return retStr;
    }

    private List<List<Integer>> decideRolls(List<Integer[][]> dicePool) {
        List<List<Integer>> rolls = new ArrayList<List<Integer>>();
        Random rand = new Random(System.currentTimeMillis());
        for (Integer[][] die: dicePool){
            rolls.add(new ArrayList<Integer>(Arrays.asList(die[rand.nextInt(die.length)])));
        }
        return rolls;
    }

    private List<Integer> tallyRolls(List<List<Integer>> rolls) {
        List<Integer> tally = new ArrayList<Integer>();
        for (List<Integer> die: rolls){
            tally = matrixAdd(die, tally);
        }
        return tally;
    }

    private String rollString(List<Integer> result, boolean tally) {
        String outcome = "";
        int success;
        if (tally) {
            success = result.get(0) + result.get(2) - result.get(3);
        }
        else {
            success = result.get(0);
        }
        int advantage = result.get(1);
        int triumph = result.get(2);
        int despair = result.get(3);

        if (success == 0) {
            outcome += "Neutral";
        }
        else if (success > 0) {
            outcome += success + " Success";
        }
        else {
            outcome += (-1 * success) + " Failure";
        }
        if (advantage > 0) {
            outcome += ", " + advantage + " Advantage";
        }
        else if (advantage < 0) {
            outcome += ", " + (-1 *advantage) + " Threat";
        }
        if (triumph > 0) {
            outcome += ", " + triumph + " Triumph";
        }
        if (despair > 0) {
            outcome += ", " + despair + " Despair";
        }
        return outcome;
    }

    public OddsAnalysis(){
        Log.d("D", "Starting");
        possibleDice = new HashMap<String, Integer[][]>();
        possibleDice.put("green", green);
        possibleDice.put("yellow", yellow);
        possibleDice.put("purple", purple);
        possibleDice.put("red", red);
        possibleDice.put("white", white);
        possibleDice.put("black", black);
        //possibleDice.put("force", force);
    }

}
