# Clone the gecko-profiler repository\ngit clone https://github.com/mozilla/gecko-profiler.git\n\n# Build the gecko-profiler tool\ncd gecko-profiler\nmkdir build\ncd build\ncmake ..\nmake\n\n# Run the gecko-profiler tool\n./gecko-profiler -p firefox -t 10\n\n# Open the about:addons page and enable both addons you want to measure\n\n# Run the functionality of both addons (e.g., play a video, load a webpage)\n\n# Stop the gecko-profiler tool\npkill -INT gecko-profiler