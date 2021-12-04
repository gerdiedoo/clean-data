def shellsort(lst):
	n = len(lst)
	interval = n // 2
	while interval > 0:
		for i in range(interval, n):
			while i - interval >= 0 and lst[i] < lst[i - interval]:
				lst[i], lst[i - interval] = lst[i - interval], lst[i]
				i = i - interval
		interval = interval // 2
	return lst

lst = [7, 5, 3, 1, 5, 9, 8, 4, 6, 2, 10]
print(shellsort(lst))