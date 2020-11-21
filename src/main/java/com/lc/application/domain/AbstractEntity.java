package com.lc.application.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;


@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Persistable<ID> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private ID id;

	@Override
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {
		
		return null == getId();
	}

	@Override
	public String toString() {
		
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (!(o instanceof AbstractEntity)) {
			return false;
		}
		AbstractEntity<?> that = (AbstractEntity<?>) o;

		return Objects.equals(id, that.id);
	}
}