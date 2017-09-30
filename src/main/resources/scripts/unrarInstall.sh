#!/bin/bash

echo "deb-src http://mirrordirector.raspbian.org/raspbian/ wheezy main contrib non-free rpi" | sudo tee -a /etc/apt/sources.list
sudo apt-get update
sudo apt-get build-dep unrar-nonfree
sudo apt-get source -b unrar-nonfree
sudo dpkg -i unrar_4.1.4-1_armhf.deb