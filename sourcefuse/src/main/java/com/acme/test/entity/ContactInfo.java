package com.acme.test.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContactInfo implements Serializable {
	private static final long serialVersionUID = -6007175465944595062L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max =30)
	@NotBlank
	private String address1;
	private String address2;
	@Size(max =6)
	@NotBlank
	private String pincode;
	@Size(max =20)
	@NotBlank
	private String state;
	@Size(max =15)
	@NotBlank
	private String city;
	@Size(max = 3)
	private String country;
	@MapsId
	@JsonIgnore
	private Customer customer;
}
