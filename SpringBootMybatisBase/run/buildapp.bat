rem buildapp.bat
call pathinfo.bat
cd ..
call gradle clean
call gradle build
pause
