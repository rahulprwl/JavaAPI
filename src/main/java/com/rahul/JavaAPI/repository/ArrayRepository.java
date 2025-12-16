package com.rahul.JavaAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.rahul.JavaAPI.models.arraymodels.ArrayDTO;

@Document
public interface ArrayRepository extends MongoRepository<ArrayDTO, String> {
    List<ArrayDTO> findByMergedArrayLength(int length);
}
