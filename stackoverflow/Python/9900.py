import rsvg\nfrom gtk import gdk\nh = rsvg.Handle('svg-file.svg')\npixbuf = h.get_pixbuf()\npixbuf.save('foobar.png', 'png')