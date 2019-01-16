package com.jumploo.cms.web.action;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.jessma.mvc.FormBean;

import com.jumploo.cms.bean.Question;
import com.jumploo.cms.mgmt.QA.GetAnswerMgmt;


public class GetAnswerAction extends BaseAction{

	String question;
	@FormBean
	public String execute() throws Exception {
		return null;
	}

	@FormBean
	public String getAnswer() throws Exception
	{
		runLog.debug("");
		Question qes=new Question();
		qes.setQuestion(question);
		List<Document> list=new ArrayList<>();
		list=new GetAnswerMgmt().action(qes, null);
		List<Object> l=new ArrayList<>();
		
		for(Document doc:list) {
			l.add(doc.toJson());
		}
				
		getResponse().setContentType("text/html;charset=UTF-8");
		getResponse().getWriter().print(l);
		
		runLog.debug("end");
		return NONE;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


}






