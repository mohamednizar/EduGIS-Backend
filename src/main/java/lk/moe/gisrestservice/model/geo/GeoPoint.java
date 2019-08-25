package lk.moe.gisrestservice.model.geo;
import java.io.Serializable;
public class GeoPoint extends GeoObject implements Serializable {

	private String type = "Point";
	private Float[] coordinates = new Float[2];

	public GeoPoint(Float[] _coordinates) {
		coordinates = _coordinates;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Float[] coordinates) {
		this.coordinates = coordinates;
	}
}
