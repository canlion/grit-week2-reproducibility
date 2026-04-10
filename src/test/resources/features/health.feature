Feature: Health Check

  Scenario: 정상 상태의 시스템의 상태를 확인합니다.
    Given 시스템이 정상 동작합니다.
    When "/health" 엔드포인트로 GET 요청을 보냅니다.
    Then 응답의 상태코드는 200이며
    And 응답 본문은 "OK" 입니다.
