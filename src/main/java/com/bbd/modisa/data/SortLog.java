package com.bbd.modisa.data;

public class SortLog implements Comparable<SortLog> {
    Double amount;

    SortLog(Double amount)
    {
        this.amount = amount;
    }


    public int compareTo(SortLog sortLog) {
        return this.amount.compareTo(sortLog.amount);
    }
}
