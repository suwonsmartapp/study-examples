
package com.suwonsmartapp.studyexam.db;

/**
 * Created by junsuk on 15. 4. 11..
 */
public class Person {
    private String name;
    private String email;

    public Person(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
