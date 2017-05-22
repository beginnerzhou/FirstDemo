@echo off
echo ------------------------------info------------------------------
echo install to local maven lib...
echo ----------------------------------------------------------------

call mvn clean package -DskipTests -Pprod

pause