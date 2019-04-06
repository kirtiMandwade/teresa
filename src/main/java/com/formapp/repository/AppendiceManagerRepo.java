package com.formapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.AppendiceManager;

public interface AppendiceManagerRepo extends JpaRepository<AppendiceManager, String> {

	AppendiceManager findByAid(String id);

}
