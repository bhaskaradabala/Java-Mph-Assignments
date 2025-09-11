package com.example.sborders.taskslets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskTwo implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("==> TaskTwo Started");
		Thread.sleep(1000);
		System.out.println("==> TaskTwo Completed");
		return RepeatStatus.FINISHED;
	}

}