import zipfile\nfrom django.http import HttpResponse\n\n# ...\n\nfiles = torrent[0].files\nzip_buffer = io.BytesIO()\nwith zipfile.ZipFile(zip_buffer, 'w') as zip_file:\n    for f in files:\n        zip_file.write(settings.PYRAT_TRANSMISSION_DOWNLOAD_DIR + "/" + f.name, f.name)\n\nzip_buffer.seek(0)\nresponse = HttpResponse(zip_buffer.getvalue(), content_type='application/zip')\nresponse['Content-Disposition'] = f'attachment; filename="{torrent_name}.zip"'\nreturn response