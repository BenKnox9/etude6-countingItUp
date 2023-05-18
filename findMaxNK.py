import math

"""
Python program used to find max K for N whilst still under the MAX 64 bit integer
"""


MAX = 9_223_372_036_854_775_807
n = MAX
k = 1

def binom(n, k):
    return math.comb(n, k)

while n > 0:
    if binom(n, k) >= MAX:
        print(n, " ", k)
        n = math.floor(n/2)
        k = 1
    else:
        k += 1