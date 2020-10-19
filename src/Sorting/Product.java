package Sorting;

public class Product implements Comparable<Product> {
    private int price;
    private int sale;

    public Product(int price, int sale) {
        this.price = price;
        this.sale = sale;
    }

    public int getPrice() {
        return price;
    }

    public int getSale() {
        return sale;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public int compareTo(Product o) {
        return this.price == o.getPrice() ? this.sale - o.getSale(): this.price - o.getPrice();
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", sale=" + sale +
                '}';
    }
}

