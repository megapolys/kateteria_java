package ru.dlosev.kateteria.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "cake_group")
@SequenceGenerator(name = "cake_group_gen", sequenceName = "cake_group_id_seq")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class CakeGroupEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cake_group_gen")
	Long id;

	@Column(name = "name")
	String name;
}
