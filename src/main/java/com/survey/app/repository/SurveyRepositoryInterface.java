package com.survey.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.app.model.Survey;

public interface SurveyRepositoryInterface extends JpaRepository<Survey, Long> {

}
