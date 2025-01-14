import json\n\n# Example JSON data from the website\njson_data = '''\n[\n    {"channel": 1, "current_program": "Music Hits"},\n    {"channel": 2, "current_program": "News"},\n    {"channel": 3, "current_program": "Sports"},\n    {"channel": 5, "current_program": "Talk Show"}\n]\n'''\n\n# Parse the JSON data\nchannels = json.loads(json_data)\n\n# Convert the list of channels to a dictionary\nchannel_dict = {channel['channel']: channel['current_program'] for channel in channels}\n\n# Function to update the channel data\ndef update_channel(channel_number, new_program):\n    if channel_number in channel_dict:\n        channel_dict[channel_number] = new_program\n    else:\n        print(f"Channel {channel_number} does not exist.")\n\n# Function to display all channels and their current programs\ndef display_channels():\n    for channel, program in sorted(channel_dict.items()):\n        print(f"Channel {channel}: {program}")\n\n# Example usage\nupdate_channel(2, "Updated News")\ndisplay_channels()