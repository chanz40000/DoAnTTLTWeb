package model;

import java.time.LocalDateTime;

public class OrderHistory {
    private int orderHistoryId;
    private Order order;
    private User user;
    private StatusOrder statusOrder;
    private LocalDateTime time;
    private String reason;

    public OrderHistory() {
    }

    public OrderHistory(int orderHistoryId, Order order, User user, StatusOrder statusOrder, LocalDateTime time) {
        this.orderHistoryId = orderHistoryId;
        this.order = order;
        this.user = user;
        this.statusOrder = statusOrder;
        this.time = time;
    }

    public OrderHistory(int orderHistoryId, Order order, StatusOrder statusOrder, LocalDateTime time, String reason) {
        this.orderHistoryId = orderHistoryId;
        this.order = order;
        this.statusOrder = statusOrder;
        this.time = time;
        this.reason = reason;
    }

    public OrderHistory(int orderHistoryId, Order order, User user, StatusOrder statusOrder, LocalDateTime time, String reason) {
        this.orderHistoryId = orderHistoryId;
        this.order = order;
        this.user = user;
        this.statusOrder = statusOrder;
        this.time = time;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getOrderHistoryId() {
        return orderHistoryId;
    }

    public void setOrderHistoryId(int orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public LocalDateTime getTime() {
        return java.time.LocalDateTime.now();
    }

}
