package com.rahul.JavaAPI.controllers;

import com.rahul.JavaAPI.handlers.ArrayHandler;
import com.rahul.JavaAPI.models.arraymodels.ArrayDTO;
import com.rahul.JavaAPI.models.arraymodels.ArraysInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/array")
class ArrayController {
    @Autowired
    ArrayHandler _arrayHandler;

    @PostMapping("mergeArray")
    public List<Integer> MergeArrays(@RequestBody ArraysInput arraysInput) {
        return _arrayHandler.MergeAndSaveSortedArrays(arraysInput.getArray1(), arraysInput.getArray2());
    }

    @GetMapping
    public List<ArrayDTO> getArrays() {
        return _arrayHandler.GetAllMergedArrays();
    }

    @GetMapping("byLength")
    public List<ArrayDTO> getArraysByLength(@RequestParam int length) {
        return _arrayHandler.GetArraysByLength(length);
    }

}
