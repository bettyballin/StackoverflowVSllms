# Example of setting up WPA2 encryption and MAC address filtering on a Linux-based router\nsudo iwconfig wlan0 mode managed\nsudo iwconfig wlan0 essid "YourNetworkName"\nsudo iwconfig wlan0 key "YourStrongPassword"\nsudo iwconfig wlan0 wpa_supplicant -B -Dwext -i wlan0 -c /etc/wpa_supplicant.conf