import winreg\nfrom ntsecuritycon import GENERIC_ALL, SE_GROUP_ENABLED\nfrom win32com.client import Dispatch\nfrom pywintypes import SID\nfrom win32security import *\n\ndef get_acl_from_reg_key(key_path):\n    with winreg.OpenKey(winreg.HKEY_LOCAL_MACHINE, key_path, 0, winreg.KEY_READ) as key:\n        binary_data, _ = winreg.QueryValueEx(key, "DefaultLaunchPermission")\n    return binary_data\n\ndef set_acl_to_reg_key(key_path, acl_binary_data):\n    with winreg.OpenKey(winreg.HKEY_LOCAL_MACHINE, key_path, 0, winreg.KEY_WRITE) as key:\n        winreg.SetValueEx(key, "DefaultLaunchPermission", 0, winreg.REG_BINARY, acl_binary_data)\n\ndef add_user_to_acl(acl_binary_data, username, access_mask=GENERIC_ALL):\n    sd = SECURITY_DESCRIPTOR()\n    InitializeSecurityDescriptor(sd, SECURITY_DESCRIPTOR_REVISION)\n    p_sd = ctypes.pointer(sd)\n    \n    dacl_size_used = ctypes.sizeof(ACL) + (2 * ctypes.sizeof(ACCESS_ALLOWED_ACE)) - 2\n    dacl = ACL()\n    InitializeAcl(ctypes.byref(dacl), dacl_size_used, ACL_REVISION)\n    \n    name, domain, _ = LookupAccountName(None, username)\n    sid = ConvertSidToStringSid(name)\n    \n    AddAccessAllowedAce(ctypes.byref(dacl), ACL_REVISION_DS,\n                        access_mask,\n                        ctypes.cast(name.lpSid, PSID))\n    \n    SetSecurityDescriptorDacl(p_sd, True, ctypes.byref(dacl), False)\n    \n    return sd.GetBinaryForm()\n\n# Usage\nkey_path = r"SOFTWARE\Microsoft\Ole"\ncurrent_acl_binary_data = get_acl_from_reg_key(key_path)\n\n# Add a new user with full permissions (GENERIC_ALL)\nmodified_acl_binary_data = add_user_to_acl(current_acl_binary_data, "MyCustomUsername")\n\nset_acl_to_reg_key(key_path, modified_acl_binary_data)