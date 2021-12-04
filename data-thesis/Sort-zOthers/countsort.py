def countsort(l:list):
    arr = l[::]
    k = 0
    new_list = (max(arr) + 1) * [0]
    for j in arr:
        new_list[j] += 1
    for i in range(max(arr) + 1):
        if i != 0:
            new_list[i] += new_list[i - 1]
        while new_list[i] != k:
            arr[k] = i;
            k += 1
    return arr
