@echo off

:main
call :startLogstash
goto :EOF

rem Æô¶¯logstash
:startLogstash
@echo off
title logstash
color 0a
call F:\softs\ELK\logstash-7.2.0\bin\logstash.bat -f F:\softs\ELK\logstash-7.2.0\config\log4j_to_es_by_kafaka.conf

echo;
pause;
