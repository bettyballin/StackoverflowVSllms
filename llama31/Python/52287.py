import mido\n\n# Open the default MIDI input port\ninport = mido.open_input()\n\n# Open the default MIDI output port\noutport = mido.open_output()\n\n# Define a function to process incoming MIDI messages\ndef process_message(msg):\n    # Analyze the message and generate a response\n    if msg.type == 'note_on':\n        # Play a sound or switch to a different instrument\n        outport.send(mido.Message('note_on', note=60, velocity=64))\n    elif msg.type == 'control_change':\n        # Adjust the lighting or other parameters\n        print(f"Control change: {msg.control} = {msg.value}")\n\n# Start listening to incoming MIDI messages\nfor msg in inport:\n    process_message(msg)