package com.survey.app.interfaces;

import java.util.List;
import com.survey.app.model.Survey;

public interface SurveyInterface {
    Survey saveSurvey(Survey survey);
    List<Survey> getAllSurveys();
    Survey getSurveyById(long id);
    void deleteSurvey(long id);
    Survey updateSurvey(long id, Survey updatedSurvey); // Add this method declaration for updating surveys
}
