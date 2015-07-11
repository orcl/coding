#!/usr/bin/python
#
#

from pkg_resources import require
require("Autos>=1.0")

import sys
egg_path='/Users/shipeng/Desktop/test/python_package/dist'
sys.path.append(egg_path)

from Autos import Audi

Audi.fart()
