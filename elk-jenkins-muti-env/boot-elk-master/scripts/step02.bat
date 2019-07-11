@echo off

:main
call :startKibana
goto :EOF

rem Æô¶¯kibana
:startKibana
@echo off
title kibana
color 0a
call F:\softs\ELK\kibana-7.2.0-windows-x86_64\bin\kibana.bat

echo;
pause;
