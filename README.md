# todo-front-api
   
   
개발환경 세팅
---
Spring boot, thymeleaf, mybatis, mysql, spring security, aws ec2.  
   
참고
---
spring boot ec2 배포 : https://bcp0109.tistory.com/356  
빌드 파일 복사  
- $ scp ./build/libs/api-0.0.1-SNAPSHOT.jar {호스트 이름}:/home/ubuntu  
프로세스 백그라운드에서 실행   
- nohup java -jar todo-front-api-0.0.1-SNAPSHOT.jar & > /dev/null  
- & : 백그라운드에서 실행
- > : 다른 파일에 출력
- /dev/null : 로그 
프로세스 종료   
- ps -ef | grep {keyword}로 PID 찾은 후 -> kill PID
