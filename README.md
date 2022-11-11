# todo-front-api

#### 프로젝트 기간
- 2022.9.18 ~ 2022.10.30
   
개발환경 세팅
---
- Spring boot, thymeleaf, mybatis, mysql, spring security, aws ec2.  
   
참고
---
### spring boot ec2 배포
- https://bcp0109.tistory.com/356 

```   
빌드 파일 복사  
- $ scp ./build/libs/api-0.0.1-SNAPSHOT.jar {호스트 이름}:/home/ubuntu   
   
프로세스 백그라운드에서 실행   
- nohup java -jar todo-front-api-0.0.1-SNAPSHOT.jar & > /dev/null  
- & : 백그라운드에서 실행
- &gt; : 다른 파일에 출력
- /dev/null : 로그   
   
프로세스 종료   
- ps -ef | grep {keyword}로 PID 찾은 후 -> kill PID   
```
       
   
PROBLEMS & SOLVED
---
#### [problem - 1]   
- jar 파일을 ec2에 올리고 실행 시킨 뒤 터미널을 종료시키면 서버도 같이 종료되는 문제가 발생    
#### [solved - 1]   
- nohup 명령어를 사용해서 jar파일을 백그라운드에서 실행   
   
#### [problem - 2]   
- 스프링 시큐리티 적용 후 회원가입 폼에서 비동기 통신 시 인증이 안되는 문제 발생
#### [solved - 2]   
- 시큐리티 설정파일에서 허용 url에 ajax 통신 url 추가  
