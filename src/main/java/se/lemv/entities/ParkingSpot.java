package se.lemv.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
ParkingSpace
	- id 		: Long   : not null
	- label 	: String : not null
 * @author leo
 */
@Embeddable
public class ParkingSpot {

	@Column(unique = true)
	private Long parkingSpaceId;
	
	@Column(nullable = false)
	private String label;
	
	protected ParkingSpot() {}
	
	public ParkingSpot(Long parkingSpaceId, String label) {
		this.parkingSpaceId = parkingSpaceId;
		this.label = label;
	}
	
	public Long getParkingSpaceId() {
		return parkingSpaceId;
	}
	
	public String getLabel() {
		return label;
	}
}
