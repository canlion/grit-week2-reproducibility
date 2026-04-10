package assignment.week2.reproducibility.dependencyCheckRunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaCheckRunner implements ApplicationRunner {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaCheckRunner(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("kafka 연결 확인");
        try {
            kafkaTemplate.send("health-kafka", "ok").get();
            log.info("kafka health check: ok");
        } catch (KafkaException e) {
            log.error("kafka 연결 실패");
        }
    }
}
