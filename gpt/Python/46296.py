import subprocess\n\n   def call_perl_script(arg):\n       result = subprocess.run(\n           ['perl', 'my_perl_script.pl', str(arg)], \n           capture_output=True, text=True\n       )\n       print(result.stdout)\n\n   if __name__ == "__main__":\n       call_perl_script('Argument from Python')