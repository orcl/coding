#!/usr/bin/python
#
#

def check(rawstr):
  if rawstr == None:
    return True

  result = True
  stack1 = []
  for c in rawstr:
    if c != '[' and c != ']':
      continue

    if c == ']':
      if len(stack1) == 0:
        return False
      else:
        stack1.pop()

    if c == '[':
      stack1.insert(0,c)
  return result


def main():
  string1 = "...[].."
  print string1 + str(check(string1))

  string2 = "...[][][][].."
  print string2 + str(check(string2))

  string3 = "...][.."
  print string3 + str(check(string3))

  string4 = "...[[][]][]..."
  print string4 + str(check(string4))


if __name__ == "__main__":
  main()
