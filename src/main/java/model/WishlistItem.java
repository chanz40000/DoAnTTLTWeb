package model;

public class WishlistItem {
    private int itemId;
    private User user;
    private Product product;

    public WishlistItem() {
    }

    public WishlistItem(int itemId, User user, Product product) {
        this.itemId = itemId;
        this.user = user;
        this.product = product;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
