# Start the perf tool\nperf stat -e cpu-clock firefox -new-tab about:blank\n\n# Open the about:addons page and enable the addon you want to measure\n\n# Run the addon's functionality (e.g., play a video, load a webpage)\n\n# Stop the perf tool\npkill -INT perf