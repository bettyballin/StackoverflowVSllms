@echo off\nset vbox_home=%programfiles%\Oracle\VirtualBox\nset image_name=MyLinux\n\n:: Install VirtualBox and the image\ncall install_script.bat\n\n:: Launch VirtualBox and configure the network\nstart %vbox_home%\VBoxManage.exe startvm %image_name%\ntimeout /t 10\nVBoxManage.exe guestcontrol %image_name% --username user123 --password pass123 run -- cmd /c "dhclient eth0"