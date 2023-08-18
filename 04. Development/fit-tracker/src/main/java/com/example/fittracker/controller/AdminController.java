package com.example.fittracker.controller;

import com.example.fittracker.model.Achievement;
import com.example.fittracker.model.Activity;
import com.example.fittracker.model.Challenge;
import com.example.fittracker.service.AchievementService;
import com.example.fittracker.service.ActivityService;
import com.example.fittracker.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private AchievementService achievementService;

    // activity
    @GetMapping("/activity")
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }
    @PostMapping("/activity")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity savedActivity = activityService.saveActivity(activity);
        return new ResponseEntity<>(savedActivity, HttpStatus.CREATED);
    }
    @GetMapping("/activity/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        Activity activity = activityService.getActivityById(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }
    @PutMapping("/activity/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity activityDetails) {
        Activity updatedActivity = activityService.updateActivity(id, activityDetails);
        return new ResponseEntity<>(updatedActivity, HttpStatus.OK);
    }
    @DeleteMapping("/activity/{id}")
    public ResponseEntity<HttpStatus> deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // challenge
    @GetMapping("/challenge")
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        List<Challenge> challenges = challengeService.getAllChallenges();
        return new ResponseEntity<>(challenges, HttpStatus.OK);
    }
    @PostMapping("/challenge")
    public ResponseEntity<Challenge> createChallenge(@RequestBody Challenge challenge) {
        Challenge savedChallenge = challengeService.saveChallenge(challenge);
        return new ResponseEntity<>(savedChallenge, HttpStatus.CREATED);
    }
    @GetMapping("/challenge/{id}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable Long id) {
        Challenge challenge = challengeService.getChallengeById(id);
        return new ResponseEntity<>(challenge, HttpStatus.OK);
    }
    @PutMapping("/challenge/{id}")
    public ResponseEntity<Challenge> updateChallenge(@PathVariable Long id, @RequestBody Challenge challengeDetails) {
        Challenge updatedChallenge = challengeService.updateChallenge(id, challengeDetails);
        return new ResponseEntity<>(updatedChallenge, HttpStatus.OK);
    }
    @DeleteMapping("/challenge/{id}")
    public ResponseEntity<HttpStatus> deleteChallenge(@PathVariable Long id) {
        challengeService.deleteChallenge(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // achievement

    @GetMapping("/achievement")
    public ResponseEntity<List<Achievement>> getAllAchievements() {
        List<Achievement> achievements = achievementService.getAllAchievements();
        return new ResponseEntity<>(achievements, HttpStatus.OK);
    }
    @PostMapping("/achievement")
    public ResponseEntity<Achievement> createAchievement(@RequestBody Achievement achievement) {
        Achievement savedAchievement = achievementService.saveAchievement(achievement);
        return new ResponseEntity<>(savedAchievement, HttpStatus.CREATED);
    }
    @GetMapping("/achievement/{id}")
    public ResponseEntity<Achievement> getAchievementById(@PathVariable Long id) {
        Achievement achievement = achievementService.getAchievementById(id);
        return new ResponseEntity<>(achievement, HttpStatus.OK);
    }
    @PutMapping("/achievement/{id}")
    public ResponseEntity<Achievement> updateAchievement(@PathVariable Long id, @RequestBody Achievement achievementDetails) {
        Achievement updatedAchievement = achievementService.updateAchievement(id, achievementDetails);
        return new ResponseEntity<>(updatedAchievement, HttpStatus.OK);
    }
    @DeleteMapping("/achievement/{id}")
    public ResponseEntity<HttpStatus> deleteAchievement(@PathVariable Long id) {
        achievementService.deleteAchievement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}