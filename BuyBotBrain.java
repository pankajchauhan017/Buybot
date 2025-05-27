
package ai;

import model.Product;
import dao.ProductDAO;
import java.util.List;

public class BuyBotBrain {
    private ProductDAO productDAO = new ProductDAO();

    public String respond(String input) {
        input = input.toLowerCase();
        List<Product> products = productDAO.getAllProducts();
        if ((input.contains("suggest") || input.contains("recommend")) && !products.isEmpty()) {
            Product p = products.get(0);
            return "How about trying: " + p.getName() + " for $" + p.getPrice() + "?";
        } else {
            return "I can help you find products! Type 'recommend me something'";
        }
    }
}
