session_start();\nif($_SESSION['hasbeenhere'] == 1)\n{\n // Page refreshed\n}\nelse\n{\n   $_SESSION['hasbeenhere'] = 1;\n}