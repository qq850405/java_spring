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
	private Integer id;

	@Column(nullable = false)
	private String mid;

	@Column(nullable = false)
	private String subject;

	@Column(nullable = false)
	private String location;

	@Column(nullable = false)
	private String num_students;

	@Column(nullable = false)
	private String period;

	@Column(nullable = false)
	private Integer salary;

	@Column(nullable = false)
	private String content;

	@Column(name = "create_time")
	private LocalDateTime create_time;

}

