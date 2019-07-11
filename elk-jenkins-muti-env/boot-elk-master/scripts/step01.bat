@echo off

:main
call :startElasticsearch
goto :EOF

rem Æô¶¯elasticsearch
:startElasticsearch
@echo off
title elasticsearch
color 0a
call F:\softs\ELK\elasticsearch-7.2.0-windows-x86_64\elasticsearch-7.2.0\bin\elasticsearch.bat

echo;
pause;
