package com.survey.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.survey.app.exception.ResourceNotFoundException;
import com.survey.app.interfaces.SurveyInterface;
import com.survey.app.model.Survey;
import com.survey.app.repository.SurveyRepositoryInterface;

@Service
public class SurveyService implements SurveyInterface{
	
	private SurveyRepositoryInterface surveyRepository;

	public SurveyService(SurveyRepositoryInterface surveyRepository) {
		super();
		this.surveyRepository = surveyRepository;
	}

	@Override
	public Survey saveSurvey(Survey survey) {
		return surveyRepository.save(survey);
	}

	@Override
	public List<Survey> getAllSurveys() {
		return surveyRepository.findAll();
	}

	@Override
	public Survey getSurveyById(long id) {
//		Optional<Survey> survey = surveyRepository.findById(id);
//		if(survey.isPresent())
//		{
//			return survey.get();
//		}
//		else
//		{
//			throw new ResourceNotFoundException("Survey", "Id", id);
//		}
		
		return surveyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey", "Id", id));
	}

}
