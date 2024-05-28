package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Service.ProductService;
import com.accesadades.botiga.Service.SubcategoryService;

import java.time.LocalDateTime;
import java.util.Set;

@Controller
public class WebController {
 
    @Autowired
    private ProductService productService;

    @Autowired
    private SubcategoryService subcategoryService;
 
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
 
    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        Set<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "catalog";
    }

    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Product product = productService.findProductsByName(name);
            model.addAttribute("product", product);
        }
        return "search"; // Referencia a search.html en el directorio templates
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "form"; // Referencia a form.html en el directorio templates
    }

    @RequestMapping(value = "/products/desar", method = RequestMethod.POST)
    public String desar(
            @RequestParam(value = "nom", required = true) String name,
            @RequestParam(value = "descripcio", required = true) String description,
            @RequestParam(value = "fabricant", required = true) String company,
            @RequestParam(value = "preu", required = true) float price,
            @RequestParam(value = "unitats", required = true) int units,
            @RequestParam(value = "subcategoria", required = true) String subcategoryName, // Change to String
            Model model) {

        Product product = new Product();
        Subcategory subcategory = subcategoryService.findSubcategoryByName(subcategoryName); // Fetch Subcategory object
        LocalDateTime create = LocalDateTime.now();

        product.setName(name);
        product.setDescription(description);
        product.setCompany(company);
        product.setPrice(price);
        product.setUnits(units);
        product.setSubcategory(subcategory);
        product.setCreationDate(create);
        product.setUpdateDate(create);

        productService.desar(product);

        return "redirect:/catalog"; // Redirect to catalog page after saving
    }

    // @RequestMapping(value = {"/products/desar", "/form"}, method = {RequestMethod.GET, RequestMethod.POST})
    // public String desar(
    //         @RequestParam(value = "nom", required = true) String name,
    //         @RequestParam(value = "descripcio", required = true) String description,
    //         @RequestParam(value = "fabricant", required = true) String company,
    //         @RequestParam(value = "preu", required = true) float price,
    //         @RequestParam(value = "unitats", required = true) int units,
    //         @RequestParam(value = "subcategoria", required = true) String subcategory_name,

    //         Model model) 
    //         {

    //     System.out.println("Received parameters: ");
    //     System.out.println("Name: " + name);
    //     System.out.println("Description: " + description);
    //     System.out.println("Company: " + company);
    //     System.out.println("Price: " + price);
    //     System.out.println("Units: " + units);
    //     System.out.println("Subcategory: " + subcategory_name);

    //     Product product = new Product();
    //     Subcategory subcategory = subcategoryService.findSubcategoryByName(subcategory_name);
    //     LocalDateTime create = LocalDateTime.now();

    //     product.setName(name);
    //     product.setDescription(description);
    //     product.setCompany(company);
    //     product.setPrice(price);
    //     product.setUnits(units);
    //     product.setSubcategory(subcategory);
    //     product.setCreationDate(create);
    //     product.setUpdateDate(create);

    //     productService.desar(product);

    //     return "form"; 
    // }
}
