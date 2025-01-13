def attach_row(ws, r1, r2):\n    es = []\n    for i, w in enumerate(ws):\n        eb = gtk.EventBox()\n        a = gtk.Alignment(xalign=0.0, yalign=0.5)\n        a.add(w)\n        eb.add(a)\n        eb.set_style(self.rowStyle.copy())\n        es.append(eb)\n        self.table.attach(eb, i, i + 1, r1, r2,\n                          xoptions=gtk.EXPAND | gtk.FILL,\n                          yoptions=gtk.SHRINK)\n\n    def ene(_, ev, es=es):\n        for eb in es:\n            eb.set_state(gtk.STATE_PRELIGHT)\n\n    def lne(_, ev, es=es):\n        for eb in es:\n            eb.set_state(gtk.STATE_NORMAL)\n\n    for eb in es:\n        eb.connect('enter-notify-event', ene)\n        eb.connect('leave-notify-event', lne)