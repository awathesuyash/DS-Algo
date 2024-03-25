/*
You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).



Example 1:

Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
        Person 1 has height 7 with no other people taller or the same height in front.
        Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.*/

public int[][] reconstructQueue(int[][] people) {

    int row = people.length;
    int col = people[0].length;
    int[][] ans = new int[row][col];
    // sort our array in descending order by height and in ascending order by k for
    // people that share the same height.
    // Then, we just insert into an array based on the k value as
    // the index. We'll use a linked list initially for insertion before converting
    // to a 2D array.

    Arrays.sort(people,(a,b)-> a[0]==b[0] ?a[1]-b[1]:b[0]-a[0]);
    // Arrays.sort(people, new Comparator<int[]>() {
    //     public int compare(int[] a, int[] b) {
    //         if (a[0] == b[0])
    //             return a[1] - b[1];
    //         return b[0] - a[0];
    //     }
    // });
    List<int[]> list = new LinkedList<>();
    for (int[] p : people) {
        list.add(p[1], p);
    }

    return list.toArray(new int[row][2]);

}
