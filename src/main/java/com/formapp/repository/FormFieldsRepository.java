package com.formapp.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.FormData;
import com.formapp.model.FormFields;

public interface FormFieldsRepository extends JpaRepository<FormFields, String> {




}
