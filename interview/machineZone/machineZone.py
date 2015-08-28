#!/usr/bin/python
#author: Shipeng Xu
#
import sys
import urllib2
import json
import datetime
import mysql.connector
import time
from sets import Set
import csv

class User:
  def __init__(self):
    print "initializing."

  def getUsers(self):
    response    = urllib2.urlopen("http://api.randomuser.me")
    html        = response.read()
    decoded_js  = json.loads(html)
    user1       = decoded_js['results'][0]["user"]
    username    = user1["username"]
    password    = user1["password"]
    registered  = user1["registered"]
    dob         = user1["dob"]
    phone       = user1["phone"]
    nationality = decoded_js["nationality"]
    email       = user1["email"]
    name        = user1["name"]["first"] + " " + user1["name"]["last"]
    gender      = user1["gender"]
    tmp_tuple   = (username, password, email, dob, name, nationality, gender, registered, phone)
    return tmp_tuple


def mysql_getUser(f_config,query):
  f_cnx = mysql.connector.connect(**f_config)
  f_cur = f_cnx.cursor(buffered=True)
  f_cur.execute(query)
  rows = f_cur.fetchall()
  f_cur.close()
  f_cnx.close()
  return rows


### outputFlag, pass 0 for both, 1 for js, 2 for csv
def getUserCountByCountryGender(f_config,outputFlag=0):
  sql_query = "select nationality, gender, count(*) from install_user group by nationality, gender;"
  result = mysql_getUser(f_config,sql_query)
  qname = "userCountByCountryGender"
  if outputFlag == 0:
    rowsToJson(result,qname)
    rowsToCSV(result,qname)
  elif outputFlag == 1:
    rowsToJson(result,qname)
  else:
    rowsToCSV(result,qname)
  return result

### outputFlag, pass 0 for both, 1 for js, 2 for csv
def get3UsersByTime(f_config,outputFlag=0):
  sql_query = "select * from install_user order by registered desc limit 3;"
  result    = mysql_getUser(f_config,sql_query)
  qname     = "3UsersByRegisterTime"
  if outputFlag == 0:
    rowsToJson(result,qname)
    rowsToCSV(result,qname)
  elif outputFlag == 1:
    rowsToJson(result,qname)
  else:
    rowsToCSV(result,qname)
  return result

def rowsToJson(rows,qname):
  rowarray_list = []
  for row in rows:
    tmp = ()
    if qname == 'userCountByCountryGender':
      tmp = (row[0],row[1],row[2])
    else:
      tmp = (row[0],row[1],row[2],row[3],row[4],row[5],row[6],row[7],row[8],row[9])
    rowarray_list.append(tmp)
  j = json.dumps(rowarray_list)
  rowarray_file = qname+'.js'
  f = open(rowarray_file, 'w')
  print>>f,j
  f.close()

def rowsToCSV(rows,qname):
  fp = open(qname+'.csv','w')
  myFile = csv.writer(fp)
  myFile.writerows(rows)
  fp.close()

def mysql_insert(f_config, query, values):
  f_cnx = mysql.connector.connect(**f_config)
  f_cur = f_cnx.cursor(buffered=True)
  try:
    f_cur.executemany(query,values)
    f_cnx.commit()
  except Exception, e:
    print e
    f_cnx.rollback()
  f_cur.close()
  f_cnx.close()

def main():
  userClient = User()
  uniq_username_set = Set([]) 
  user_list  = []
  while len(user_list) < 600:
    tmp_tuple = userClient.getUsers()
    if tmp_tuple[0] not in uniq_username_set:
      user_list.append(tmp_tuple)
      uniq_username_set.add(tmp_tuple[0])
    time.sleep(1.0/5.0)

  ###### time to insert ###########
  f_config1 = {
        'user'      : 'root',
        'password'  : 'password',
        'host'      : 'localhost',
        'database'  : 'MZ',
  }
  insert_sql = "insert into install_user (username, password, email, dob, name, nationality, gender, registered, phone) values (%s, %s, %s, %s, %s, %s, %s, %s, %s)"
  mysql_insert(f_config1, insert_sql, user_list)

  ### pass 1 for js file, pass 2 for csv file, don't specify if you want both
  #getUserCountByCountryGender(f_config1,2) for csv file
  getUserCountByCountryGender(f_config1)  #for both file formats
  get3UsersByTime(f_config1)


if __name__ == "__main__":
  main()


