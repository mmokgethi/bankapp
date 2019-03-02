package com.bbd.modisa;
import java.lang.String;

public enum AccountType {
    Cheque{
        public String toString()
        {
            return ("Cheque");
        }
    },
    Savings{
        public String toString()
        {
            return ("Savings");
        }
    }
}
