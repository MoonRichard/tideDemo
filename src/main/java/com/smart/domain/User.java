package com.smart.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_user")
public class User extends BaseDomain {
	/**
	 * 锁定用户对应的状态值
	 */
	public static final int USER_LOCK = 1;
	/**
	 * 用户解锁对应的状态值
	 */
	public static final int USER_UNLOCK = 0;
	/**
	 * 管理员类型
	 */
	public static final int FORUM_ADMIN = 2;
	/**
	 * 普通用户类型
	 */
	public static final int NORMAL_USER = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_type")
	private int userType = NORMAL_USER;

	@Column(name = "password")
	private String password;

	@Column(name = "locked")
	private int locked;

	@Column(name = "user_location")
	private String userLocation;

	@Column(name = "user_sex")
	private int userSex;

	@Column(name = "user_age")
	private int userAge;

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public int getUserSex() {

		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public String getUserLocation() {

		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public int getLocked() {

		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {

		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {

		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
