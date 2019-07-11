@echo off
set current_path="%cd%"
echo maven package finished
echo begin create %project_name% war's %env% environment Folder
md %current_path%\deploy\%env%\war
echo begin copy war
copy %current_path%\%project_name%\target\%project_name%-0.0.1-SNAPSHOT.jar %current_path%\deploy\%env%\war\%project_name%-0.0.1-SNAPSHOT.jar
echo begin deploy project
cd %current_path%\deploy\%env%\war
start javaw -jar %project_name%-0.0.1-SNAPSHOT.jar
exit