#!/usr/bin/env python\n   from mercurial import demandimport; demandimport.enable()\n   from mercurial.hgweb import hgwebdir\n   import os\n\n   config = os.path.join(os.path.dirname(__file__), 'hgweb.config')\n   application = hgwebdir(config)