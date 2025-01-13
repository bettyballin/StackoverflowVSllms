import librosa\nfrom sklearn.neighbors import LocalOutlierFactor\n\n# Load audio file\naudio, sr = librosa.load('insect_sound.wav')\n\n# Extract features (e.g., Mel-frequency cepstral coefficients)\nfeatures = librosa.feature.mfcc(audio, sr=sr)\n\n# Train LOF model\nlof = LocalOutlierFactor(n_neighbors=20)\nlof.fit(features)\n\n# Evaluate on new data\nnew_audio, new_sr = librosa.load('new_audio.wav')\nnew_features = librosa.feature.mfcc(new_audio, sr=new_sr)\nanomaly_scores = lof.decision_function(new_features)