package lk.moe.gisrestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "schools")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@ApiModel(description = "Class representing a School")
public class School implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "school_census")
	@ApiModelProperty(notes = "School census id", example = "1003", required = true, position = 0)
	private Long schoolCensus;

	@Column(name = "school_name")
	@ApiModelProperty(notes = "School name", example = "PAMUNUGAMA MAHA VIDYALAYA", required = true, position = 1)
	private String schoolName;

	@Column(name = "school_zone")
	@ApiModelProperty(notes = "School zone", example = "NEGOMBO", required = true, position = 2)
	private String schoolZone;

	@Column(name = "school_type")
	@ApiModelProperty(notes = "School type/academics", example = "1C", required = true, position = 3)
	private String schoolType;

	@Column(name = "number_of_students")
	@ApiModelProperty(notes = "Number of students", example = "100", required = false, position = 4)
	private Integer numberOfStudent;
	//private Coordinates coordinates;
	//private SchoolGender gender;
	//private SchoolCategory schoolCategory;

	@Column(name = "latitude")
	@ApiModelProperty(notes = "Latitude", example = "7.0728064", required = false, position = 5)
	private Float latitude;

	@Column(name = "longitude")
	@ApiModelProperty(notes = "Longitude", example = "79.85705", required = false, position = 6)
	private Float longitude;

	@Column(name = "gender_composition")
	@ApiModelProperty(notes = "Gender composition", example = "Mixed", required = false, position = 7)
	private String gender;

	@Column(name = "school_category")
	@ApiModelProperty(notes = "School category", example = "Mixed", required = false, position = 8)
	private String category;

	public Long getSchoolCensus() {
		return schoolCensus;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public String getSchoolZone() {
		return schoolZone;
	}
	public String getSchoolType() {
		return schoolType;
	}
	public Integer getNumberOfStudent() {
		return numberOfStudent;
	}
	public Float getLatitude() {
		return latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public String getGender() {
		return gender;
	}
	public String getCategory() {
		return category;
	}


}
