package Exercise4_15;

/**
 * Created by benjaminzhang on 17/04/2017.
 * Copyright © benjaminzhang 2017.
 */
class Address {
    private String name = "Null", email = "Null";

    Address(String name, String email){
        this.name = name;
        this.email = email;
    }

    protected void getAddressInfo(){
        System.out.println("Name: "+name+"\t\tEmail: "+email);
    }

}
