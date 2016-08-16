进入maven项目文件夹，运行
mvn clean compile exec:java -Dexec.mainClass="com.main.Main" -Dexec.args="arg0 arg1 arg2"
完成了插入一条Customer的功能，并且打印出最新插入的那条信息。
其他功能由于时间关系并未完成，
数据库配置文件在src/main/resource下dbconfig.properties