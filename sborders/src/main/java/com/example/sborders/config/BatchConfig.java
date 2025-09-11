package com.example.sborders.config;

import java.util.logging.Logger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.sborders.entity.Orders;
import com.example.sborders.repository.OrdersRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private OrdersRepository orderRepository;

   
    
    Logger logger = Logger.getLogger("BatchConfig");

    // Item Reader
    @Bean
    public FlatFileItemReader<Orders> reader() {
        FlatFileItemReader<Orders> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("src/main/resources/static/Orders.csv"));
        reader.setName("csvReader");
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
        return reader;
    }

    private LineMapper<Orders> lineMapper() {
        DefaultLineMapper<Orders> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("id", "orderDate", "shipMode", "customerId", "sales");
        BeanWrapperFieldSetMapper<Orders> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Orders.class);
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

	@Bean
	OrderProcessor processor() {
		return new OrderProcessor();
	}
	
    // Item Writer
    @Bean
    public RepositoryItemWriter<Orders> writer() {
        RepositoryItemWriter<Orders> writer = new RepositoryItemWriter<>();
        writer.setRepository(orderRepository);
        writer.setMethodName("saveAll");
        return writer;
    }

    // Step
    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<Orders, Orders>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .faultTolerant()
                .skip(FlatFileParseException.class)
                .skipLimit(50)
                .build();
    }

    // Job
    @Bean
    public Job job() {
        return new JobBuilder("orderJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }
}