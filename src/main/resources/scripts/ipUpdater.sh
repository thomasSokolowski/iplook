#!/bin/bash
echo 'Getting ip....'
curl http://ipecho.net/plain > ip.txt
echo 'Putting onto ftp....'
wput ip.txt ftp://ipuser@iie.webd.pl:s1t2o3p4@ftp.iie.webd.pl
rm -rf ip.txt
echo 'Done!'




