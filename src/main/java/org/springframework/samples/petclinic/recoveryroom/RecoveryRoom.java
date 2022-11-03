package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recovery_rooms")
public class RecoveryRoom extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    Integer id;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	String name;
	
	@NotNull
	@PositiveOrZero
	double size;
	
	@NotNull
    boolean secure;
	
//	@Transient
	@ManyToOne(optional = false)
    @JoinColumn(name = "recovery_room_type_id")
    RecoveryRoomType roomType;
}