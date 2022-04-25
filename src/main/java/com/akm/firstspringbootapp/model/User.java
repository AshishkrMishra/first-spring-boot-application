package com.akm.firstspringbootapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document ("User")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

	@Id 
	private UserKey  userKey;

	private String firstName;

	private String middelName;

	private String lastName;

}
