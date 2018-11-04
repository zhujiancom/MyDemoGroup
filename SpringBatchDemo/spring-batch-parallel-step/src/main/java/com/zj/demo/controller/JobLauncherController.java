package com.zj.demo.controller;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creator: zhuji
 * Date: 2018/10/28
 * Time: 11:23
 * Description:
 */
@RestController
public class JobLauncherController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("partitionerJob")
    Job job;

    @RequestMapping("/launchjob")
    public BatchStatus handle() throws Exception{
        JobParameters jobParameters = new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters();
        JobExecution jobExecution = jobLauncher.run(job,jobParameters);
        return jobExecution.getStatus();
    }
}
