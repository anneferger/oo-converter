#!/bin/bash

OFFICE_HOME=/usr/lib/libreoffice

sudo apt-get update
sudo apt-get install libreoffice
sudo ln -s ${OFFICE_HOME} /usr/lib/openoffice 
