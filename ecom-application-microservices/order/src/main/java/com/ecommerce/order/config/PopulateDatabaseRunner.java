package com.ecommerce.order.config;

import com.ecommerce.order.dto.CartItemRequest;
import com.ecommerce.order.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PopulateDatabaseRunner implements CommandLineRunner {

//    private final UserService userService;
//    private final ProductService productService;
    private final CartService cartService;

    @Override
    public void run(String... args) throws Exception {
//        populateUsers();
//        populateProducts();
//        populateCarts();
    }

    private void populateCarts() {
        List<CartItemRequest> cartItemRequestList = List.of(
                new CartItemRequest(1L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(2L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(3L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(4L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(5L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(6L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(7L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(8L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(9L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(10L, 1 + (int)(Math.random() * ((10 - 1) + 1))),
                new CartItemRequest(11L, 1 + (int)(Math.random() * ((10 - 1) + 1)))
        );
        cartItemRequestList.forEach(request -> cartService.addToCart(String.valueOf(1 + (int)(Math.random() * ((5 - 1) + 1))), request));
    }
/*
    private void populateProducts() {
        List<ProductRequest> productRequestList = List.of(new ProductRequest("iPhone 5s", "The iPhone 5s is a classic smartphone known for its compact design and advanced features during its release. While it's an older model, it still provides a reliable user experience.", BigDecimal.valueOf(199.99), 25L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/iphone-5s/thumbnail.webp" ),
                new ProductRequest("iPhone 6", "The iPhone 6 is a stylish and capable smartphone with a larger display and improved performance. It introduced new features and design elements, making it a popular choice in its time.", BigDecimal.valueOf(299.99), 60L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/iphone-6/thumbnail.webp" ),
                new ProductRequest("iPhone 13 Pro", "The iPhone 13 Pro is a cutting-edge smartphone with a powerful camera system, high-performance chip, and stunning display. It offers advanced features for users who demand top-notch technology.", BigDecimal.valueOf(1099.99), 56L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/iphone-13-pro/thumbnail.webp" ),
                new ProductRequest("iPhone X", "The iPhone X is a flagship smartphone featuring a bezel-less OLED display, facial recognition technology (Face ID), and impressive performance. It represents a milestone in iPhone design and innovation.", BigDecimal.valueOf(899.99), 37L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/iphone-x/thumbnail.webp" ),
                new ProductRequest("Oppo A57", "The Oppo A57 is a mid-range smartphone known for its sleek design and capable features. It offers a balance of performance and affordability, making it a popular choice.", BigDecimal.valueOf(249.99), 19L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/oppo-a57/thumbnail.webp" ),
                new ProductRequest("Oppo F19 Pro Plus", "The Oppo F19 Pro Plus is a feature-rich smartphone with a focus on camera capabilities. It boasts advanced photography features and a powerful performance for a premium user experience.", BigDecimal.valueOf(399.99), 78L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/oppo-f19-pro-plus/thumbnail.webp" ),
                new ProductRequest("Oppo K1", "The Oppo K1 series offers a range of smartphones with various features and specifications. Known for their stylish design and reliable performance, the Oppo K1 series caters to diverse user preferences.", BigDecimal.valueOf(299.99), 55L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/oppo-k1/thumbnail.webp" ),
                new ProductRequest("Realme C35", "The Realme C35 is a budget-friendly smartphone with a focus on providing essential features for everyday use. It offers a reliable performance and user-friendly experience.", BigDecimal.valueOf(149.99), 48L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/realme-c35/thumbnail.webp" ),
                new ProductRequest("Realme X", "The Realme X is a mid-range smartphone known for its sleek design and impressive display. It offers a good balance of performance and camera capabilities for users seeking a quality device.", BigDecimal.valueOf(299.99), 12L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/realme-x/thumbnail.webp" ),
                new ProductRequest("Realme XT", "The Realme XT is a feature-rich smartphone with a focus on camera technology. It comes equipped with advanced camera sensors, delivering high-quality photos and videos for photography enthusiasts.", BigDecimal.valueOf(349.99), 80L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/realme-xt/thumbnail.webp" ),
                new ProductRequest("Samsung Galaxy S7", "The Samsung Galaxy S7 is a flagship smartphone known for its sleek design and advanced features. It features a high-resolution display, powerful camera, and robust performance.", BigDecimal.valueOf(299.99), 67L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/samsung-galaxy-s7/thumbnail.webp" ),
                new ProductRequest("Samsung Galaxy S8", "The Samsung Galaxy S8 is a premium smartphone with an Infinity Display, offering a stunning visual experience. It boasts advanced camera capabilities and cutting-edge technology.", BigDecimal.valueOf(499.99), 0L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/samsung-galaxy-s8/thumbnail.webp" ),
                new ProductRequest("Samsung Galaxy S10", "The Samsung Galaxy S10 is a flagship device featuring a dynamic AMOLED display, versatile camera system, and powerful performance. It represents innovation and excellence in smartphone technology.", BigDecimal.valueOf(699.99), 19L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/samsung-galaxy-s10/thumbnail.webp" ),
                new ProductRequest("Vivo S1", "The Vivo S1 is a stylish and mid-range smartphone offering a blend of design and performance. It features a vibrant display, capable camera system, and reliable functionality.", BigDecimal.valueOf(249.99), 50L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/vivo-s1/thumbnail.webp" ),
                new ProductRequest("Vivo V9", "The Vivo V9 is a smartphone known for its sleek design and emphasis on capturing high-quality selfies. It features a notch display, dual-camera setup, and a modern design.", BigDecimal.valueOf(299.99), 82L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/vivo-v9/thumbnail.webp" ),
                new ProductRequest("Vivo X21", "The Vivo X21 is a premium smartphone with a focus on cutting-edge technology. It features an in-display fingerprint sensor, a high-resolution display, and advanced camera capabilities.", BigDecimal.valueOf(499.99), 7L, "smartphones", "https://cdn.dummyjson.com/product-images/smartphones/vivo-x21/thumbnail.webp" ));
        productRequestList.forEach(productService::createProduct);
    }

    private void populateUsers() {
        List<UserRequest> userRequestList = List.of(new UserRequest("Emily", "Johnson", "emily.johnson@x.dummyjson.com", "+81 965-431-3024", new AddressDTO("626 Main Street", "Phoenix", "Mississippi", "29112", "United States" ) ),
                new UserRequest("Michael", "Williams", "michael.williams@x.dummyjson.com", "+49 258-627-6644", new AddressDTO("385 Fifth Street", "Houston", "Alabama", "38807", "United States" ) ),
                new UserRequest("Sophia", "Brown", "sophia.brown@x.dummyjson.com", "+81 210-652-2785", new AddressDTO("1642 Ninth Street", "Washington", "Alabama", "32822", "United States" ) ),
                new UserRequest("James", "Davis", "james.davis@x.dummyjson.com", "+49 614-958-9364", new AddressDTO("238 Jefferson Street", "Seattle", "Pennsylvania", "68354", "United States" ) ),
                new UserRequest("Emma", "Miller", "emma.miller@x.dummyjson.com", "+91 759-776-1614", new AddressDTO("607 Fourth Street", "Jacksonville", "Colorado", "26593", "United States" ) ),
                new UserRequest("Olivia", "Wilson", "olivia.wilson@x.dummyjson.com", "+91 607-295-6448", new AddressDTO("547 First Street", "Fort Worth", "Tennessee", "83843", "United States" ) ),
                new UserRequest("Alexander", "Jones", "alexander.jones@x.dummyjson.com", "+61 260-824-4986", new AddressDTO("664 Maple Street", "Indianapolis", "Delaware", "86684", "United States" ) ),
                new UserRequest("Ava", "Taylor", "ava.taylor@x.dummyjson.com", "+1 458-853-7877", new AddressDTO("1197 First Street", "Fort Worth", "Rhode Island", "24771", "United States" ) ),
                new UserRequest("Ethan", "Martinez", "ethan.martinez@x.dummyjson.com", "+92 933-608-5081", new AddressDTO("466 Pine Street", "San Antonio", "Louisiana", "72360", "United States" ) ),
                new UserRequest("Isabella", "Anderson", "isabella.anderson@x.dummyjson.com", "+49 770-658-4885", new AddressDTO("1964 Oak Street", "New York", "Utah", "89352", "United States" ) ),
                new UserRequest("Liam", "Garcia", "liam.garcia@x.dummyjson.com", "+92 870-217-6201", new AddressDTO("576 Fifth Street", "Denver", "South Dakota", "57252", "United States" ) ),
                new UserRequest("Mia", "Rodriguez", "mia.rodriguez@x.dummyjson.com", "+49 989-461-8403", new AddressDTO("1627 Sixth Street", "Jacksonville", "West Virginia", "41810", "United States" ) ),
                new UserRequest("Noah", "Hernandez", "noah.hernandez@x.dummyjson.com", "+49 393-605-6968", new AddressDTO("1413 Maple Street", "New York", "North Dakota", "73696", "United States" ) ),
                new UserRequest("Charlotte", "Lopez", "charlotte.lopez@x.dummyjson.com", "+44 373-953-5028", new AddressDTO("208 Second Street", "Columbus", "Ohio", "42044", "United States" ) ),
                new UserRequest("William", "Gonzalez", "william.gonzalez@x.dummyjson.com", "+81 905-252-7319", new AddressDTO("31 Maple Street", "San Jose", "Utah", "78243", "United States" ) ),
                new UserRequest("Avery", "Perez", "avery.perez@x.dummyjson.com", "+61 731-431-3457", new AddressDTO("1125 First Street", "Columbus", "Iowa", "30973", "United States" ) )
//                new UserRequest("Evelyn", "Sanchez", "evelyn.sanchez@x.dummyjson.com", "+1 623-880-6871", new AddressDTO("1170 Lincoln Street", "San Diego", "Wyoming", "43423", "United States" ) ),
//                new UserRequest("Logan", "Torres", "logan.torres@x.dummyjson.com", "+81 507-434-8733", new AddressDTO("907 Seventh Street", "Columbus", "Arkansas", "78805", "United States" ) ),
//                new UserRequest("Abigail", "Rivera", "abigail.rivera@x.dummyjson.com", "+91 228-363-7806", new AddressDTO("996 Oak Street", "Chicago", "New Mexico", "11407", "United States" ) ),
//                new UserRequest("Jackson", "Evans", "jackson.evans@x.dummyjson.com", "+44 468-628-6686", new AddressDTO("1873 Main Street", "New York", "Arkansas", "26600", "United States" ) ),
//                new UserRequest("Madison", "Collins", "madison.collins@x.dummyjson.com", "+81 259-957-5711", new AddressDTO("1892 Lincoln Street", "Philadelphia", "New Jersey", "62091", "United States" ) ),
//                new UserRequest("Elijah", "Stewart", "elijah.stewart@x.dummyjson.com", "+44 468-357-7872", new AddressDTO("1701 Eighth Street", "Columbus", "Illinois", "31585", "United States" ) ),
//                new UserRequest("Chloe", "Morales", "chloe.morales@x.dummyjson.com", "+92 468-541-7133", new AddressDTO("401 Fourth Street", "Dallas", "New Jersey", "54972", "United States" ) ),
//                new UserRequest("Mateo", "Nguyen", "mateo.nguyen@x.dummyjson.com", "+1 341-597-6694", new AddressDTO("1578 Fourth Street", "Columbus", "Missouri", "20673", "United States" ) ),
//                new UserRequest("Harper", "Kelly", "harper.kelly@x.dummyjson.com", "+92 518-863-2863", new AddressDTO("1591 Adams Street", "Philadelphia", "New York", "69521", "United States" ) ),
//                new UserRequest("Evelyn", "Gonzalez", "evelyn.gonzalez@x.dummyjson.com", "+61 708-508-4638", new AddressDTO("1065 Lincoln Street", "Dallas", "Maine", "84898", "United States" ) ),
//                new UserRequest("Daniel", "Cook", "daniel.cook@x.dummyjson.com", "+44 254-761-6843", new AddressDTO("1163 Pine Street", "Los Angeles", "Nevada", "58781", "United States" ) ),
//                new UserRequest("Lily", "Lee", "lily.lee@x.dummyjson.com", "+1 808-757-9867", new AddressDTO("1946 Oak Street", "Phoenix", "Massachusetts", "41540", "United States" ) ),
//                new UserRequest("Henry", "Hill", "henry.hill@x.dummyjson.com", "+1 240-833-4680", new AddressDTO("1837 Maple Street", "Indianapolis", "Delaware", "81783", "United States" ) ),
//                new UserRequest("Addison", "Wright", "addison.wright@x.dummyjson.com", "+1 514-384-3300", new AddressDTO("568 Tenth Street", "San Francisco", "Montana", "54698", "United States" ) )
                );
        userRequestList.forEach(userService::addUser);
    }*/
}