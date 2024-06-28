package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlansEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;

	private String planName;
	
	private String activeSW;

	private LocalDate planStartDate;

	private LocalDate planEndDate;
	
	  @PrePersist
	    public void prePersist() {
	        if (planStartDate == null) {
	            // Provide default value if planStartDate is null
	            planStartDate = LocalDate.now();
	        }
	        if (planEndDate == null) {
	            planEndDate = planStartDate.plusYears(1);
	        }
	    }

	
}
