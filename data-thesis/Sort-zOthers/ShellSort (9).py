
def ShellSort(list):
    n = len(list)
    gap = n//2
    while gap > 0:
        for i in range(gap, n):
            tmp = list[i]
            j = i
            while j >= gap and list[j-gap] > tmp:
                list[j] = list[j-gap]
                j = j - gap
            list[j] = tmp
        gap = gap//2



    