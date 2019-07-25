package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.TimeZone;

@SpringBootApplication
public class PalTrackerApplication {

   /* @Bean
    public TimeEntryRepository timeEntryRepository() {

        return new InMemoryTimeEntryRepository();
    }*/


    @Bean
    public TimeEntryRepository  entryRepository(DataSource dataSource){
        return new JdbcTimeEntryRepository(dataSource);
    }
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(PalTrackerApplication.class, args);
    }
}