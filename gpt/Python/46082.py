import winreg\nimport requests\nimport execjs\n\ndef get_proxy_settings():\n    # Access the registry to get Internet Settings\n    internet_settings = r"Software\Microsoft\Windows\CurrentVersion\Internet Settings"\n    with winreg.OpenKey(winreg.HKEY_CURRENT_USER, internet_settings) as key:\n        proxy_enable = winreg.QueryValueEx(key, "ProxyEnable")[0]\n        proxy_server = winreg.QueryValueEx(key, "ProxyServer")[0] if proxy_enable else None\n        auto_config_url = winreg.QueryValueEx(key, "AutoConfigURL")[0] if proxy_enable else None\n\n    return proxy_enable, proxy_server, auto_config_url\n\ndef fetch_pac_file(auto_config_url):\n    response = requests.get(auto_config_url)\n    response.raise_for_status()\n    return response.text\n\ndef find_proxy_for_url(pac_script, url, host):\n    ctx = execjs.compile(pac_script)\n    return ctx.call("FindProxyForURL", url, host)\n\ndef main():\n    proxy_enable, proxy_server, auto_config_url = get_proxy_settings()\n    \n    if proxy_enable and proxy_server:\n        print(f"Proxy Server: {proxy_server}")\n    elif proxy_enable and auto_config_url:\n        print(f"Auto Config URL: {auto_config_url}")\n        pac_script = fetch_pac_file(auto_config_url)\n        # Example URL and host, you need to replace these with the actual values you need to test\n        url = "http://example.com"\n        host = "example.com"\n        proxy = find_proxy_for_url(pac_script, url, host)\n        print(f"Proxy for {url}: {proxy}")\n    else:\n        print("No proxy settings found")\n\nif __name__ == "__main__":\n    main()