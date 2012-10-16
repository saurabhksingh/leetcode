package com.dev.saurabh.leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/7/12
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeKSortedLists {

    private void runTest()
    {
        ArrayList<ListNode> input = new ArrayList<ListNode>();
        ListNode head = null;
        ListNode list = new ListNode(1);head = list;list.next=new ListNode(5);list = list.next;list.next=new ListNode(10);
        input.add(head);
        list = new ListNode(3);head = list;list.next=new ListNode(8);list = list.next;list.next=new ListNode(12);
        input.add(head);
        list = new ListNode(4);head = list;list.next=new ListNode(7);list = list.next;list.next=new ListNode(9);
        input.add(head);

        ListNode out = mergeKLists(input);

        while(out != null)
        {
            System.out.println(out.val);
            out = out.next;
        }
    }

    public static void main(String [] args)
    {
        MergeKSortedLists instance = new MergeKSortedLists();
        instance.runTest();
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode result = null;
        ListNode head = null;
        int size = lists.size();
        for(int i=0; i<size;i++)
        {
            if(lists.get(i) == null)
            {
              lists.remove(i);
              i--;
              size--;
            }
        }
        MinHeap heap = new MinHeap(10000);
        //size is the number of lists
        for(int i=0; i<size; i++)
        {
           heap.add(lists.get(i));
        }
        while(!heap.isEmpty())
        {
            ListNode node = heap.removeMin();
            if(result == null)
            {
                result = node;
                head = node;
            }
            else
            {
                head.next = node;
                head = node;
            }

            if(node.next != null)
            {
                heap.add(node.next);
            }

        }
        return result;
    }

    class MinHeap {

        /** Fixed-size array heap representation */
        private ListNode[ ] array;
        /** Number of nodes in the heap (array) */
        private int n = 0;

        /** Constructs a heap of specified size */
        public MinHeap( final int size ) {
            array = new ListNode[ size ];
        }

        /** Returns (without removing) the smallest (min) element from the heap. */
        public ListNode min( ) {
            if( isEmpty( ) ) {
                throw new RuntimeException( "Heap is empty!" );
            }

            return array[ 0 ];
        }

        /** Removes and returns the smallest (min) element from the heap. */
        public ListNode removeMin( ) {
            if( isEmpty( ) ) {
                throw new RuntimeException( "Heap is empty!" );
            }

            final ListNode min = array[ 0 ];
            array[ 0 ] = array[ n - 1 ];
            if( --n > 0 ) siftDown( 0 );
            return min;
        }

        /** Checks if the heap is empty. */
        public boolean isEmpty( ) {
            return n == 0;
        }

        /** Adds a new element to the heap and sifts up/down accordingly. */
        public void add( final ListNode value ) {
            if( n == array.length ) {
                throw new RuntimeException( "Heap is full!" );
            }

            array[ n ] = value;
            siftUp( n );
            n++;
        }

        /**
         * Sift up to make sure the heap property is not broken.
         * This method is used when a new element is added to the heap
         * and we need to make sure that it is at the right spot.
         */
        private void siftUp( final int index ) {
            if( index > 0 ) {
                final int parent = ( index - 1 ) / 2;
                if( array[ parent ].val > array[ index ].val ) {
                    swap( parent, index );
                    siftUp( parent );
                }
            }
        }

        /**
         * Sift down to make sure that the heap property is not broken
         * This method is used when removing the min element, and we need
         * to make sure that the replacing element is at the right spot.
         */
        private void siftDown( int index ) {

            final int leftChild = 2 * index + 1;
            final int rightChild = 2 * index + 2;

            // Check if the children are outside the array bounds.
            if( rightChild >= n && leftChild >= n ) return;

            // Determine the smallest child out of the left and right children.
            final int smallestChild = array[ rightChild ].val > array[ leftChild ].val ? leftChild : rightChild;

            if( array[ index ].val > array[ smallestChild ].val ) {
                swap( smallestChild, index );
                siftDown( smallestChild );
            }
        }

        /** Helper method for swapping array elements */
        private void swap( int a, int b ) {
            ListNode temp = array[ a ];
            array[ a ] = array[ b ];
            array[ b ] = temp;
        }
    }
}
