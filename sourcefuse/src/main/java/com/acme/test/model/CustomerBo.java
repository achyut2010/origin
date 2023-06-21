package com.acme.test.model;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerBo implements Serializable {
	private static final long serialVersionUID = -6007175465944595062L;
	private String name;
	private ContactInfoBo contactInfo;
	private Set<OrdersBo> orders;
}
