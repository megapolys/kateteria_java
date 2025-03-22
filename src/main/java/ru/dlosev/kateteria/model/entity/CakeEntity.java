package ru.dlosev.kateteria.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "cake")
@SequenceGenerator(name = "cake_gen", sequenceName = "cake_id_seq")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class CakeEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cake_gen")
	Long id;

	@Column(name = "group_id")
	Long groupId;

	@Column(name = "uuid")
	UUID uuid;

	@Column(name = "title")
	String title;

	@Column(name = "description")
	String description;

	@Column(name = "cost")
	Integer cost;
}
