
�������ɷ���


�ڶ���������
@echo off
set current_path="%cd%"
echo ��ǰ·�� = %current_path%
echo ��ʼ����war��%env%�����ļ���
md %current_path%\deploy\%env%\war
echo ��ʼmaven���
cd %current_path%\env-test
mvn clean install -P%env% -Dmaven.test.skip=true


�ڶ���������
@echo off
set current_path="%cd%"
echo maven package finished
echo ��ʼcopy��
copy %current_path%\target\env-test-0.0.1-SNAPSHOT.jar %current_path%\deploy\%env%\war\env-test-0.0.1-SNAPSHOT.jar
echo ��ʼ������Ŀ
cd %current_path%\deploy\%env%\war
start javaw -jar env-test-0.0.1-SNAPSHOT.jar
exit