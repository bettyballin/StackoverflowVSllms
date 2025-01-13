import numpy as np\n   from keras.models import Sequential\n   from keras.layers import LSTM, Dense\n\n   def prepare_data(sequences, unique_notes):\n       note_to_int = {note: number for number, note in enumerate(unique_notes)}\n       int_sequences = [[note_to_int[note] for note in sequence] for sequence in sequences]\n       X = []\n       y = []\n       for sequence in int_sequences:\n           for i in range(len(sequence) - 1):\n               X.append(sequence[:i+1])\n               y.append(sequence[i+1])\n       X = np.array(X)\n       y = np.array(y)\n       return X, y, note_to_int\n\n   def create_model(input_shape):\n       model = Sequential()\n       model.add(LSTM(128, input_shape=input_shape, return_sequences=True))\n       model.add(LSTM(128))\n       model.add(Dense(len(unique_notes), activation='softmax'))\n       model.compile(loss='sparse_categorical_crossentropy', optimizer='adam')\n       return model\n\n   sequences = [['C', 'E', 'G', 'C'], ['G', 'B', 'D', 'G']]\n   unique_notes = sorted(set(note for seq in sequences for note in seq))\n   X, y, note_to_int = prepare_data(sequences, unique_notes)\n   model = create_model((X.shape[1], X.shape[2]))\n   model.fit(X, y, epochs=100, batch_size=64)\n\n   def generate_sequence(model, start_note, length, note_to_int):\n       int_to_note = {number: note for note, number in note_to_int.items()}\n       current_sequence = [note_to_int[start_note]]\n       for _ in range(length - 1):\n           prediction = model.predict(np.array(current_sequence).reshape(1, len(current_sequence), 1))\n           next_note = np.argmax(prediction)\n           current_sequence.append(next_note)\n       generated_sequence = [int_to_note[note] for note in current_sequence]\n       return generated_sequence\n\n   generated_sequence = generate_sequence(model, 'C', 4, note_to_int)\n   print(generated_sequence)