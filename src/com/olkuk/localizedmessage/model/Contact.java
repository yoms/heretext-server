package com.olkuk.localizedmessage.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Contact {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String regId;
     
    public Contact() {}
     
    public Contact(String email, String regId) {
        this.email = email;
        this.setRegId(regId);
    }
     
    public static Contact find(String email, EntityManager em) {
        Query q = em.createQuery("select c from Contact c where c.email = :email");
        q.setParameter("email", email);
        List<Contact> result = q.getResultList();
         
        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}
 
    //getters and setters for fields
}
   
