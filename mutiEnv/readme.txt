
创建自由风格的


第二步构建：
@echo off
set current_path="%cd%"
echo 当前路径 = %current_path%
echo 开始创建war的%env%环境文件夹
md %current_path%\deploy\%env%\war
echo 开始maven打包
cd %current_path%\env-test
mvn clean install -P%env% -Dmaven.test.skip=true


第二步构建：
@echo off
set current_path="%cd%"
echo maven package finished
echo 开始copy包
copy %current_path%\target\env-test-0.0.1-SNAPSHOT.jar %current_path%\deploy\%env%\war\env-test-0.0.1-SNAPSHOT.jar
echo 开始发布项目
cd %current_path%\deploy\%env%\war
start javaw -jar env-test-0.0.1-SNAPSHOT.jar
exit