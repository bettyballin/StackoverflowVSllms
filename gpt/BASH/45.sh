#!/bin/bash\nifconfig -a | grep -Po 'HWaddr \K.*$' > /tmp/mac_address.txt