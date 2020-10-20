package gradle_spring_webmvc_study.survey;

import java.util.List;

public class AnsweredData {
	//설문 항목에 대한 답변 + 응답자 정보
	private List<String> responses;
	private Respondent res;

	public List<String> getResponses() {
		return responses;
	}

	public void setResponses(List<String> responses) {
		this.responses = responses;
	}

	public Respondent getRes() {
		return res;
	}

	public void setRes(Respondent res) {
		this.res = res;
	}

}
