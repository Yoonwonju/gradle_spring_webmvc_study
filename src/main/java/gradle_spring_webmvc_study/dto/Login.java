package gradle_spring_webmvc_study.dto;

import java.util.List;

import org.aspectj.apache.bcel.classfile.Code;

public class Login {
	private String loginType;
	private String jobCode;
//	private Code code;
	private String tool;
//	private String favoriteOs;
//	private String osCode;

	private List<String> favoriteOs;
	private List<String> osCode;
	private List<String> strSubject;
	private List<Code> subject;

	
	public List<String> getStrSubject() {
		return strSubject;
	}

	public void setStrSubject(List<String> strSubject) {
		this.strSubject = strSubject;
	}


	public List<String> getOsCode() {
		return osCode;
	}

	public void setOsCode(List<String> osCode) {
		this.osCode = osCode;
	}

	public List<Code> getSubject() {
		return subject;
	}

	public void setSubject(List<Code> subject) {
		this.subject = subject;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public List<String> getFavoriteOs() {
		return favoriteOs;
	}

	public void setFavoriteOs(List<String> favoriteOs) {
		this.favoriteOs = favoriteOs;
	}

}
