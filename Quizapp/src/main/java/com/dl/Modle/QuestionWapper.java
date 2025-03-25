package com.dl.Modle;

import lombok.Data;

@Data
public class QuestionWapper {
	
	private int id;

	private String Question;
	
	private String Option1;
	
	private String Option2;
	
	private String Option3;

	public QuestionWapper(int id, String question, String option1, String option2, String option3) {
		super();
		this.id = id;
		Question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
	}

}
