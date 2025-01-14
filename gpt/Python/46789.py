def hex_to_bin(hex_val):\n    bin_val = bin(int(hex_val, 16))[2:].zfill(8)\n    return bin_val\n\ndef interpret_status(hex_val):\n    bin_val = hex_to_bin(hex_val)\n    status = {\n        "Incoming call": bin_val[0] == '1',\n        "Outgoing call": bin_val[1] == '1',\n        "Internal call": bin_val[2] == '1',\n        "CN call": bin_val[3] == '1',\n        "Transferred call": bin_val[4] == '1',\n        "CN-transferred call": bin_val[5] == '1'\n    }\n    return status\n\nhex_val = 'A2'\nstatus = interpret_status(hex_val)\nprint(f"Hex value: {hex_val}")\nprint("Status interpretation:", status)