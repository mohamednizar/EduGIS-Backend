package lk.moe.gisrestservice.repository;

import lk.moe.gisrestservice.model.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {


	@Query(value = "SELECT * FROM schools WHERE school_zone = ?1", nativeQuery=true)
	List<School> findAllBySchoolZone(String schoolZone);

	@Query(value = "SELECT * FROM schools WHERE school_census = ?1", nativeQuery=true)
	School findSchoolById(Integer schoolId);

	@Query(value = "SELECT * FROM schools WHERE school_type = ?1", nativeQuery=true)
	List<School> findSchoolsByType(String schoolType);

	@Query(value = "SELECT * FROM schools WHERE school_type in (?1)", nativeQuery=true)
	List<School> findSchoolsByTypes(List<String> schoolTypes);

	@Query(value = "SELECT DISTINCT school_zone FROM schools", nativeQuery=true)
	List<String> findSchoolZones();
}
