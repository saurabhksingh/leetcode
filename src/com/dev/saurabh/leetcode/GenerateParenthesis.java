package com.dev.saurabh.leetcode;

import java.util.ArrayList;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/11/12
 * Time: 9:37 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class GenerateParenthesis {

    public static void main(String [] args)
    {
        GenerateParenthesis instance = new GenerateParenthesis();
        long startTime = System.currentTimeMillis();
        for(int i=1; i<=8; i++)
        {
            ArrayList <String> result = instance.generateParenthesis(i);
            for(String brackets : result)
            {
                System.out.println(brackets);
            }
        }
        System.out.println(System.currentTimeMillis()-startTime);
    }

    public ArrayList<String> generateParenthesis(int n)
    {
        ArrayList<String> result = new ArrayList<String>();

        if(n  == 0)
        {
            return result;
        }
        else if(n == 1)
        {
            result.add("()");
            return result;
        }

        ArrayList<String> tempResult = generateParenthesis(n-1);
        for(String brackets : tempResult)
        {
            result.add("("+brackets+")");

            String firstSet = "()"+brackets;
            result.add(firstSet);
            if('('!=brackets.charAt(0) || ')'!=brackets.charAt(1) || '('!=brackets.charAt(brackets.length()-2) || ')'!=brackets.charAt(brackets.length()-1))
            {
                String secondSet = brackets+"()";
                result.add(secondSet);
            }
        }

        return result;
    }
}
