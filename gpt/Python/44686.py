def add_user_to_dacl(username):\n       account_sid, _, _ = win32security.LookupAccountName(None, username)\n       new_ace = (win32security.ACCESS_ALLOWED_ACE_TYPE, 0, win32security.GENERIC_ALL, account_sid)\n\n       dacl.AddAccessAllowedAce(dacl.GetAclRevision(), win32security.GENERIC_ALL, account_sid)\n       sd.SetSecurityDescriptorDacl(1, dacl, 0)\n\n       return sd\n\n   new_username = "MyCustomUsername"\n   sd = add_user_to_dacl(new_username)\n\n   new_value = sd.GetSecurityDescriptorBinaryForm()\n\n   try:\n       reg_key = winreg.OpenKey(winreg.HKEY_LOCAL_MACHINE, key_path, 0, winreg.KEY_SET_VALUE)\n       winreg.SetValueEx(reg_key, value_name, 0, winreg.REG_BINARY, new_value)\n       winreg.CloseKey(reg_key)\n       print(f"User {new_username} added successfully.")\n   except Exception as e:\n       print(f"Failed to update registry: {e}")