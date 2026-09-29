package in.tricks.curdSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication

public class CurdSpringBootDemoApplication {

	public static void main(String[] args) {

        SpringApplication.run(CurdSpringBootDemoApplication.class, args);
        System.out.println("HelloWord");
	}

}