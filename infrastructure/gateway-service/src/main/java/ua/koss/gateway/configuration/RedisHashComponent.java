package ua.koss.gateway.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
@Slf4j
@Component
public class RedisHashComponent {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisHashComponent(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void hSet(String key, Object hashKey, @NotNull Object val) {
        Map ruleHash = ObjectMapperUtils.objectMapper(val, Map.class);
        redisTemplate.opsForHash().put(key, hashKey, ruleHash);
    }

    public List<Object> hVals(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    public Object hGet(String key, Object hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }
}

