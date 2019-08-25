package lk.moe.gisrestservice.model.geo;

import lk.moe.gisrestservice.model.School;

import java.io.Serializable;
public class GeoSchool extends GeoObject implements Serializable {

	private String type = "Feature";
	private School properties;
	private GeoPoint geometry;

	public GeoSchool(School properties) {
		this.properties = properties;
		this.geometry = new GeoPoint(new Float[]{this.properties.getLatitude(), this.properties.getLongitude()});
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public School getProperties() {
		return properties;
	}
	public void setProperties(School properties) {
		this.properties = properties;
	}
	public GeoPoint getGeometry() {
		return geometry;
	}
	public void setGeometry(GeoPoint geometry) {
		this.geometry = geometry;
	}
}
