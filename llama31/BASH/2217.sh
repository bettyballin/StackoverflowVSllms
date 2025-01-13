# Create a new device in Cacti\necho "Device: router1" >> /usr/share/cacti/resource/script_queries/router1_interface.xml\n\n# Define the SNMP query\necho "  <query>\n        <oid>1.3.6.1.2.1.2.2.1.10</oid>\n        <type>Interface In Octets</type>\n      </query>" >> /usr/share/cacti/resource/script_queries/router1_interface.xml\n\n# Add the device to Cacti's polling cycle\necho "*/5 * * * * /usr/bin/php /usr/share/cacti/poller.php" >> /etc/crontab