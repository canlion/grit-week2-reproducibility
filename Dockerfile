FROM amazoncorretto:21.0.10
LABEL authors="jws"

# 컨테이너 내부 작업 디렉토리 - 이후 명령어의 기준 경로
WORKDIR /spring-boot
# 로컬 JAR를 컨테이너 내부로 복사
COPY build/libs/reproducibility-*-SNAPSHOT.jar app.jar
# 컨테이너 생성 후 실행할 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]
