package com.rahul.JavaAPI.handlers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrayHandler {
    public ArrayList<Integer> MergeSortedArrays(Integer[] arr1, Integer[] arr2) {
        ArrayList<Integer> merged = new ArrayList<Integer>();
        if (arr1 == null && arr2 == null) {
            return merged;
        }
        if (arr1 == null || arr1.length == 0) {
            for (Integer num : arr2) {
                merged.add(num);
            }
            return merged;
        }
        if (arr2 == null || arr2.length == 0) {
            for (Integer num : arr1) {
                merged.add(num);
            }
            return merged;
        }

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged.add(arr1[i]);
                i++;
            } else {
                merged.add(arr2[j]);
                j++;
            }
        }
        return merged;
    }
}
