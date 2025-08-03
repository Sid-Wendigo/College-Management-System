package com.college.api.model;

import java.math.BigDecimal;
import java.util.Date;

public class Fee {
    private BigDecimal totalFee;
    private BigDecimal paidFee;
    private Date dueDate;
    public Fee(BigDecimal totalFee, BigDecimal paidFee, Date dueDate) { this.totalFee = totalFee; this.paidFee = paidFee; this.dueDate = dueDate; }
    public BigDecimal getTotalFee() { return totalFee; }
    public BigDecimal getPaidFee() { return paidFee; }
    public Date getDueDate() { return dueDate; }
}