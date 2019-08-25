package lk.moe.gisrestservice.service;

import lk.moe.gisrestservice.model.geo.GeoSchool;
import lk.moe.gisrestservice.model.School;
import lk.moe.gisrestservice.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class SchoolService {

	@Autowired
	SchoolRepository repository;

	/**
	 * Get all schools
	 * @return
	 */
	public List<School> getSchools() {

		return (List<School>) repository.findAll();

	}

	/**
	 * Get school by zone
	 * @param schoolZone
	 * @return
	 */
	public List<School> getSchoolsByZone(String schoolZone) {

		return repository.findAllBySchoolZone(schoolZone);

	}

	/**
	 * Get school by census id
	 * @param schoolId
	 * @return
	 */
	public School getSchoolById(Integer schoolId) {

		return repository.findSchoolById(schoolId);

	}

	/**
	 * Get schools by multiple types
	 * @param schoolTypes
	 * @return
	 */
	public List<School> getSchoolsByTypes(List<String> schoolTypes) {

		return repository.findSchoolsByTypes(schoolTypes);

	}

	/**
	 * List of geojson features of schools
	 * @return
	 */
	public List<GeoSchool> geoGetSchools() {

		List<School> schools = (List<School>) repository.findAll();
		List<GeoSchool> geoSchoolsList = new ArrayList<>();

		for(School school : schools) {
			geoSchoolsList.add(new GeoSchool(school));
		}

		return geoSchoolsList;

	}

	/**
	 * Check given school type(s) are valid
	 * @param types
	 * @return
	 */
	public Boolean validType(List<String> types) {

		ArrayList<String> typesArray = new ArrayList<>(Arrays.asList("1C", "1AB", "Type 2", "Type 3"));

		for(String type : types) {
			if(!typesArray.contains(type)) {
				return false;
			}

		}

		return true;
	}

	/**
	 * Check given school zone exist
	 * @param schoolZone
	 * @return
	 */
	public Boolean isAvailableSchoolZone(String schoolZone) {

		return repository.findSchoolZones().stream().anyMatch(schoolZone::equalsIgnoreCase);

	}



}
