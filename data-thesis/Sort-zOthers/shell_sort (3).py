# author: alex o

def shell_sort(arr):
    # Marcin Ciura's gap sequence
    gaps = [701, 301, 132, 57, 23, 10, 4, 1]

    for gap in gaps:
        if gap < len(arr):
            for i in range(gap, len(arr)):
                temp = arr[i]

                j = i
                while j >= gap and arr[j-gap] > temp:
                    arr[j] = arr[j-gap]
                    j -= gap
                
                arr[j] = temp

                # print(arr)
    
    return arr