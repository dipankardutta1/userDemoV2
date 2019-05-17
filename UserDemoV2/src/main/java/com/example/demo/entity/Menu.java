package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="menu_label")
	private String manuLabel;
	@Column(name="menu_url")
	private String manuUrl;
	
	
	@OneToMany(mappedBy="menu")
	private List<RoleMenuMapping> roleMenuMappings;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getManuLabel() {
		return manuLabel;
	}
	public void setManuLabel(String manuLabel) {
		this.manuLabel = manuLabel;
	}
	public String getManuUrl() {
		return manuUrl;
	}
	public void setManuUrl(String manuUrl) {
		this.manuUrl = manuUrl;
	}
	public List<RoleMenuMapping> getRoleMenuMappings() {
		return roleMenuMappings;
	}
	public void setRoleMenuMappings(List<RoleMenuMapping> roleMenuMappings) {
		this.roleMenuMappings = roleMenuMappings;
	}
	
	
	

}
