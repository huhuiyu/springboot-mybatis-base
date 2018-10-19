set PATH=F:\MyDevelop\jdk8\bin;%PATH%
set PATH=F:\MyDevelop\gradle-4.10.2\bin;%PATH%
set JAVA_HOME=F:\MyDevelop\jdk8
set GRADLE_HOME=F:\MyDevelop\gradle-4.10.2
set GRADLE_USER_HOME=F:\MyDevelop\gradle-user-home
cd ../
call gradle clean
call gradle build
pause