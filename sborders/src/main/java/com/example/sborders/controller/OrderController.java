package com.example.sborders.controller;

import java.time.Duration;

import java.time.LocalDate;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @PostMapping("/import/orders")
    public void importCSVtoDBJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLocalDate("startDate", LocalDate.now())
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();

        try {
            JobExecution jobExecution = jobLauncher.run(job, jobParameters);
            System.out.println("Job Start Time: " + jobExecution.getStartTime());
            System.out.println("Job Status: " + jobExecution.getStatus());
            System.out.println("Job Exit Status: " + jobExecution.getExitStatus());
            System.out.println("Job End Time: " + jobExecution.getEndTime());

            Duration duration = Duration.between(jobExecution.getStartTime(), jobExecution.getEndTime());
            System.out.println("Duration: " + duration);
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.toSeconds();
            System.out.println("Time difference: " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds.");

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
                | JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
}
