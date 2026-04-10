package assignment.week2.reproducibility.dependencyCheckRunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisCheckRunner implements ApplicationRunner {

    private final StringRedisTemplate redisTemplate;

    public RedisCheckRunner(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Redis 연결 확인");
        try {
            String key = "health:redis";
            redisTemplate.opsForValue().set(key, "ok");
            String value = redisTemplate.opsForValue().get(key);
            log.info("redis health check: redis key-value = {}-{}", key, value);
        } catch (RedisConnectionFailureException e) {
            log.error("Redis 연결 실패");
        }
    }
}
