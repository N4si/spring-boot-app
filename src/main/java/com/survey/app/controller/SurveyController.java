package com.survey.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.app.interfaces.SurveyInterface;
import com.survey.app.model.Survey;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class SurveyController {
	
	private SurveyInterface surveyService;

	public SurveyController(SurveyInterface surveyInterface) {
		super();
		this.surveyService = surveyInterface;
	}
	
	@PostMapping("/")
	public ResponseEntity<Survey> saveSurvey(@RequestBody Survey survey) {
		return new ResponseEntity<Survey>(surveyService.saveSurvey(survey), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public List<Survey> getAllSurveys(){
		return surveyService.getAllSurveys();
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Survey> getSurveyById(@PathVariable("id") long id){
		return new ResponseEntity<Survey>(surveyService.getSurveyById(id), HttpStatus.OK);
	
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable("id") long id) {
        surveyService.deleteSurvey(id);
        return new ResponseEntity<>("Survey with ID " + id + " has been deleted", HttpStatus.OK);
    }
}
 