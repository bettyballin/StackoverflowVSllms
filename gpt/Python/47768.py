import pyaudio\nimport numpy as np\nimport matplotlib.pyplot as plt\n\n# Set parameters\nchunk = 1024  # Number of samples per buffer\nformat = pyaudio.paInt16  # 16-bit resolution\nchannels = 1  # Mono audio\nrate = 44100  # Sample rate\nrecord_seconds = 5  # Duration of recording\n\n# Initialize PyAudio\np = pyaudio.PyAudio()\n\n# Open stream\nstream = p.open(format=format,\n                channels=channels,\n                rate=rate,\n                input=True,\n                frames_per_buffer=chunk)\n\nprint("Recording...")\n\n# Record audio\nframes = []\nfor _ in range(0, int(rate / chunk * record_seconds)):\n    data = stream.read(chunk)\n    frames.append(data)\n\nprint("Finished recording.")\n\n# Stop and close the stream \nstream.stop_stream()\nstream.close()\np.terminate()\n\n# Convert audio data to numpy array\naudio_data = np.frombuffer(b''.join(frames), dtype=np.int16)\n\n# Perform FFT\nfft_data = np.fft.fft(audio_data)\nfrequencies = np.fft.fftfreq(len(fft_data), 1/rate)\nmagnitude = np.abs(fft_data)\n\n# Plot the frequency spectrum\nplt.figure(figsize=(10, 6))\nplt.plot(frequencies[:len(frequencies)//2], magnitude[:len(magnitude)//2])  # Plot only the positive frequencies\nplt.title("Frequency Spectrum")\nplt.xlabel("Frequency (Hz)")\nplt.ylabel("Magnitude")\nplt.show()