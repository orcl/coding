#!/usr/bin/python
#
#
def plusOne(self, digits):
  carry = 1
  plus = []
  for x in range(len(digits)-1,-1,-1):
    total = carry + digits[x]
    temp = 0
    if total >= 10:
      temp = total - 10
      digits[x] = temp
      carry = 1
      if x == 0:
        plus.append(1)
        digits = plus + digits
    else:
      digits[x] = total
      carry = 0
  return digits


