package com.sport.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.rental.model.Storage;
import com.sport.rental.repository.StorageRepository;

@Service
public class StorageService {

	@Autowired
	StorageRepository storageRepository;

	public Storage getStorage(Integer id){
		return  storageRepository.findAllById(id);
	}
}
