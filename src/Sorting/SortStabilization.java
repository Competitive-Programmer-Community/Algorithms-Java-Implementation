package Sorting;

// !!!
public class SortStabilization {

    private static void bubbleSort(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if (products[j].compareTo(products[j - 1]) <= 0) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(3, 10);
        Product product2 = new Product(1, 9);
        Product product3 = new Product(2, 9);
        Product product4 = new Product(0, 9);
        Product[] products = new Product[]{product1, product2, product3, product4};
        bubbleSort(products);
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].toString());
        }
    }
}

