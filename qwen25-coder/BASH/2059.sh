#!/bin/sh\nEMAIL="-e 's/SOME THING//g' -e 's/SOME THING ELSE//g'"\n\nsomecommand | sed $EMAIL