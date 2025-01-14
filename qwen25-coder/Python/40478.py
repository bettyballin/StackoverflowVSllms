import configparser\nfrom ftp_handler import FtpHandler\nfrom database_handler import DatabaseHandler\nfrom data_processors.product_processor import ProductProcessor\n\nconfig = configparser.ConfigParser()\nconfig.read('config.ini')\n\nftp_handler = FtpHandler(config)\ndb_handler = DatabaseHandler(config)\n\n# Download and process a file\nfile_name = 'products.csv'\nftp_handler.download_file(file_name)\nproduct_data = ProductProcessor.process(file_name)\n\n# Save processed data to database\nfor product in product_data:\n    db_handler.insert_record('products', list(product.values()))\n\n# Reverse operation, get database content for output to FTP\noutput_products = db_handler.query_table('SELECT * from products')\nwrite_file(output_products)  # function to write records into a file\nftp_handler.upload_file('updated_products.csv')