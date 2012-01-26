package org.gofleet.openLS.ddbb.bean;

// Generated 07-oct-2011 14:06:19 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.vividsolutions.jts.geom.Geometry;

/**
 * PostalCodeTemplate generated by hbm2java
 */
@Entity
@Table(name = "postal_code", schema = "public")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class PostalCode implements java.io.Serializable {

	private int id;
	private String code;
	private String type;
	private Geometry geometry;

	public PostalCode() {
	}

	public PostalCode(int id, String code) {
		this.id = id;
		this.code = code;
	}

	public PostalCode(int id, String code, String type, Geometry geometry) {
		this.id = id;
		this.code = code;
		this.type = type;
		this.geometry = geometry;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "code", nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "geometry")
	public Geometry getGeometry() {
		return this.geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

}
