import os\nimport zipfile\n\ndef zip_folder(basedir):\n    # Create the zip file path within the basedir\n    zip_file = os.path.join(basedir, os.path.basename(basedir) + '.zip')\n    \n    z = zipfile.ZipFile(zip_file, 'w', zipfile.ZIP_DEFLATED)\n    for dirpath, dirnames, filenames in os.walk(basedir):\n        print("zipping files:")\n        for fn in filenames:\n            if fn != os.path.basename(zip_file):  # Avoid adding the zip file itself\n                print(fn)\n                absfn = os.path.join(dirpath, fn)\n                z.write(absfn)\n    z.close()\n\n# Example usage:\nbasedir = r'C:\test'\nzip_folder(basedir)