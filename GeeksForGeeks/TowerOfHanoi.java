package GeeksForGeeks;

// https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1
public class TowerOfHanoi {
    // move N-1 disks to the auxiliary rod (recursively)
    // move Nth disk to the destination rod
    // move N-1 disk from auxiliary rod to destination rod (recursively)
    public static long toh(int N, int from, int to, int aux) {
        if (N == 0)
            return 0;
        long moves = 0;
        moves += toh(N-1, from, aux, to);
        System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
        moves += toh(N-1, aux, to, from);
        return moves+1;
    }

    public static void main(String[] args) {
        System.out.println(toh(3, 1, 3, 2));
    }
}
