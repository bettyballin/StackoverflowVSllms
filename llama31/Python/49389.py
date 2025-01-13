# utils.py\nimport logging\n\ndef log_message(message):\n    logging.info(message)\n\ndef get_database_connection():\n    # database connection code here\n\n# session.py\nfrom utils import log_message\n\nclass Session:\n    def __init__(self):\n        log_message("Session initialized")\n\n# logger.py\nimport logging\n\ndef configure_logger():\n    logging.basicConfig(level=logging.INFO)\n\n# database.py\nfrom utils import get_database_connection\n\nclass Database:\n    def __init__(self):\n        self.conn = get_database_connection()