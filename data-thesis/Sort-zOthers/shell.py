def shell(l:list):
    arr = l[::]
    n = 0
    while (n < len(arr) // 3):
        n = n * 3 + 1
    while (n > 0):
        for i in range(int(n), len(arr)):
            tmp = arr[i]
            j = i
            while j >= n and arr[j - n] > tmp:
                arr[j] = arr[j-n]
                j -= n
                arr[j] = tmp
        n = (n - 1) // 3
    return arr
