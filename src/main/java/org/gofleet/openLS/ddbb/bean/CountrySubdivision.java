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
 * CountrySubdivisionTemplate generated by hbm2java
 */
@Entity
@Table(name = "country_subdivision", schema = "public")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class CountrySubdivision implements java.io.Serializable {

	private int id;
	private String name;
	private Geometry geometry;

	public CountrySubdivision() {
	}

	public CountrySubdivision(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public CountrySubdivision(int id, String name, Geometry geometry) {
		this.id = id;
		this.name = name;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "geometry")
	public Geometry getGeometry() {
		return this.geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

}
