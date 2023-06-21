package com.acme.test.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = -6007175465944595062L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max =30)
	@NotBlank
	private String name;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private ContactInfo contactInfo;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Orders> orders;
}
