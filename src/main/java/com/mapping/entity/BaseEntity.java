package com.mapping.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity implements Serializable{
	
	public static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Long id;

	@Column(name = "created_on")
	@Temporal(TemporalType.TIMESTAMP)
	Date createdOn;

	@Column(name = "updated_on")
	@Temporal(TemporalType.TIMESTAMP)
	Date updatedOn;

	@Column(name = "deleted")
	@ColumnDefault(value = "0")
	Boolean deleted = false;

	@Column(name = "active")
	Boolean active = true;
	
	@PrePersist
	public void prePersist() {
		if (createdOn == null) {
			createdOn = new Date();
		}
	}

	@PreUpdate
	public void preUpdate() {
		updatedOn = new Date();
	}


}
