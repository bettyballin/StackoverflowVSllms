umdh -p:<pid> -f:baseline.txt  # Take baseline snapshot\n   # Run your application for a while\n   umdh -p:<pid> -f:snapshot.txt  # Take second snapshot\n   umdh snapshot.txt baseline.txt > leakreport.txt  # Compare the snapshots