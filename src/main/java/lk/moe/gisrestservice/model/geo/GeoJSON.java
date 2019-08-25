package lk.moe.gisrestservice.model.geo;
import java.io.Serializable;
import java.util.List;
public class GeoJSON implements Serializable {

	private String type = "FeatureCollection";
	List<GeoObject> features;

	public GeoJSON(List<GeoObject> features) {
		this.features = features;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<GeoObject> getFeatures() {
		return features;
	}
	public void setFeatures(List<GeoObject> features) {
		this.features = features;
	}
}
