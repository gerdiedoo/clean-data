def get_digit(num, i):
    """Return the (i)th index of num"""
    return (num // 10**i) % 10

def max_digits(arr):
    """Return the length of the longest element in array"""
    return len(str(max(arr)))

def radix_sort(l:list):
    """Sort an array of positive integers"""
    arr = l[::]
    max_len = max_digits(arr)
    for i in range(max_len):
        res = [[] for x in range(10)]
        for k in arr:
            digit = get_digit(k, i)
            res[digit].append(k)
        arr = [y for x in res for y in x]
    return arr
