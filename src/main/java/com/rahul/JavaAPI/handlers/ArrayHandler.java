package com.rahul.JavaAPI.handlers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class ArrayHandler {
    public ArrayList<Integer> MergeSortedArrays(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> merged=new ArrayList<Integer>();
        int i=0,j=0;
        while (i<arr1.size() ||j<arr2.size())
        {
            if (arr1.get(i)<arr2.get(j))
            {
                merged.add(arr1.get(i));
                i++;
            }
            else{
                merged.add(arr2.get(j));
                j++;
            }
        }
        return merged;
    }
}
