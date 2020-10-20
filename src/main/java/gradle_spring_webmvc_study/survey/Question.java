package gradle_spring_webmvc_study.survey;

import java.util.List;

public class Question {
	/**
	title : 질문제목
	options : 답변보기 옵션
	 */
	private String title;
	private List<String> options;

	/** 객관식
	@param title 질문제목
	@param options 답변보기
	*/
	public Question(String title, List<String> options) {
		super();
		this.title = title;
		this.options = options;
	}

	/** 주관식
	@param title 질문제목
	*/
	public Question(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	/* 객관식 판단 */
	public boolean isChoice() {
		return options!=null && !options.isEmpty();
		}

}
