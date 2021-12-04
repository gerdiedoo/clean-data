def stalinsort(lst):
    sortedlst = [lst[0]]
    for i in lst[1:]:
        if i >= sortedlst[-1]:
            sortedlst.append(i)
    return sortedlst

lst = [7, 5, 3, 1, 5, 9, 8, 4, 6, 2, 10]
print(stalinsort(lst))
