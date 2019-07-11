@echo off & title Kakafa

:main
call :startKakafa
goto :EOF


rem 启动Kakafa
:startKakafa
color 0a
call F:\softs\ELK\kafka_2.12-2.3.0\bin\windows\kafka-server-start.bat F:\softs\ELK\kafka_2.12-2.3.0\config\server.properties
echo 启动完成
echo 创建主题
call F:\softs\ELK\kafka_2.12-2.3.0\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic elkKafakaDev
call F:\softs\ELK\kafka_2.12-2.3.0\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic elkKafakaSit
call F:\softs\ELK\kafka_2.12-2.3.0\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic elkKafakaUat
call F:\softs\ELK\kafka_2.12-2.3.0\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic elkKafakaProd

pause;

