1. create a folder,
2. inside this created folder, create a file called __init__.py
3. create python modules in this folder
4. outside this folder, we can simply refer to this folder.module.function
5. import foo.bar or from foo import bar


Pythone eggs --  a simple introduction
Python eggs used to be the wave of the future. But for zope and Plone developers this has evolved into a true trunami. they are everywhere now.
To understand them, you need to understand Pythons way of organizing code files.
  

Module 
the basic unit of code reusability in Python: a block of code imported by some other code.
It is most often a module written in Python and contained in a single .py file, also called a script.

hello.py

let us say this hello.py contains a function:

def helloworld():
print 'Hello World'

Then it is possible to import that function like this:

from hello import helloworld

Package
a module that contains other modules; typically contained in a directory in the filesystem and distinguished from other directories by the presence of a file __init__.py

you can then put the helloworld  function into the __init__.py script, and import it like you did before:

from hello import helloworld

you could also keep it in the hello.py file from before.

hello/
  __init__.py
  hello.py

but then you must import it like this:

from hello.hello import helloworld

unless you import it into the moudle namspace. you do this in the __init__.py script:
from hello import helloworld

then you will once again be able to write:
from hello import helloworld

this ensures you can reorganize your code and still remain backwards compatibility.
you can have modules inside modules, a python library is just a module, or a structure of modules.

a structure of modules is called a package.




How to create a python .egg file:

Setuptools
Setuptools is built on top of distutils. it makes it possible to save modules in pypi, or somewhere else.
it uses eggs for distribution.

eggs.

an egg is created very much like a distutil package. you just have to chagne a line in your setup.py

from setuptools import setup ##this is new

setup(name='hello',version='1.0',packages=['hello',],)

then you call it with 

python setup.py bdist_egg

and you get a new file in your dist directory:

dist/
hello-1.0-py2.4.egg

this is the egg that you can put on your website, or even better, publish to pypi. you can get an account on pypi, and then you will be able to add your eggs via command line like this: setup.py bdist_egg upload

Easy install
when you have uploaded your egg, all the world is able to use it by installing it with easy_install:

easy_install hello

Easy install will then find the egg on pypi, download it, compile if necessary and add it to your sys.path so that Python will find it.



to use the python .egg file you have just created, 

  before you attempting to import from any eggs, use a snippet of code like this:
  
  from pkg_reosources import require
  require("hello>=1.0")
  
  then import hello

  this will  search all sys.path directories for an egg named "hello" whose release version is 1.0 or higher, 
  and it will automatically add the newest machine version to sys.path for you, along with any eggs that the hello egg needs.

  an example for this, please see test3.py













