package gradle_spring_webmvc_study.dto;

public class OsCode {
	private String code;
	private String label;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public OsCode(String code, String label) {
		super();
		this.code = code;
		this.label = label;
	}

}
