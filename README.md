# week2-reproducibility

Spring Boot 애플리케이션을 `bootJar`로 빌드한 뒤, Docker 이미지 생성 및 `docker compose`로 전체 환경(App, MySQL, Kafka, Redis)을 실행합니다.

---

## 실행 환경

- Java 21
- Gradle
- Docker
- Docker Compose

## 실행 순서

### jar 생성
```shell
./gradlew bootJar
```
### build
```shell
docker build -t week2-reproducibility-app:1.0 .
```
### 실행
```shell
docker compose up -d
```

## 동작 확인
```shell
curl localhost:8080/health
```

### 응답
```shell
OK
```

## 종료
```shell
docker compose down
```
