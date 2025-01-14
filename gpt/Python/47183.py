import cv2\nimport numpy as np\n\ndef is_black_frame(frame, threshold=30):\n    return np.mean(frame) < threshold\n\ndef frame_difference(frame1, frame2):\n    return np.sum(cv2.absdiff(frame1, frame2))\n\ndef frame_quality(frame):\n    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)\n    sharpness = cv2.Laplacian(gray, cv2.CV_64F).var()\n    contrast = np.std(frame)\n    colorfulness = np.mean(np.std(frame, axis=(0, 1)))\n    return sharpness + contrast + colorfulness\n\ndef find_representative_frame(video_path):\n    cap = cv2.VideoCapture(video_path)\n    frames = []\n    ret, prev_frame = cap.read()\n    \n    while ret:\n        ret, frame = cap.read()\n        if not ret or is_black_frame(frame):\n            continue\n        if frame_difference(prev_frame, frame) > threshold:\n            frames.append(frame)\n        prev_frame = frame\n    \n    cap.release()\n\n    if not frames:\n        return None\n\n    best_frame = max(frames, key=frame_quality)\n    return best_frame\n\n# Example usage\nvideo_path = 'path_to_video.mp4'\nrepresentative_frame = find_representative_frame(video_path)\n\nif representative_frame is not None:\n    cv2.imwrite('thumbnail.jpg', representative_frame)