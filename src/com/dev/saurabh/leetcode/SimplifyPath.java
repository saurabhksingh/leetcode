package com.dev.saurabh.leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/18/12
 * Time: 3:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimplifyPath {

    public static void main(String [] args)
    {
        SimplifyPath instance = new SimplifyPath();
        instance.runTest();
    }

    private void runTest() {
        System.out.println(simplifyPath("/home/of/foo/../../bar/../../is/./here/."));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for(int i=1; i<path.length();)
        {
            while(i<path.length() && path.charAt(i) == '/')i++;
            if(i<path.length())
            {
                if(path.charAt(i) == '.')
                {
                    if((i+1)<path.length() && path.charAt(i+1)=='/')
                    {
                        i=i+2;
                    }
                    else if((i+1) < path.length())
                    {
                        if(!stack.empty())
                        {
                            stack.pop();
                        }
                        i = i+3;
                    }
                    else
                    {
                        break;
                    }
                }

                else
                {
                    StringBuilder sb = new StringBuilder();
                    while(i<path.length() && path.charAt(i)!='/')
                    {
                        sb.append(path.charAt(i++));
                    }

                    stack.push(sb.toString());
                }
            }
        }

        String out = "";
        if(!stack.empty())
        {
            out = stack.pop();
        }
        while(!stack.empty())
        {
            out = stack.pop()+"/"+out;
        }
        out = "/"+out;

        return out;

    }
}
