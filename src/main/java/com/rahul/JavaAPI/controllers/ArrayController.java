package com.rahul.JavaAPI.controllers;

import com.rahul.JavaAPI.handlers.ArrayHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/array")
class ArrayController {
    @Autowired
    ArrayHandler _arrayHandler;
    @PostMapping("mergeArray")
    public List<Integer> MergeArrays(ArrayList<Integer> array1, ArrayList<Integer> array2){
        return _arrayHandler.MergeSortedArrays(array1,array2);
        }
    }
