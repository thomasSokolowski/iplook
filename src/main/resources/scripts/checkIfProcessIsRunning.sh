#!/bin/bash
process=$1
temp=$(ps aux | grep "$process")
process="$(echo $process | tr -d "[]")"
echo $process

if [ -n "$temp" ]
then
status=true
echo $status
curl --data "process=value1&status=value2" http://iplook-iie.rhcloud.com/rest/brands/readApplication/$process/$status   --header "Content-Type:application/json"
exit 1
else
status=false
curl --data "process=value1&status=value2" http://iplook-iie.rhcloud.com/rest/brands/readApplication/$process/$status   --header "Content-Type:application/json"

fi

