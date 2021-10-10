package com.piminovdmitry.raif_cib_interns_test_task.entity;

import com.piminovdmitry.raif_cib_interns_test_task.service.TransactionType;

import javax.persistence.*;


@Entity
@Table(name="stock_units_movement")
public class StockUnitMove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="color")
    private String color;

    @Column(name="cotton_part")
    private String cottonPart;

    @Column(name="quantity")
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_type")
    private TransactionType transactionType;

    public StockUnitMove() {
    }

    public StockUnitMove(int id, String color, String cottonPart, int quantity, TransactionType transactionType) {
        this.id = id;
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(String cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "StockUnitMove{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", cottonPart='" + cottonPart + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
