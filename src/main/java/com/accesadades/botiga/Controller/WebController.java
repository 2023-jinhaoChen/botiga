package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Service.ProductService;
import com.accesadades.botiga.Service.SubcategoryService;

import java.time.LocalDateTime;
import java.util.Set;

@Controller
public class WebController {
 
    @Autowired
    // Inyección del servicio ProductService
    private ProductService productService; 

    @Autowired
    // Inyección del servicio SubcategoryService
    private SubcategoryService subcategoryService; 
 
    // Ruta para la página de inicio
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
 
    // Ruta para la página de catálogo de productos
    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        Set<Product> products = productService.findAllProducts(); // Obtener todos los productos
        model.addAttribute("products", products); // Agregar productos al modelo para pasarlos a la vista
        return "catalog"; // Devolver la vista del catálogo
    }

    // Ruta para buscar un producto por nombre
    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Product product = productService.findProductsByName(name); // Buscar el producto por nombre
            model.addAttribute("product", product); // Agregar el producto al modelo para pasarlos a la vista
        }
        return "search"; // Devolver la vista de búsqueda
    }

    // Ruta para mostrar el formulario de agregar un nuevo producto
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Product()); // Agregar un nuevo objeto Product al modelo
        return "form"; // Devolver la vista del formulario
    }

    // Ruta para procesar la solicitud de agregar un nuevo producto
    @RequestMapping(value = "/products/desar", method = RequestMethod.POST)
    public String desar(
            @RequestParam(value = "nom", required = true) String name,
            @RequestParam(value = "descripcio", required = true) String description,
            @RequestParam(value = "fabricant", required = true) String company,
            @RequestParam(value = "preu", required = true) float price,
            @RequestParam(value = "unitats", required = true) int units,
            @RequestParam(value = "subcategoria", required = true) String subcategoryName, // Cambiar a String
            Model model) {

        Product product = new Product(); // Crear un nuevo objeto Product
        Subcategory subcategory = subcategoryService.findSubcategoryByName(subcategoryName); // Buscar la subcategoría por nombre
        LocalDateTime create = LocalDateTime.now(); // Obtener la fecha y hora actual

        // Establecer los atributos del nuevo producto
        product.setName(name);
        product.setDescription(description);
        product.setCompany(company);
        product.setPrice(price);
        product.setUnits(units);
        product.setSubcategory(subcategory);
        product.setCreationDate(create);
        product.setUpdateDate(create);

        productService.desar(product); // Guardar el nuevo producto

        return "redirect:/catalog"; // Redirigir a la página del catálogo después de guardar
    }

    // Ruta para obtener todas las subcategorías
    @RequestMapping(value = "/subcategories", method = RequestMethod.GET)
    @ResponseBody
    public Set<Subcategory> getAllSubcategories() {
        return subcategoryService.findAllSubcategories(); // Obtener todas las subcategorías
    }

    // Ruta para procesar la solicitud de eliminar un producto por nombre
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public String deleteProductByName(@RequestParam(value = "name", required = true) String name) {
        Product product = productService.findProductsByName(name); // Buscar el producto por nombre
        if (product != null) {
            productService.delete(product); // Eliminar el producto encontrado
        }
        return "redirect:/catalog"; // Redirigir a la página del catálogo después de eliminar
    }
}
