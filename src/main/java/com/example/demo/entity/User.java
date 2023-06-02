package com.example.demo.entity;

import java.security.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="member")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String account;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;

	@Column(name = "mail_verify")
	private String mailVerify;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@Column(name = "update_time")
	private LocalDateTime updateTime;

	@Column(name = "verify_code")
	private String verifyCode;

//	 Lombok will automatically generate the setter:
	 public void setVerifyCode(String verifyCode) {
	     this.verifyCode = verifyCode;
	 }

	public void setVerify(String status) {
		this.mailVerify = Objects.equals(status, "1") ? "1" : "0";
	}
}
