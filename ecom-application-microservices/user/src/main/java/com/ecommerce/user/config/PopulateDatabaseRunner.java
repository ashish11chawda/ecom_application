package com.ecommerce.user.config;

import com.ecommerce.user.dto.AddressDTO;
import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PopulateDatabaseRunner implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
//        populateUsers();
//        populateProducts();
//        populateCarts();
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
    }
}