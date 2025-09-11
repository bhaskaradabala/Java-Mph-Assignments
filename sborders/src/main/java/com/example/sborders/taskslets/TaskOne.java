package com.example.sborders.taskslets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskOne implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("==> TaskOne Started");
		Thread.sleep(1000);
		System.out.println("==> TaskOne Completed");
		return RepeatStatus.FINISHED;
	}

}
