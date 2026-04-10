# 애플리케이션 빌드 담당
FROM gradle:8.14.4-jdk21 AS builder
WORKDIR /spring-boot
COPY . .
# testcontainer 테스트가 내부에서 실행되지 않아 일단 테스트는 제외
RUN gradle build -x test

FROM amazoncorretto:21.0.10
LABEL authors="jws"

# 컨테이너 내부 작업 디렉토리 - 이후 명령어의 기준 경로
WORKDIR /spring-boot

## 로컬 JAR를 컨테이너 내부로 복사
#COPY build/libs/reproducibility-*-SNAPSHOT.jar app.jar

# builder가 생성한 jar를 복사
COPY --from=builder /spring-boot/build/libs/*.jar app.jar

# 컨테이너 생성 후 실행할 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]
