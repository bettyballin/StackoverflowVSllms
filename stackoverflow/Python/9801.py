lineIter= iter(aFile)\nfor aLine in lineIter:\n    if aLine.startswith("import"):\n        if aLine.endswith("("):\n            for aModule in lineIter:\n                if aModule.endwith(")"):\n                    break\n                print "import", aModule.strip()\n        else:\n            print aLine.stri()\n    else:\n        print aLine.strip()