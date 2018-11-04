package com.zj.demo.batch.step;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Creator: zhuji
 * Date: 2018/10/28
 * Time: 10:53
 * Description:
 */
@Component
@StepScope
public class SimpleStep implements Tasklet {
    @Value("#{stepExecutionContext[fileName]}")
    private String filename;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(Thread.currentThread().getName()+" - fileName = "+filename);
        workload();
        System.out.println("Done");
        return RepeatStatus.FINISHED;
    }

    private void workload() throws Exception{
        Thread.sleep(5000);
    }
}
