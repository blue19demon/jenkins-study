@echo off

:main
curl http://root:123456@127.0.0.1:8080/job/jenkinsTest/build?token=HELLO-TOKEN
goto :EOF

