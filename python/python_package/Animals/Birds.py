#!/usr/bin/python
#
#

class Birds:
  def __init__(self):
    '''Constructor for this class '''
    #create some member animals
    self.members = ['Sparrow', 'Robin', 'Duck']

  def printMembers(self):
    print('printing members of the Birds class')
    for member in self.members:
      print('\t%s ' % member)


