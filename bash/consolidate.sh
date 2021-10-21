#!/bin/bash
find $1 -name '*.csv'| (while read file; do
cat $file >> $2
echo "$file done"
done);

