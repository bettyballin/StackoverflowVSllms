#!/bin/sh\n\nEMAIL=(\n  -e 's/SOME THING//g'\n  -e 's/SOME THING ELSE//g'\n)\n\nsomecommand | sed "${EMAIL[@]}"