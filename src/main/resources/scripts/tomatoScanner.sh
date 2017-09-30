#!/bin/bash
transmission=$(sudo nmap -p 9091 192.168.1.1)
process=TransmissionGUI
echo $transmission
if [[ $transmission == *open* ]]; then
echo open!
status=true
curl --data "process=value1&status=value2" http://iplook-iie.rhcloud.com/rest/brands/readApplication/$process/$status   --header "Content-Type:application/json"
else

echo  testing!
status=false
curl --data "process=value1&status=value2" http://iplook-iie.rhcloud.com/rest/brands/readApplication/$process/$status   --header "Content-Type:application/json"
fi

