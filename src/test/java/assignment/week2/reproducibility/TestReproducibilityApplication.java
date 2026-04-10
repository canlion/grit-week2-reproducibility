package assignment.week2.reproducibility;

import org.springframework.boot.SpringApplication;

public class TestReproducibilityApplication {

	public static void main(String[] args) {
		SpringApplication.from(ReproducibilityApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
