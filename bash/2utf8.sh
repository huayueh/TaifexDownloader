#!/bin/bash
find $1 -name '*.csv'| (while read file; do
cat $file | iconv -f BIG5-HKSCS -t utf-8 | sed 's/-/0/g' | sed 's#^\([0-9]\{4\}\)\/\([0-9]\{1,\}\)\/\([0-9]\{1,\}\)#\1-\2-\3#g' | sed 's/[[:blank:]]//g' > "$file.bq"
rm "$file"
echo "$file done"
done);
