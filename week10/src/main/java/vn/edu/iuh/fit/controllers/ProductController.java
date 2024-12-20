package vn.edu.iuh.fit.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.dto.request.ProductCreateRequest;
import vn.edu.iuh.fit.dto.request.ProductUpdateRequest;
import vn.edu.iuh.fit.entities.Catergory;
import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.services.CatergoryService;
import vn.edu.iuh.fit.services.ProductService;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CatergoryService catergoryService;

    @GetMapping
    public String listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) Integer categoryId,
            Model model) {

        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> productPage = categoryId != null
                ? productService.getProductsByCategory(categoryId, pageable)
                : productService.getAllProducts(pageable);

        List<Catergory> categories = catergoryService.getAllCatergory();

        model.addAttribute("products", productPage);
        model.addAttribute("categories", categories);
        model.addAttribute("currentCategoryId", categoryId);

        return "product/list";
    }

    @GetMapping("/search")
    public String searchProducts(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> products;

        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            products = productService.searchProducts(searchTerm.trim(), pageable);
        } else {
            products = productService.getAllProducts(pageable);
        }

        List<Catergory> categories = catergoryService.getAllCatergory();

        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("searchTerm", searchTerm);

        return "product/list";
    }
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new ProductCreateRequest());
        model.addAttribute("categories", catergoryService.getAllCatergory());
        return "product/add";
    }

    @PostMapping("/add")
    public String addProduct(
            @Valid @ModelAttribute("product") ProductCreateRequest request,
            BindingResult bindingResult,
            Model model) {

        validateProductDetails(request, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", catergoryService.getAllCatergory());
            return "product/add";
        }

        productService.createProduct(request.getCatergory().getCart_id(), request);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        ProductUpdateRequest productRequest = new ProductUpdateRequest();

        // Map Product to ProductCreateRequest
        BeanUtils.copyProperties(product, productRequest);
        productRequest.setId(product.getId()); // Explicitly set ID
        productRequest.setCatergory(product.getCatergory());

        model.addAttribute("product", productRequest);
        model.addAttribute("categories", catergoryService.getAllCatergory());
        return "product/edit";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(
            @PathVariable int id,
            @Valid @ModelAttribute("product") ProductUpdateRequest request,
            BindingResult bindingResult,
            Model model) {


        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", catergoryService.getAllCatergory());
            return "product/edit";
        }

        request.setId(id); // Ensure ID is set before update
        productService.updateProduct(id, request);
        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/view";
    }

    private void validateProductDetails(@Valid ProductCreateRequest request, BindingResult bindingResult) {
        // Code validation
        if (!Pattern.matches("Pro\\d{3}-(?:0[1-9]|1[0-2])", request.getCode())) {
            bindingResult.rejectValue("code", "invalid.code", "Invalid code format. Must be ProXXX-MM");
        }

        // Name validation
        if (request.getName().length() > 20) {
            bindingResult.rejectValue("name", "invalid.name", "Name must be max 20 characters");
        }

        // Description validation
        if (request.getDescription() == null || request.getDescription().trim().isEmpty()) {
            bindingResult.rejectValue("description", "invalid.description", "Description cannot be empty");
        }

        // Register date validation
        if (request.getRegisterDate() == null || request.getRegisterDate().after(new Date())) {
            bindingResult.rejectValue("registerDate", "invalid.registerDate", "Register date must be before current date");
        }

        // Price validation
        if (request.getPrice() <= 0) {
            bindingResult.rejectValue("price", "invalid.price", "Price must be greater than 0");
        }
    }
}