import pyaudio\nimport numpy as np\nimport matplotlib.pyplot as plt\n\n# Constants\nFORMAT = pyaudio.paInt16  # Audio format\nCHANNELS = 1              # Mono audio\nRATE = 44100              # Samples per second\nCHUNK = 1024              # Frames per buffer\nRECORD_SECONDS = 5        # Duration to record\n\n# Initialize PyAudio\np = pyaudio.PyAudio()\n\n# Open stream for reading from microphone\nstream = p.open(format=FORMAT,\n                channels=CHANNELS,\n                rate=RATE,\n                input=True,\n                frames_per_buffer=CHUNK)\n\nprint("* recording")\n\n# Record data (frames) and perform FFT\nfor _ in range(int(RATE / CHUNK * RECORD_SECONDS)):\n    # Read audio stream as raw bytes\n    data = np.frombuffer(stream.read(CHUNK), dtype=np.int16)\n    \n    # Perform FFT and only keep first half of the result due to symmetry\n    fft_values = np.fft.fft(data)[:CHUNK // 2]\n    freqs = np.fft.fftfreq(len(fft_values), 1/RATE)[:CHUNK // 2]  # Corresponding frequencies\n    \n    # Plotting the magnitudes of the FFT values\n    plt.plot(freqs, np.abs(fft_values))\n    plt.title('FFT')\n    plt.xlabel('Frequency (Hz)')\n    plt.ylabel('Magnitude')\n    plt.show()  # This will block until the plot is closed; consider using plt.pause() for non-blocking\n\nprint("* done recording")\nstream.stop_stream()\nstream.close()\np.terminate()