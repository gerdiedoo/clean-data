def shaker(l:list):
    arr = l[::]
    sort = True
    start = 0
    end = len(arr)
    while (sort):
        sort = False
        for i in range(start, end):
            if arr[i] < arr[i - 1]:
                arr[i], arr[i - 1] = arr[i-1], arr[i]
            sort = True
        if not sort:
            break
        for j in range(end - 1, start, -1):
            if arr[j] < arr[j - 1]:
                arr[j], arr[j - 1] = arr[j - 1], arr[j]
            sort = True
        start += 1
        end -= 1
    return arr
