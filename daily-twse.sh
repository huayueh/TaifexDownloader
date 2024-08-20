#!/bin/bash

mvn clean package

CLASSPATH=
for i in target/*.jar; do
    CLASSPATH=$CLASSPATH:$i
done
echo $CLASSPATH

#java -cp $CLASSPATH -Xms512m -Xmx2048m taifex.downloader.DwnRunner 2022 11 25
java -cp $CLASSPATH -Xms512m -Xmx2048m taifex.downloader.TwseRunner $(date +"%Y %m %d")

cp -r target/Twse/* ~/Documents/Twse-stream

echo "moved TWSE data to splunk folder"
#taifex date yyyy-mm-dd
#twse date yyyymmdd
