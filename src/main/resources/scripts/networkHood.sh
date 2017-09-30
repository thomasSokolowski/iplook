#!/bin/bash
pattern=$1
replacement=$2
ips=$(sudo nmap -sn -oG -PR 192.168.1.0/24 |  grep "192.168.1.[0-9]*" | awk '{print $(NF-1),",",$NF,","}' | tr -d "()" | tr -d ' ')
echo $ips
if [[ $ips == *192.168.1.1* ]]; then
preFormatted=${ips/unknown/Netgear-TomatoUSB}
formatted=${preFormatted/$pattern/$replacement}
fi
postFormatted=$(echo $formatted |  awk '{gsub(/,$/,""); print}')
sth=$(echo $postFormatted | tr -d ' ')
curl  --data "ip=value1" http://iplook-iie.rhcloud.com/rest/brands/readHosts/$sth/   --header "Content-Type:application/json"

