#!/bin/bash
echo "....Begining to mount samba share [My Passport]...."
sudo mount -t cifs -o user=nas,password= //192.168.1.1/My_Passport/media /home/pi/PassportBase/
echo "....Loading done!"
echo "....Listing the content...."
ls -laht /home/pi/PassportBase/
echo "....Done...."
echo "....Starting miniDLNA...."
sudo service minidlna start
echo "....Done...."

