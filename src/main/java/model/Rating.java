package model;

public class Rating {
    private int ratingId;
    private Product product;
    private int rating;

    public Rating(int ratingId, Product product, int rating) {
        this.ratingId = ratingId;
        this.product = product;
        this.rating = rating;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
