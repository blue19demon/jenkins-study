@echo off
set current_path="%cd%"
echo µ±Ç°Â·¾¶ = %current_path%
start javaw -jar %current_path%\%project_name%\target\%project_name%-0.0.1-SNAPSHOT.jar
exit