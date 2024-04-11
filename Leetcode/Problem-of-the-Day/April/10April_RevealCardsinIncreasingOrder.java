/*
You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].

You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.

You will do the following steps repeatedly until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1. Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

Note that the first entry in the answer is considered to be the top of the deck.



Example 1:

Input: deck = [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]
Explanation:
We get the deck in the order [17,13,11,2,3,5,7] (this order does not matter), and reorder it.
        After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
We reveal 13, and move 17 to the bottom.  The deck is now [17].
We reveal 17.
Since all the cards revealed are in increasing order, the answer is correct.*/


//Approach 1:

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        Arrays.sort(deck);
        int i = 0, j = 0;

        boolean skip = false;
        int[] res = new int[n];
        while (i < n) {
            if (res[j] == 0 && skip == false) {
                res[j] = deck[i];
                skip = true;
                i++;
                j = (j + 1) % n;
            } else if (res[j] == 0 && skip == true) {
                j = (j + 1) % n;
                skip = false;
            } else {
                j = (j + 1) % n;
            }
        }
        return res;
    }
}

// Apporach 1: Little Optimized

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        Arrays.sort(deck);
        int i = 0, j = 0;

        boolean skip = false;
        int[] res = new int[n];
        while (i < n) {
            if (res[j] == 0 ) {
                if (skip == false) {
                    res[j] = deck[i];
                    i++;
                }
                skip=!skip;
            }
            j = (j + 1) % n;
        }
        return res;
    }
}

//Approach 3:
public int[] deckRevealedIncreasing(int[] deck) {
    int n = deck.length;
    Arrays.sort(deck);
    int[] res = new int[n];
    Deque<Integer> indices = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        indices.add(i);
    }

    // traverse deck
    for (int i = 0; i < n; i++) {
        int idx = indices.poll(); // top position

        res[idx] = deck[i];
        indices.add(indices.poll()); // 2nd top , add at the back of queue
    }
    return res;
}

//Apprach 4 : 3 Optimized
public int[] deckRevealedIncreasing(int[] deck) {
    //deck = [17,13,11,2,3,5,7]
    // Sort Array
    Arrays.sort(deck); // [2,3,5,7,11,13,17]

    int n=deck.length;
    int[] result=new int[n]; // [0,0,0,0,0,0,0]
    Deque<Integer> indices=new LinkedList<>();

    for(int i=0;i<n;i++)
    {
        indices.add(i); // [ 0,1,2,3,4,5,6]
    }

    for(int card:deck)
    {
        int idx=indices.poll();
        result[idx]=card;

        if(!indices.isEmpty())
        {
            indices.add(indices.poll());
        }
    }
    return result;
}