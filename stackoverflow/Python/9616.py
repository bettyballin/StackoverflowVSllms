#!/usr/bin/env python\n#\n# Copyright 2001-2009 by Vinay Sajip. All Rights Reserved.\n#\n# Permission to use, copy, modify, and distribute this software and its\n# documentation for any purpose and without fee is hereby granted,\n# provided that the above copyright notice appear in all copies and that\n# both that copyright notice and this permission notice appear in\n# supporting documentation, and that the name of Vinay Sajip\n# not be used in advertising or publicity pertaining to distribution\n# of the software without specific, written prior permission.\n# VINAY SAJIP DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE, INCLUDING\n# ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL\n# VINAY SAJIP BE LIABLE FOR ANY SPECIAL, INDIRECT OR CONSEQUENTIAL DAMAGES OR\n# ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER\n# IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT\n# OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.\n#\n# This file is part of the standalone Python logging distribution. See\n# http://www.red-dove.com/python_logging.html\n#\n"""\nA test harness for the logging module. An example handler - DBHandler -\nwhich writes to an Python DB API 2.0 data source. You'll need to set this\nsource up before you run the test.\n\nCopyright (C) 2001-2009 Vinay Sajip. All Rights Reserved.\n"""\nimport sys, string, time, logging\n\nclass DBHandler(logging.Handler):\n    def __init__(self, dsn, uid='', pwd=''):\n        logging.Handler.__init__(self)\n        import mx.ODBC.Windows\n        self.dsn = dsn\n        self.uid = uid\n        self.pwd = pwd\n        self.conn = mx.ODBC.Windows.connect(self.dsn, self.uid, self.pwd)\n        self.SQL = """INSERT INTO Events (\n                        Created,\n                        RelativeCreated,\n                        Name,\n                        LogLevel,\n                        LevelText,\n                        Message,\n                        Filename,\n                        Pathname,\n                        Lineno,\n                        Milliseconds,\n                        Exception,\n                        Thread\n                   )\n                   VALUES (\n                        %(dbtime)s,\n                        %(relativeCreated)d,\n                        '%(name)s',\n                        %(levelno)d,\n                        '%(levelname)s',\n                        '%(message)s',\n                        '%(filename)s',\n                        '%(pathname)s',\n                        %(lineno)d,\n                        %(msecs)d,\n                        '%(exc_text)s',\n                        '%(thread)s'\n                   );\n                   """\n        self.cursor = self.conn.cursor()\n\n    def formatDBTime(self, record):\n        record.dbtime = time.strftime("#%m/%d/%Y#", time.localtime(record.created))\n\n    def emit(self, record):\n        try:\n            #use default formatting\n            self.format(record)\n            #now set the database time up\n            self.formatDBTime(record)\n            if record.exc_info:\n                record.exc_text = logging._defaultFormatter.formatException(record.exc_info)\n            else:\n                record.exc_text = ""\n            sql = self.SQL % record.__dict__\n            self.cursor.execute(sql)\n            self.conn.commit()\n        except:\n            import traceback\n            ei = sys.exc_info()\n            traceback.print_exception(ei[0], ei[1], ei[2], None, sys.stderr)\n            del ei\n\n    def close(self):\n        self.cursor.close()\n        self.conn.close()\n        logging.Handler.close(self)\n\ndh = DBHandler('Logging')\nlogger = logging.getLogger("")\nlogger.setLevel(logging.DEBUG)\nlogger.addHandler(dh)\nlogger.info("Jackdaws love my big %s of %s", "sphinx", "quartz")\nlogger.debug("Pack my %s with five dozen %s", "box", "liquor jugs")\ntry:\n    import math\n    math.exp(1000)\nexcept:\n    logger.exception("Problem with %s", "math.exp")