package com.rahul.JavaAPI.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.JavaAPI.models.arraymodels.ArrayDTO;
import com.rahul.JavaAPI.repository.ArrayRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrayHandler {
    @Autowired
    private ArrayRepository _arrayRepository;

    public ArrayList<Integer> MergeAndSaveSortedArrays(Integer[] arr1, Integer[] arr2) {
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
        if (i < arr1.length) {
            while (i < arr1.length) {
                merged.add(arr1[i]);
                i++;
            }
        } else if (j < arr2.length) {
            while (j < arr2.length) {
                merged.add(arr2[j]);
                j++;
            }
        }
        ArrayDTO arrayDTO = new ArrayDTO();
        arrayDTO.setArray1(arr1);
        arrayDTO.setArray2(arr2);
        arrayDTO.setMergedArray(merged.toArray(new Integer[0]));
        arrayDTO.setCreatedAt(new java.util.Date());
        arrayDTO.setMergedArrayLength(merged.size());
        _arrayRepository.save(arrayDTO);
        return merged;
    }

    public List<ArrayDTO> GetAllMergedArrays() {
        return _arrayRepository.findAll();
    }

    public List<ArrayDTO> GetArraysByLength(int length) {
        return _arrayRepository.findByMergedArrayLength(length);
    }
}
