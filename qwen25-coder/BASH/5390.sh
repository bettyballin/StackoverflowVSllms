dvc init\n   dvc add source_data.csv\n   git commit -m "Track raw dataset"\n   dvc run -d source_data.csv -o processed_data.csv \\n       "python process.py source_data.csv processed_data.csv"\n   git add processed_data.csv.dvc