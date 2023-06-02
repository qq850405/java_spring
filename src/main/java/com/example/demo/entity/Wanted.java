package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="wish")
@NoArgsConstructor
@AllArgsConstructor
public class Wanted {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(nullable = false)
	public String mid;

	@Column(nullable = false)
	public String subject;

	@Column(nullable = false)
	public String location;

	@Column(nullable = false)
	public String num_students;

	@Column(nullable = false)
	public String period;

	@Column(nullable = false)
	public Integer salary;

	@Column(nullable = false)
	public String content;

	@Column(name = "create_time")
	public LocalDateTime create_time;

}

