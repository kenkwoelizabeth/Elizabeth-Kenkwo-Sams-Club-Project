package com.samsclub.purchaseOrder;






import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long purchaseId;


    private int quantity;


    private String status;

    // constructor


    public PurchaseOrder() {
    }

    public PurchaseOrder(int quantity, String status) {
        this.quantity = quantity;
        this.status = status;
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
