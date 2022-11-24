#!/bin/bash

mvn clean package

CLASSPATH=
for i in target/*.jar; do
    CLASSPATH=$CLASSPATH:$i
done
echo $CLASSPATH

#java -cp $CLASSPATH -Xms512m -Xmx2048m taifex.downloader.DwnRunner 2022 11 14
java -cp $CLASSPATH -Xms512m -Xmx2048m taifex.downloader.DwnRunner $(date +"%Y %m %d")

find target/Taifex -name '*.csv'| (while read file; do
cat $file | iconv -f BIG5-HKSCS -t utf-8 | sed 's/-/0/g' | sed 's#^\([0-9]\{4\}\)\/\([0-9]\{1,\}\)\/\([0-9]\{1,\}\)#\1-\2-\3#g' | sed 's/[[:blank:]]//g' > "$file.bq"
rm "$file"
echo "$file done"
done);

cp -r target/Twse/* ~/Documents/Twse-stream
cp -r target/Taifex/* ~/Documents/Taifex-stream

echo "moved to splunk folder"
#taifex date yyyy-mm-dd
#twse date yyyymmdd
