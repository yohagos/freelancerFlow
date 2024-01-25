package com.freelancer.flow.configs;

import com.freelancer.flow.entities.*;
import com.freelancer.flow.repositories.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RunnerData {

    private final static Logger log = LoggerFactory.getLogger(RunnerData.class);

    @Bean
    CommandLineRunner commandLineRunner(
            RecruiterRepository recruiterRepository,
            ProjectRepository projectRepository,
            ClientRepository clientRepository,
            ContractRepository contractRepository,
            WorkLogRepository workLogRepository
    ) {
        return args -> {
            var recruiterOne = new RecruiterEntity(
                    1L,
                    "recruiting",
                    "Stefan Weber",
                    "stefan@mail.com",
                    "1111111111",
                    "recruiting.de");
            var recruiterTwo = new RecruiterEntity(2L,
                    "NewPath",
                    "Michael Saint",
                    "michael@mail.com",
                    "2222222222",
                    "new-path.de");
            var recruiterThree = new RecruiterEntity(
                    3L,
                    "Futuristic",
                    "Nick Johnson",
                    "nick@mail.com",
                    "3333333333",
                    "futuristic.de");

            var clientOne = new ClientEntity(
                    1L,
                    "BMW",
                    "James Jameson",
                    "james@bmw.com",
                    "bmw.com",
                    "11111111111");
            var clientTwo = new ClientEntity(
                    2L,
                    "Porsche",
                    "James Wild",
                    "james@porsche.com",
                    "porsche.com",
                    "22222222222");
            var clientThree = new ClientEntity(
                    3L,
                    "Ferrari",
                    "James Einstein",
                    "james@ferarri.com",
                    "ferarri.com",
                    "33333333333");


            var projectOne = new ProjectEntity(
                    1L,
                    clientTwo,
                    recruiterOne,
                    "bwa - Aangular",
                    LocalDateTime.now(),
                    LocalDateTime.now());
            var projectTwo = new ProjectEntity(
                    2L,
                    clientTwo,
                    recruiterOne,
                    "bwa - Aangular",
                    LocalDateTime.now(),
                    LocalDateTime.now());
            var projectThree = new ProjectEntity(
                    3L,
                    clientTwo,
                    recruiterOne,
                    "bwa - Aangular",
                    LocalDateTime.now(),
                    LocalDateTime.now());


            var workLogOne = new WorkLogEntity(
                    1L,
                    projectOne,
                    LocalDateTime.now(),
                    40D,
                    true
            );
            var workLogTwo = new WorkLogEntity(
                    2L,
                    projectTwo,
                    LocalDateTime.now(),
                    40D,
                    true
            );
            var workLogThree = new WorkLogEntity(
                    3L,
                    projectOne,
                    LocalDateTime.now(),
                    60D,
                    true
            );


            var contractOne = new ContractEntity(
                    1L,
                    projectThree,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    40D,
                    30D
            );
            var contractTwo = new ContractEntity(
                    2L,
                    projectTwo,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    70D,
                    10D
            );
            var contractThree = new ContractEntity(
                    3L,
                    projectOne,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    140D,
                    30.5D
            );

            recruiterRepository.saveAll(
                    List.of(recruiterOne, recruiterTwo, recruiterThree)
            );

            clientRepository.saveAll(
                    List.of(clientOne, clientTwo, clientThree)
            );

            projectRepository.saveAll(
                    List.of(projectOne, projectTwo, projectThree)
            );

            contractRepository.saveAll(
                    List.of(contractOne, contractTwo, contractThree)
            );

            workLogRepository.saveAll(
                    List.of(workLogOne, workLogTwo, workLogThree)
            );

            log.info(recruiterRepository.findAll().toString());
            log.info(clientRepository.findAll().toString());
            log.info(projectRepository.findAll().toString());
            log.info(contractRepository.findAll().toString());
            log.info(workLogRepository.findAll().toString());
        };
    }
}
