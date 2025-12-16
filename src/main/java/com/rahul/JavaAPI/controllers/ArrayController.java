package com.rahul.JavaAPI.controllers;

import com.rahul.JavaAPI.handlers.ArrayHandler;
import com.rahul.JavaAPI.models.arraymodels.ArraysInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/array")
class ArrayController {
    @Autowired
    ArrayHandler _arrayHandler;

    @PostMapping("mergeArray")
    public List<Integer> MergeArrays(@RequestBody ArraysInput arraysInput) {
        return _arrayHandler.MergeSortedArrays(arraysInput.getArray1(), arraysInput.getArray2());
    }
}
