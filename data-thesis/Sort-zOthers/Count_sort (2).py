def countsort(lst):
    mx = max(lst)
    count = [0 for i in range(mx+1)]
    for j in range(0, len(count)):
        for i in range(0, len(lst)):
            if j == lst[i]:
                count[j] += 1
    for i in range(1, len(count)):
        count[i] += count[i-1]
    sorted = [0 for i in range(len(lst))]
    for i in lst:
        for j in range(len(count)):
            x = count[i]-1
            sorted[x] = i
    return sorted

lst = [7, 5, 3, 1, 5, 9, 8, 4, 6, 2, 10]
print(countsort(lst))