package com.hzy.find.work.part1;

import com.hzy.find.work.common.ListNode;

public class S2 {

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) {
//            return new ListNode(0, null);
//        }
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        int addNum = (l1.val + l2.val) / 10;
//        int currentNum = (l1.val + l2.val) % 10;
//        ListNode result = new ListNode(currentNum, null);
//        ListNode temp = result;
//        ListNode r1 = l1.next, r2 = l2.next;
//        while (r1 != null && r2 != null) {
//            int sum = r1.val + r2.val + addNum;
//            currentNum = sum % 10;
//            addNum = sum / 10;
//            temp.next = new ListNode(currentNum, null);
//            temp = temp.next;
//            r1 = r1.next;
//            r2 = r2.next;
//        }
//        while (r1 != null) {
//            int sum = r1.val + addNum;
//            currentNum = sum % 10;
//            addNum = sum / 10;
//            temp.next = new ListNode(currentNum, null);
//            temp = temp.next;
//            r1 = r1.next;
//        }
//        while (r2 != null) {
//            int sum = r2.val + addNum;
//            currentNum = sum % 10;
//            addNum = sum / 10;
//            temp.next = new ListNode(currentNum, null);
//            temp = temp.next;
//            r2 = r2.next;
//        }
//        if (addNum != 0) {
//            temp.next = new ListNode(addNum, null);
//        }
//        return result;
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode(0, null);
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        return getResult(l1, l2, 0);
    }

    public static ListNode getResult(ListNode l1, ListNode l2, int addNum) {
        if (l1 == null && l2 == null && addNum==0) {
            return null;
        }
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        int sum = a + b + addNum;
        ListNode result = new ListNode(sum % 10, null);
        if (l1 == null && l2 == null && addNum!=0) {
            return result;
        }
        addNum = sum / 10;
        if (l1 != null && l2 != null) {
            result.next = getResult(l1.next, l2.next, addNum);
            return result;
        }

        if (l2 == null) {
            result.next = getResult(l1.next, null, addNum);
            return result;
        }

        if (l1 == null) {
            result.next = getResult(null, l2.next, addNum);
            return result;
        }
        return result;
    }

//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9,null);
//        ListNode result = getResult(null, l1, 2);
//        StringBuilder sb = new StringBuilder();
//        while (result!=null){
//            sb.append(result.val).append("->");
//            result=result.next;
//        }
//        System.out.println(sb.toString());
//    }
}
