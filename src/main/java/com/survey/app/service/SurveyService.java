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
        return surveyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Survey", "Id", id));
    }

    @Override
    public Survey updateSurvey(long id, Survey updatedSurvey) {
        Survey existingSurvey = surveyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Survey", "Id", id));

        existingSurvey.setFirstName(updatedSurvey.getFirstName());
        existingSurvey.setLastName(updatedSurvey.getLastName());
        existingSurvey.setAddress(updatedSurvey.getAddress());
        // Update other fields as needed

        return surveyRepository.save(existingSurvey);
    }

    @Override
    public void deleteSurvey(long id) {
        if (!surveyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Survey", "Id", id);
        }
        surveyRepository.deleteById(id);
    }
}
