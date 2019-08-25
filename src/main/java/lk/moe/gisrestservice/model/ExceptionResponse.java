package lk.moe.gisrestservice.model;


import java.util.Map;

public class ExceptionResponse {

	private Integer status;
	private String path;
	private String errorMessage;
	private String timeStamp;
	private String trace;

	public ExceptionResponse(int status, Map<String, Object> errorAttributes) {
		this.setStatus(status);
		this.setPath((String) errorAttributes.get("path"));
		this.setErrorMessage((String) errorAttributes.get("message"));
		this.setTimeStamp(errorAttributes.get("timestamp").toString());
		this.setTrace((String) errorAttributes.get("trace"));
	}

	public Integer getStatus() {
		return status;
	}

	private void setStatus(Integer status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	private void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	private void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTrace() {
		return trace;
	}

	private void setTrace(String trace) {
		this.trace = trace;
	}

	public String getPath() {
		return path;
	}

	private void setPath(String path) {
		this.path = path;
	}
}
