# Install Lighthouse if it's not already installed\nnpm install -g lighthouse\n\n# Run Lighthouse with network throttling\nlighthouse https://yourwebsite.com --throttling-method=simulate --throttling.rttMs=150 --throttling.throughputKbps=1600 --output html --output-path ./report.html