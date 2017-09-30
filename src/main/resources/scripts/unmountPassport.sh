#!/bin/bash
echo "Unmounting....."
sudo umount -f /home/pi/PassportBase

echo "......Done!"
echo "Stopping minidlna......"
sudo service minidlna stop
echo "......Done!"
