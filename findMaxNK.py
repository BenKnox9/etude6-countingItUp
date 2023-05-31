import math

"""
Python program used to find max K for N whilst still under the MAX 64 bit integer
"""


MAX = 9_223_372_036_854_775_807
n = MAX
k = 1

with open("NandKoutput.txt", "w") as file:
    while n > 0:
        k = 1
        while math.comb(n, k) <= MAX and n > k:
            file.write(f"{n} {k}\n")
            k += 1

        n = math.floor(n/2)


# while n > 0:
#     if binom(n, k) <= MAX:
#         print(n, " ", k)
#         n = math.floor(n/2)
#         k = 1
#     else:
#         k += 1
