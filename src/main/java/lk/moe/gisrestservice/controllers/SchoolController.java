package lk.moe.gisrestservice.controllers;

import io.swagger.annotations.*;
import lk.moe.gisrestservice.exception.BadRequestException;
import lk.moe.gisrestservice.exception.NotFoundException;
import lk.moe.gisrestservice.model.dto.SchoolListDTO;
import lk.moe.gisrestservice.model.geo.GeoJSON;
import lk.moe.gisrestservice.model.geo.GeoObject;
import lk.moe.gisrestservice.model.School;
import lk.moe.gisrestservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schools")
@Api(description = "School endpoints", produces = "application/json")
public class SchoolController {

	@Autowired
	SchoolService schoolService;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(
		value = "All schools in the database",
		response = SchoolListDTO.class
	)
	public List<School> getAllSchools() {

		SchoolListDTO schoolListDto = new SchoolListDTO(schoolService.getSchools());
		return schoolService.getSchools();
	}

	@RequestMapping(value="/census/{schoolId}", method = RequestMethod.GET)
	@ApiOperation(
		value = "Returns school by census id", notes = "/census/{schoolId}",
		response = School.class
	)
	@ApiResponses(value = {
		@ApiResponse(code = 404, message = "School census id not available") }
	)
	public School getSchoolById(@PathVariable Integer schoolId) {

		School retrievedSchool = schoolService.getSchoolById(schoolId);
		if (retrievedSchool == null) {
			throw new NotFoundException("School census id not available");
		}

		return schoolService.getSchoolById(schoolId);
	}

	@RequestMapping(value="/zone/{schoolZone}", method = RequestMethod.GET)
	@ApiOperation(
		value = "Returns schools by zone", notes = "/zone/{schoolZone}",
		response = SchoolListDTO.class
	)
	@ApiResponses(value = {
		@ApiResponse(code = 404, message = "Provided school zone not available") }
	)
	public ResponseEntity<SchoolListDTO> getSchoolsByZone(@PathVariable
							String schoolZone) {

		//is school zone available
		if (!schoolService.isAvailableSchoolZone(schoolZone)) {

			throw new NotFoundException("Provided school zone not available");

		}

		SchoolListDTO schoolListDto = new SchoolListDTO(schoolService.getSchoolsByZone(schoolZone));
		return ResponseEntity.ok(schoolListDto);

	}


	@RequestMapping(value="/type", method = RequestMethod.GET)
	@ApiOperation(
		value = "Returns schools by multiple types", notes = "/type?schoolTypes=1C,1AB",
		response = SchoolListDTO.class
	)
	@ApiResponses(value = {
		@ApiResponse(code = 400, message = "Invalid School Type") }
	)
	public ResponseEntity<SchoolListDTO> getSchoolsByType(@RequestParam List<String> schoolTypes) {

		//validate types
		if (!schoolService.validType(schoolTypes)) {

			throw new BadRequestException("Invalid School Type");

		}
		SchoolListDTO schoolListDto = new SchoolListDTO(schoolService.getSchoolsByTypes(schoolTypes));
		return ResponseEntity.ok(schoolListDto);
	}

	@RequestMapping(value="/geo", method = RequestMethod.GET)
	@ApiOperation(
		value = "GeoJSON layer for all schools", notes = "returns all schools",
		response = GeoJSON.class

		)
	public ResponseEntity<GeoJSON> geoGetAllSchools() {

		List<? extends GeoObject> geoSchoolsList = schoolService.geoGetSchools();
		return ResponseEntity.ok(new GeoJSON((List<GeoObject>) geoSchoolsList));
	}


}
