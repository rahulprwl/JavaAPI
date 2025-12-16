package com.rahul.JavaAPI.models.arraymodels;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class ArrayDTO {

    @Id
    private String id;
    private Integer[] array1;
    private Integer[] array2;
    private Integer[] mergedArray;
    private int mergedArrayLength;
    private Date createdAt;
}
