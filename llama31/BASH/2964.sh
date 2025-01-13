# Create a new udev rule file\nsudo nano /etc/udev/rules.d/99-my-usb-rule.rules\n\n# Add the following rule to the file\nACTION=="add", SUBSYSTEM=="block", KERNEL=="sd[a-z]", ATTRS{idVendor}=="<vendor_id>", ATTRS{idProduct}=="<product_id>", ENV{MY_DEVICE_PROPERTY}="true"\n\n# Replace <vendor_id> and <product_id> with the actual values for your device