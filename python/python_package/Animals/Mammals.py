#!/usr/bin/python
#
#

class Mammals:
  def __init__(self):
    '''constructor for this class . '''
    #create some member animals
    self.members = ['Tiger','Elephant','Wild Cats']

  def printMembers(self):
    print('Printing members of the Mammals class')
    for member in self.members:
      print('\t%s'%member)


