# ipython_module.py\nfrom IPython import get_ipython\n\ndef run_shell_command(command):\n    get_ipython().system(command)\n\ndef run_magic_command(magic_cmd):\n    get_ipython().run_line_magic(magic_cmd.split()[0], ' '.join(magic_cmd.split()[1:]))