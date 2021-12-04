using System;

namespace SortingAlgorithms {
    public static class Sort {

        public static void Swap(sbyte[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(byte[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(short[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(ushort[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(int[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(uint[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(long[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(ulong[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(decimal[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(double[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        public static void Swap(float[] array, int i, int j) {
            var h = array[i];
            array[i] = array[j];
            array[j] = h;
        }

        /// <summary>
        /// Mergesort
        /// best-case: O(n* log(n))
        /// average-case: O(n* log(n))
        /// worst-case: O(n* log(n))
        /// </summary>
        /// <returns>The sorted array.</returns>
        /// <param name="array">array.</param>
        public static int[] MergeSort(int[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-listså
            int[] left_array = new int[m];
            int[] right_array = new int[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        /// <summary>
        /// Merge the specified left_array and right_array.
        /// </summary>
        /// <returns>The merge.</returns>
        /// <param name="left_array">Left array.</param>
        /// <param name="right_array">Right array.</param>
        public static int[] Merge(int[] left_array, int[] right_array) {
            int[] m = new int[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static double[] MergeSort(double[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            double[] left_array = new double[m];
            double[] right_array = new double[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static double[] Merge(double[] left_array, double[] right_array) {
            double[] m = new double[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static float[] MergeSort(float[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            float[] left_array = new float[m];
            float[] right_array = new float[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static float[] Merge(float[] left_array, float[] right_array) {
            float[] m = new float[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static sbyte[] MergeSort(sbyte[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            sbyte[] left_array = new sbyte[m];
            sbyte[] right_array = new sbyte[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static sbyte[] Merge(sbyte[] left_array, sbyte[] right_array) {
            sbyte[] m = new sbyte[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static short[] MergeSort(short[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            short[] left_array = new short[m];
            short[] right_array = new short[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static short[] Merge(short[] left_array, short[] right_array) {
            short[] m = new short[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static long[] MergeSort(long[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            long[] left_array = new long[m];
            long[] right_array = new long[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static long[] Merge(long[] left_array, long[] right_array) {
            long[] m = new long[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static byte[] MergeSort(byte[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            byte[] left_array = new byte[m];
            byte[] right_array = new byte[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static byte[] Merge(byte[] left_array, byte[] right_array) {
            byte[] m = new byte[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static ushort[] MergeSort(ushort[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            ushort[] left_array = new ushort[m];
            ushort[] right_array = new ushort[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static ushort[] Merge(ushort[] left_array, ushort[] right_array) {
            ushort[] m = new ushort[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static uint[] MergeSort(uint[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            uint[] left_array = new uint[m];
            uint[] right_array = new uint[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static uint[] Merge(uint[] left_array, uint[] right_array) {
            uint[] m = new uint[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static ulong[] MergeSort(ulong[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            ulong[] left_array = new ulong[m];
            ulong[] right_array = new ulong[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static ulong[] Merge(ulong[] left_array, ulong[] right_array) {
            ulong[] m = new ulong[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        public static decimal[] MergeSort(decimal[] array) {
            //  Exit condition for recursion
            if (array.Length <= 1) return array;



            //  Middle index of list to sort
            int m = array.Length / 2;
            //  Define left and right sub-lists
            decimal[] left_array = new decimal[m];
            decimal[] right_array = new decimal[array.Length - m];



            //  Initialize left list
            for (int i = 0; i < m; i++) left_array[i] = array[i];

            //  Initialize right list
            for (int i = m, x = 0; i < array.Length; i++, x++) right_array[x] = array[i];

            //  Recursively sort left half of the list
            left_array = MergeSort(left_array);
            //  Recursively sort right half of the list
            right_array = MergeSort(right_array);

            //  Merge sorted sub-lists
            return Merge(left_array, right_array);
        }

        public static decimal[] Merge(decimal[] left_array, decimal[] right_array) {
            decimal[] m = new decimal[left_array.Length + right_array.Length];
            int index_l = 0;
            int nl, nr;
            nl = left_array.Length - 1;
            nr = right_array.Length - 1;
            for (int i = 0; i <= nl + nr + 1; i++) {
                if (index_l > nl) {
                    m[i] = (right_array[i - index_l]);
                    continue;
                }

                if (index_l < i - nr) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                    continue;
                }

                if (left_array[index_l].CompareTo(right_array[i - index_l]) < 0 || left_array[index_l].Equals(right_array[i - index_l])) {
                    m[i] = (left_array[index_l]);
                    index_l++;
                } else {
                    m[i] = (right_array[i - index_l]);
                }
            }
            return m;
        }

        /// <summary>
        /// Selectionsort
        /// best-case, average-case, worst-case: O(n^2)
        /// </summary>
        /// <returns>The sorted array.</returns>
        /// <param name="array">Array.</param>
        public static int[] SelectionSort(int[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static double[] SelectionSort(double[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static float[] SelectionSort(float[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static sbyte[] SelectionSort(sbyte[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static byte[] SelectionSort(byte[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static long[] SelectionSort(long[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static short[] SelectionSort(short[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static ushort[] SelectionSort(ushort[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static uint[] SelectionSort(uint[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static ulong[] SelectionSort(ulong[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        public static decimal[] SelectionSort(decimal[] array) {
            int n = array.Length - 1;
            //  Current position for insertion
            int index = 0;
            //  Position of the current smallest element
            int minPos;
            do {
                minPos = index;
                for (int i = (index + 1); i <= n; i++) {
                    if (array[i].CompareTo(array[minPos]) < 0) {
                        minPos = i;
                    }
                }
                Swap(array, minPos, index);
                index++;
            } while (index < n);
            //  Return sorted list
            return array;
        }

        /// <summary>
        /// Bubblesort
        /// best-case : O(n), average-case, worst-case : O(n^2)
        /// </summary>
        /// <returns>The sorted array.</returns>
        /// <param name="array">Array.</param>
        public static int[] BubbleSort(int[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static double[] BubbleSort(double[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static float[] BubbleSort(float[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static sbyte[] BubbleSort(sbyte[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static short[] BubbleSort(short[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static long[] BubbleSort(long[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static byte[] BubbleSort(byte[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static ushort[] BubbleSort(ushort[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static uint[] BubbleSort(uint[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        public static ulong[] BubbleSort(ulong[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;

        }

        public static decimal[] BubbleSort(decimal[] array) {
            int n = array.Length;
            int newn;
            do {
                //  New length of list to sort
                newn = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i].CompareTo(array[i + 1]) > 0) {
                        Swap(array, i, i + 1);
                        newn = i + 1;
                    }
                }
                n = newn;
            } while (n > 1);
            //  Return sorted list
            return array;
        }

        /// <summary>
        /// Quicksort
        /// best-case, average-case: O(n*log(n)), worst-case: O(n^2)
        /// </summary>
        /// <returns>The sorted array.</returns>
        /// <param name="array">Array.</param>
        /// <param name="lo">Lo.</param>
        /// <param name="hi">Hi.</param>

        public static int[] QuickSort(int[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(int[] array, int low, int high) {
            //  Assign the last element to the pivot element
            int pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static double[] QuickSort(double[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(double[] array, int low, int high) {
            //  Assign the last element to the pivot element
            double pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static float[] QuickSort(float[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(float[] array, int low, int high) {
            //  Assign the last element to the pivot element
            float pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static short[] QuickSort(short[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(short[] array, int low, int high) {
            //  Assign the last element to the pivot element
            short pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static ushort[] QuickSort(ushort[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(ushort[] array, int low, int high) {
            //  Assign the last element to the pivot element
            ushort pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static byte[] QuickSort(byte[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(byte[] array, int low, int high) {
            //  Assign the last element to the pivot element
            byte pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static sbyte[] QuickSort(sbyte[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(sbyte[] array, int low, int high) {
            //  Assign the last element to the pivot element
            sbyte pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static uint[] QuickSort(uint[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(uint[] array, int low, int high) {
            //  Assign the last element to the pivot element
            uint pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static long[] QuickSort(long[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(long[] array, int low, int high) {
            //  Assign the last element to the pivot element
            long pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static ulong[] QuickSort(ulong[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(ulong[] array, int low, int high) {
            //  Assign the last element to the pivot element
            ulong pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

        public static decimal[] QuickSort(decimal[] array, int lo, int hi) {
            if (lo < hi) {
                int pi = Partition(array, lo, hi);
                //  Recursively sort smaller half of the list
                QuickSort(array, lo, pi - 1);
                //  Recursively sort higher half of the list
                QuickSort(array, pi + 1, hi);
            }
            //  Return sorted list
            return array;
        }

        public static int Partition(decimal[] array, int low, int high) {
            //  Assign the last element to the pivot element
            decimal pivot = array[high];
            //  Index of smaller element
            int lowIndex = (low - 1);
            //  Iterate from lowest to highest element
            for (int j = low; j <= high - 1; j++) {

                //Swap elements if j-th element is smaller than the pivot element
                if (array[j].CompareTo(pivot) < 0 || array[j].Equals(pivot)) {
                    lowIndex++;
                    Swap(array, lowIndex, j);
                }
            }
            Swap(array, lowIndex + 1, high);
            return (lowIndex + 1);
        }

         /// <summary>
         /// Insertionsort
         /// best-case: O(n) average-case, worst-case: O(n^2)
         /// </summary>
         /// <returns>The sort.</returns>
         /// <param name="array">Array.</param>
        public static int[] InsertionSort(int[] array) {
            int n = array.Length;
            //  value to be sorted
            int value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static double[] InsertionSort(double[] array) {
            int n = array.Length;
            //  value to be sorted
            double value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static float[] InsertionSort(float[] array) {
            int n = array.Length;
            //  value to be sorted
            float value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static sbyte[] InsertionSort(sbyte[] array) {
            int n = array.Length;
            //  value to be sorted
            sbyte value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static short[] InsertionSort(short[] array) {
            int n = array.Length;
            //  value to be sorted
            short value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static ushort[] InsertionSort(ushort[] array) {
            int n = array.Length;
            //  value to be sorted
            ushort value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static byte[] InsertionSort(byte[] array) {
            int n = array.Length;
            //  value to be sorted
            byte value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static long[] InsertionSort(long[] array) {
            int n = array.Length;
            //  value to be sorted
            long value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static uint[] InsertionSort(uint[] array) {
            int n = array.Length;
            //  value to be sorted
            uint value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static ulong[] InsertionSort(ulong[] array) {
            int n = array.Length;
            //  value to be sorted
            ulong value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        public static decimal[] InsertionSort(decimal[] array) {
            int n = array.Length;
            //  value to be sorted
            decimal value;
            //  Insertion index of 'value'
            int j;
            //  Iterate from 2nd to last element
            for (int i = 1; i < n; i++) {
                value = array[i];
                j = i;
                /* If left value of array[j] is higher than current value,
                 * move array[j-1] one the left
                 */
                while (j > 0 && (array[j - 1].CompareTo(value) > 0)) {
                    array[j] = array[j - 1];
                    j -= 1;
                }
                array[j] = value;
            }
            //  Return sorted list
            return array;
        }

        /// <summary>
        /// Combsort
        /// best-case, average-case : O(n*(logn)), worst-case : O(n^2)
        /// </summary>
        /// <returns>The sorted array.</returns>
        /// <param name="array">Array.</param>
        public static int[] CombSort(int[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static uint[] CombSort(uint[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static double[] CombSort(double[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }
        public static float[] CombSort(float[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static decimal[] CombSort(decimal[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static sbyte[] CombSort(sbyte[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static short[] CombSort(short[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static ushort[] CombSort(ushort[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static byte[] CombSort(byte[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static long[] CombSort(long[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        public static ulong[] CombSort(ulong[] array) {

            int stepLength = array.Length;
            bool swapped;
            do {
                swapped = false;
                for (int i = 0; i < (array.Length - stepLength); i++) {
                    if (array[i].CompareTo(array[i + stepLength]) > 0) {
                        Swap(array, i, i + stepLength);
                        swapped = true;
                    }
                }
                if (stepLength > 1) {
                    stepLength = (int)Math.Floor(stepLength / 1.3);
                }

            } while (swapped == true || stepLength > 1);
            return array;
        }

        /// <summary>
        /// Introsort
        /// best-case, average-case, worst-case: O(n*log(n))
        /// </summary>
        /// <returns>The sorted Array.</returns>
        /// <param name="array">Array.</param>
        public static int[] IntroSort(int[] array) {

            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static uint[] IntroSort(uint[] array) {

            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static double[] IntroSort(double[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static float[] IntroSort(float[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static short[] IntroSort(short[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static ushort[] IntroSort(ushort[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static byte[] IntroSort(byte[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static sbyte[] IntroSort(sbyte[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static long[] IntroSort(long[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static ulong[] IntroSort(ulong[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            if (p < 16) {
                array = InsertionSort(array);
            } else {
                array = p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            }
            return array;
        }

        public static decimal[] IntroSort(decimal[] array) {


            int p = Partition(array, 0, array.Length - 1);
            //  Use Insertionsort for small lists
            array = p < 16 ? InsertionSort(array) : p > (2 * Math.Log(array.Length)) ? HeapSort(array) : QuickSort(array, 0, array.Length - 1);
            return array;
        }

        /// <summary>
        /// Heapsort
        /// best-case, average-case, worst-case : O(n*log(n))
        /// </summary>
        /// <returns>The sorted array.</returns>
        /// <param name="array">Array.</param>
        public static int[] HeapSort(int[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }
        /// <summary>
        /// Heapify the specified array, n and i.
        /// </summary>
        /// <returns>The heapify.</returns>
        /// <param name="array">Array.</param>
        /// <param name="n">N.</param>
        /// <param name="i">The index.</param>
        public static int[] Heapify(int[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static double[] HeapSort(double[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static double[] Heapify(double[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static float[] HeapSort(float[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static float[] Heapify(float[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static decimal[] HeapSort(decimal[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static decimal[] Heapify(decimal[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static ushort[] HeapSort(ushort[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static ushort[] Heapify(ushort[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static short[] HeapSort(short[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static short[] Heapify(short[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static sbyte[] HeapSort(sbyte[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static sbyte[] Heapify(sbyte[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static byte[] HeapSort(byte[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static byte[] Heapify(byte[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static uint[] HeapSort(uint[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static uint[] Heapify(uint[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static long[] HeapSort(long[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static long[] Heapify(long[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }

        public static ulong[] HeapSort(ulong[] array) {
            int n = array.Length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(array, n, i);

            for (int i = n - 1; i >= 0; i--) {
                Swap(array, 0, i);

                // call max heapify on the reduced heap
                array = Heapify(array, i, 0);
            }
            return array;
        }

        public static ulong[] Heapify(ulong[] array, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left = 2*i + 1
            int right = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (left < n && array[left].CompareTo(array[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && array[right].CompareTo(array[largest]) > 0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                Swap(array, i, largest);

                // Recursively heapify the affected sub-tree
                array = Heapify(array, n, largest);
            }
            return array;
        }


    }
}
