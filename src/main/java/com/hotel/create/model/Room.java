package com.hotel.create.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "room")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "room_number")
	private String roomNumber;

	@Column(name = "number_of_guests")
	private String numberOfGuests;

	/*@Column(name = "room_type`")
	private String roomType;*/

	@Column(name = "floor")
	private String floor;

}
