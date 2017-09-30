#!/bin/bash
echo 'Getting ip....'
ip=$(curl http://dynupdate.no-ip.com/ip.php)
echo $ip
curl --data "ip=value1" http://iplook-iie.rhcloud.com/rest/brands/readIp/$ip/   --header "Content-Type:application/json"

echo ' done!'



