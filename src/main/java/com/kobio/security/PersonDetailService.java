package com.kobio.security;

import java.util.ArrayList;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("PersonDetailService")	
public class PersonDetailService implements UserDetailsService {
	
@Resource
@Autowired 
private PersonService personService;
	
	private org.springframework.security.core.userdetails.User Persondetails;
	
	
	@Transactional
	 public UserDetails loadUserByUsername(String Personname)
	            throws UsernameNotFoundException {
	        boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;
	        com.kobio.model.Person Person = getUserDetail(Personname);
	        System.out.println(Personname);
	         System.out.println(Person.getpassword());
	          System.out.println(Person.getusername());
	           System.out.println(Person.getRole());
	            
	            Persondetails = new User(Person.getusername(), 
	            					   Person.getpassword(),
	    		        			   enabled,
	    		        			   accountNonExpired,
	    		        			   credentialsNonExpired,
	    		        			   accountNonLocked,
	    		        			   getAuthorities(Person.getRole()));
	            return Persondetails;
	    }

	
	 public List<GrantedAuthority> getAuthorities(Integer role) {
      List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
      if (role.intValue()==1) {
          authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

      } else if (role.intValue() == 2) {
          authList.add(new SimpleGrantedAuthority("ROLE_USER"));
      }
      System.out.println(authList);
      return authList;
  }
	 @Transactional
	public com.kobio.model.Person getUserDetail(String Personname) {
		// TODO Auto-generated method stub
	 	com.kobio.model.Person user = personService.getPersonbyPersonname(Personname);
	 	return user;
     
	}
	  
	  
	

}
