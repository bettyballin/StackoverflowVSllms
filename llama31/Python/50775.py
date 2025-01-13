import cv2\nimport numpy as np\n\n# Load video frames\nframes = []\nfor i in range(30):\n    frame = cv2.imread(f"frame_{i}.jpg")\n    frames.append(frame)\n\n# Calculate frame differences\ndiffs = []\nfor i in range(1, len(frames)):\n    prev_frame = frames[i-1]\n    curr_frame = frames[i]\n    diff = cv2.absdiff(prev_frame, curr_frame)\n    diffs.append(np.mean(diff))\n\n# Choose the frame with the highest difference\nmax_diff_idx = np.argmax(diffs)\nthumbnail_frame = frames[max_diff_idx]