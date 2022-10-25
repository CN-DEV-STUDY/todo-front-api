# todo-front-api
   
   
개발환경 세팅
---
Spring boot, thymeleaf, mybatis, mysql, spring security, aws ec2.  
   
참고
---
spring boot ec2 배포 : https://bcp0109.tistory.com/356  
빌드 파일 복사  
   $ scp ./build/libs/api-0.0.1-SNAPSHOT.jar {호스트 이름}:/home/ubuntu  
프로세스 백그라운드에서 실행   
   nohup java -jar todo-front-api-0.0.1-SNAPSHOT.jar & > /dev/null
