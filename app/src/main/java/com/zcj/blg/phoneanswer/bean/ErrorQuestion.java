package com.zcj.blg.phoneanswer.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ErrorQuestion implements Parcelable {
	
	public int questionId;
	public String questionName;
	public String questionType;
	public String questionAnswer;
	public String questionSelect;
	public String isRight;
	public String Analysis;
	public String optionA;
	public String optionB;
	public String optionC;
	public String optionD;
	public String optionE;
	public String optionType;

	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public String getQuestionSelect() {
		return questionSelect;
	}
	public void setQuestionSelect(String questionSelect) {
		this.questionSelect = questionSelect;
	}
	public String getIsRight() {
		return isRight;
	}
	public void setIsRight(String isRight) {
		this.isRight = isRight;
	}
	public String getAnalysis() {
		return Analysis;
	}
	public void setAnalysis(String analysis) {
		Analysis = analysis;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getOptionE() {
		return optionE;
	}
	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int arg1) {
		// TODO Auto-generated method stub
		dest.writeString(questionName);
		dest.writeString(questionType);
		dest.writeString(questionAnswer);
		dest.writeString(questionSelect);
		dest.writeString(isRight);
		dest.writeString(Analysis);
		dest.writeString(optionA);
		dest.writeString(optionB);
		dest.writeString(optionC);
		dest.writeString(optionD);
		dest.writeString(optionE);
		dest.writeString(optionType);
	}
	
	

}
