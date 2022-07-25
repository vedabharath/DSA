package com.bharath.skills.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

class User{
     int id;
     String name;
     String username;
     String email;
     Address address;
     String website;
     Company company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

class Address{

    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}

class Geo{
    String lat;
    String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}

class Company{
    String name;
    String basename;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }
}

public class APICall {

    public static List<Integer> getAPIUsers(List<String> input)  {

        String surl = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";

        List<User> users = null;

        StringBuilder json = new StringBuilder();

        try {

            URL url = new URL(surl);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setRequestMethod("GET");
            uc.connect();

            Scanner in = new Scanner(url.openStream());

            while(in.hasNextLine()){

                json.append(in.nextLine());
            }

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();

            users = gson.fromJson(new InputStreamReader(uc.getInputStream()), new TypeToken<List<User>>(){}.getType());

//            for(User u: users)
//                System.out.println(u.getAddress().getGeo().getLat());

        } catch (Exception e) {
            System.out.print("Exception occurred "+e.getMessage());
        }

        List<Integer> res = new ArrayList<>();

        String attribute = input.get(0);
        String value = input.get(1);

        if("EQUALS".equals(input.get(2))){

            for(User u: users){

                if("id".equals(attribute) && u.getId() == Integer.parseInt(value))
                    res.add(u.getId());
                else if("username".equals(attribute) && u.getUsername().equals(value))
                    res.add(u.getId());
                else if("name".equals(attribute) && u.getName().equals(value))
                    res.add(u.getId());
                else if("email".equals(attribute) && u.getEmail().equals(value))
                    res.add(u.getId());
                else if("website".equals(attribute) && u.getWebsite().equals(value))
                    res.add(u.getId());
                else if("address.street".equals(attribute) && u.getAddress().getStreet().equals(value))
                    res.add(u.getId());
                else if("address.city".equals(attribute) && u.getAddress().getCity().equals(value))
                    res.add(u.getId());
                else if("address.suite".equals(attribute) && u.getAddress().getSuite().equals(value))
                    res.add(u.getId());
                else if("address.zipcode".equals(attribute) && u.getAddress().getZipcode().equals(value))
                    res.add(u.getId());
                else if("address.geo.lat".equals(attribute) && u.getAddress().getGeo().getLat().equals(value))
                    res.add(u.getId());
                else if("address.geo.lng".equals(attribute) && u.getAddress().getGeo().getLng().equals(value))
                    res.add(u.getId());
                else if("company.name".equals(attribute) && u.getCompany().getName().equals(value))
                    res.add(u.getId());
                else if("company.basename".equals(attribute) && u.getCompany().getBasename().equals(value))
                    res.add(u.getId());

            }

        }else {

            HashSet<String> set = new HashSet<>(Arrays.asList(value.split(",")));

            for (User u : users) {

                if ("id".equals(attribute) && set.contains(String.valueOf(u.getId())))
                    res.add(u.getId());
                else if ("username".equals(attribute) && set.contains(u.getUsername()))
                    res.add(u.getId());
                else if ("name".equals(attribute) && set.contains(u.getName()))
                    res.add(u.getId());
                else if ("email".equals(attribute) && set.contains(u.getEmail()))
                    res.add(u.getId());
                else if ("website".equals(attribute) && set.contains(u.getWebsite()))
                    res.add(u.getId());
                else if ("address.street".equals(attribute) && set.contains(u.getAddress().getStreet()))
                    res.add(u.getId());
                else if ("address.city".equals(attribute) && set.contains(u.getAddress().getCity()))
                    res.add(u.getId());
                else if ("address.suite".equals(attribute) && set.contains(u.getAddress().getSuite()))
                    res.add(u.getId());
                else if ("address.zipcode".equals(attribute) && set.contains(u.getAddress().getZipcode()))
                    res.add(u.getId());
                else if ("address.geo.lat".equals(attribute) && set.contains(u.getAddress().getGeo().getLat()))
                    res.add(u.getId());
                else if ("address.geo.lng".equals(attribute) && set.contains(u.getAddress().getGeo().getLng()))
                    res.add(u.getId());
                else if ("company.name".equals(attribute) && set.contains(u.getCompany().getName()))
                    res.add(u.getId());
                else if ("company.basename".equals(attribute) && set.contains(u.getCompany().getBasename()))
                    res.add(u.getId());

            }
        }


        return res;



    }

    public static void main(String[] args) {

        //getAPIUsers(Arrays.asList("address.geo.lng","91.1496","EQUALS"));
        System.out.println(getAPIUsers(Arrays.asList("username","WilsonP","EQUALS")));
        System.out.println(getAPIUsers(Arrays.asList("address.geo.lng","-47.0653","EQUALS")));
        System.out.println(getAPIUsers(Arrays.asList("name","Patricia Wilson,Charvi Malhotra","IN")));
    }
}
