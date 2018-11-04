package com.zj.demo.batch.partitioner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Creator: zhuji
 * Date: 11/4/2018
 * Time: 11:51 AM
 * Description:
 */
public class SpringbatchPartitionerApp {
    public static void main(String[] args) {
        // Spring Java config
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringbatchPartitionConfig.class);
        context.refresh();

        final JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        final Job job = (Job) context.getBean("partitionerJob");
        System.out.println("Starting the batch job");
        try {
            final JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Status : " + execution.getStatus());
            System.out.println("Job succeeded");
        } catch (final Exception e) {
            e.printStackTrace();
            System.out.println("Job failed");
        }
    }
}
